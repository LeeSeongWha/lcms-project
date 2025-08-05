package kr.or.ddit.pfcp.staff.requestCollection.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.common.component.NotificationUtils;
import kr.or.ddit.pfcp.common.vo.AcademicChangeRequestVO;
import kr.or.ddit.pfcp.common.vo.DepartmentVO;
import kr.or.ddit.pfcp.staff.professormanage.service.StaffProfessorManageService;
import kr.or.ddit.pfcp.staff.requestCollection.service.StaffRequestService;
import kr.or.ddit.validate.utils.ErrorsUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YSM
 * @since 250724
 * 
 * 
 *        * 수정일 수정자 수정 내용 --------------------------------------- 20250724 양수민
 *        최초 생성
 */

@Slf4j
@Controller
@RequestMapping("/staff/requestCollection")
@RequiredArgsConstructor
public class StaffRequestController {

	private final StaffProfessorManageService professorService;
	private final StaffRequestService requestService;

	static final String MODELNAME = "request";

	@Autowired
	private ErrorsUtils errorsUtils;

	@ModelAttribute(MODELNAME)
	public AcademicChangeRequestVO request() {
		return new AcademicChangeRequestVO();
	}

	@GetMapping("departmentList.do")
	@ResponseBody
	public List<DepartmentVO> departmentList() {
		List<DepartmentVO> departmentList = professorService.readDepartmentList();

		return departmentList;
	}
	
	
	@PostMapping("requestUpdateProcess.do")
	public String requestUpdateProcess(
		String requestNo,
		String status, 
		String statusComment,
		String requestDepartmentNo,
		String typeCode,
		String studentNo,
		Principal principal, 
		RedirectAttributes redirectAttributes
	) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("requestNo", requestNo);
		paramMap.put("status", status);
		paramMap.put("statusComment", statusComment);
		paramMap.put("requestDepartmentNo", requestDepartmentNo);
		paramMap.put("typeCode", typeCode);
		paramMap.put("studentNo", studentNo);
		
		log.info("requestNo : {}", requestNo);
		log.info("status : {}", status);
		log.info("statusComment : {}", statusComment);
		log.info("requestDepartmentNo : {}", requestDepartmentNo);
		log.info("typeCode : {}", typeCode);
		log.info("studentNo : {}", studentNo);

		String handler = null;
		if (principal != null) {
			handler = principal.getName();
			paramMap.put("handler", handler);
			log.info("handler : {} ", handler);
		}

		int result = requestService.modifyRequest(paramMap);
		
		
		String mappingUrl = "";
		
		switch (typeCode) {
		    case "AC_MAJOR":
		    	mappingUrl = "/student/counsel/majorChangeList.do";
		        break;
		    case "AC_DOUBLE":
		    	mappingUrl = "/student/counsel/doubleMajorList.do";
		        break;
		    case "AC_GRADSUS":
		    	mappingUrl = "/student/counsel/graduationSuspensionList.do";
		    	break;
		    case "AC_RETURN":
		    	mappingUrl = "/student/counsel/returnApplyList.do";
		    	break;
		    case "AC_SUSPEND":
		    	mappingUrl = "/student/counsel/leaveApplyList.do";
		    	break;
		    default:
		    	mappingUrl = "localhost";
		        break;
		}
		
		
		if (result == 1) {
			redirectAttributes.addFlashAttribute("success", "처리되었습니다.");
			NotificationUtils.sendToOneStudent(studentNo, "학적 변경 처리가 완료되었습니다. 확인하세요.", mappingUrl);
		} else {
			redirectAttributes.addFlashAttribute("success", "다시 시도해주십시오.");
		}

		return "redirect:/staff/requestCollection/requestCollection.do";
	}

	
	/**
	 * 학적 변경 신청 목록 조회 (List)
	 *
	 * @return
	 */
	@GetMapping("requestCollection.do")
	public String professorList(Model model, 
       @RequestParam(required = false, defaultValue = "1") int page,
       @RequestParam(required = false) String keyword,
       @RequestParam(required = false, defaultValue = "all") String searchType,
       @RequestParam(required = false) String status,
       @RequestParam(required = false) String typeCode
    ) {
	    
	    // 상단 카드용 데이터 시작 ============================================================================
	    Map<String, Integer> requestStatusMap = new HashMap<>();
	    requestStatusMap.put("total", requestService.readTotalRequest());
	    requestStatusMap.put("waiting", requestService.readWaitingRequest());
	    requestStatusMap.put("rejected", requestService.readRejectedRequest());
	    requestStatusMap.put("processing", requestService.readProcessingRequest());
	    requestStatusMap.put("complete", requestService.readCompleteRequest());
	    model.addAttribute("requestStatus", requestStatusMap);
	    // 상단 카드용 데이터 끝 ============================================================================
	    
	    PaginationInfo paging = new PaginationInfo();
	    paging.setCurrentPageNo(page);

	    int totalRecordCount;
	    Map<String, Object> paramMap = new HashMap<>();

	    paramMap.put("keyword", keyword);
	    paramMap.put("searchType", searchType);
	    paramMap.put("status", status);
	    paramMap.put("typeCode", typeCode);

	    // 검색 키워드가 있는 경우와 없는 경우 분기 처리
	    if (keyword != null && !keyword.trim().isEmpty()) {
	        totalRecordCount = requestService.readRequestTotalCountByKeyword(paramMap);
	    } else {
	        // 키워드는 없지만 typeCode나 status 필터가 있는 경우도 고려
	        if ((typeCode != null && !typeCode.trim().isEmpty()) || 
	            (status != null && !status.trim().isEmpty())) {
	            totalRecordCount = requestService.readRequestTotalCountByKeyword(paramMap);
	        } else {
	            totalRecordCount = requestService.readRequestTotalCount();
	        }
	    }

	    paging.setTotalRecordCount(totalRecordCount);

	    paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
	    paramMap.put("lastRecordIndex", paging.getLastRecordIndex());

	    List<AcademicChangeRequestVO> requestList = requestService.readRequestList(paramMap);

	    log.info("requestList : {} ", requestList);

	    model.addAttribute("requestList", requestList);
	    model.addAttribute("count", totalRecordCount);
	    model.addAttribute("paging", paging);
	    model.addAttribute("keyword", keyword);
	    model.addAttribute("searchType", searchType);
	    model.addAttribute("status", status);
	    model.addAttribute("typeCode", typeCode); // 이 부분이 중요! typeCode를 모델에 추가

	    return "pfcp/staff/requestCollection/requestCollection";
	}
}

