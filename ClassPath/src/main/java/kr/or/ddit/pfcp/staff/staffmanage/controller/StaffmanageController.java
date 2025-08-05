package kr.or.ddit.pfcp.staff.staffmanage.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.pfcp.common.vo.DepartmentVO;
import kr.or.ddit.pfcp.common.vo.StaffVO;
import kr.or.ddit.pfcp.common.vo.TypeVO;
import kr.or.ddit.pfcp.staff.professormanage.service.StaffProfessorManageService;
import kr.or.ddit.pfcp.staff.staffmanage.service.StaffmanageService;
import kr.or.ddit.validate.utils.ErrorsUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YSM
 * @since 250724
 * 
 * 
 * * 수정일		수정자		수정 내용
 * ---------------------------------------
 * 20250724     양수민        최초 생성
 */

@Slf4j
@Controller
@RequestMapping("/staff/staffmanage")
public class StaffmanageController {

	@Autowired
	private StaffProfessorManageService staffProfessorService;
	
	
	@Autowired
	private StaffmanageService staffmanageService;
	
	
	
	static final String MODELNAME = "staff";
	
	@Autowired
	private ErrorsUtils errorsUtils;
	
	@ModelAttribute(MODELNAME)
	public StaffVO staff() {
		return new StaffVO();
	}
	
	@GetMapping("bankCodeList.do")
	@ResponseBody
	public List<TypeVO> bankCodeList() {
		List<TypeVO> bankCodeList = staffProfessorService.readBankCodeList();
		
		return bankCodeList;
	}
	
	@GetMapping("departmentList.do")
	@ResponseBody
	public List<DepartmentVO> departmentList() {
		List<DepartmentVO> departmentList = staffProfessorService.readDepartmentList();
		
		return departmentList;
	}
	
	/**
     * @param userNo 조회할 사용자(직원)의 사번
     * @return JSON 응답 (예: {"userName": "홍길동"}) 또는 찾지 못했을 경우 빈 JSON (예: {})
     */
    @GetMapping("checkUserByNo.do")
    @ResponseBody // 이 어노테이션이 객체를 JSON으로 직렬화하여 HTTP 응답 본문에 작성하도록 지시합니다.
    public ResponseEntity<Map<String, String>> checkUserByNo(
            @RequestParam("userNo") String userNo // 프론트엔드에서 넘어오는 userNo 파라미터를 받습니다.
    ) {
        Map<String, String> response = new HashMap<>();
        // Service Layer를 통해 DB에서 userName을 조회합니다.
        String userName = staffmanageService.getUserNameByUserNo(userNo); // 이 메서드를 서비스에 추가해야 합니다.

        if (userName != null && !userName.isEmpty()) {
            response.put("userName", userName); // "userName" 키로 이름을 담습니다.
            return ResponseEntity.ok(response); // HTTP 200 OK와 함께 JSON 데이터를 반환
        } else {
            // 해당 userNo에 해당하는 사용자를 찾지 못한 경우
            // 빈 응답 또는 특정 메시지를 담아 반환할 수 있습니다.
            // 프론트엔드에서는 'userName' 키가 없는지 확인하여 처리하게 됩니다.
            return ResponseEntity.ok(response); // HTTP 200 OK와 함께 빈 JSON 반환
        }
    }
    
    /**
	 * 퇴직 교직원 목록 조회 (List)
	 * 
	 * @return
	 */
	@GetMapping("retiredList.do")
	public String retiredList(
		Model model,
		@RequestParam(required = false, defaultValue = "1") int page,
		@RequestParam(required = false) String keyword,
		@RequestParam(required = false, defaultValue = "all") String searchType
	) {
		PaginationInfo paging = new PaginationInfo();
		
		paging.setCurrentPageNo(page);
		
		int totalRecordCount;
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("keyword", keyword);
		paramMap.put("searchType", searchType);
		
		if (keyword != null && !keyword.trim().isEmpty()) {
			totalRecordCount = staffmanageService.readStaffTotalCountByKeyword(paramMap);
		} else {
			totalRecordCount = staffmanageService.readStaffTotalCountR();
		}
		
		paging.setTotalRecordCount(totalRecordCount); 
		
		paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
	    paramMap.put("lastRecordIndex", paging.getLastRecordIndex());
		
		List<StaffVO> staff = staffmanageService.readStaffListR(paramMap);
		
		model.addAttribute("staff", staff);
		model.addAttribute("count", totalRecordCount);
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchType", searchType);
		
		return "pfcp/staff/staffmanage/staffmanageListRetired";
	}

	/**
	 * 교직원 목록 조회 (List)
	 * 
	 * @return
	 */
	@GetMapping("staffmanageList.do")
	public String professorList(
		Model model,
		@RequestParam(required = false, defaultValue = "1") int page,
		@RequestParam(required = false) String keyword,
		@RequestParam(required = false, defaultValue = "all") String searchType
	) {
		PaginationInfo paging = new PaginationInfo();
		
		paging.setCurrentPageNo(page);
		
		int totalRecordCount;
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("keyword", keyword);
		paramMap.put("searchType", searchType);
		
		if (keyword != null && !keyword.trim().isEmpty()) {
			totalRecordCount = staffmanageService.readStaffTotalCountByKeyword(paramMap);
		} else {
			totalRecordCount = staffmanageService.readStaffTotalCount();
		}
		
		paging.setTotalRecordCount(totalRecordCount); 
		
		paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
	    paramMap.put("lastRecordIndex", paging.getLastRecordIndex());
		
		List<StaffVO> staff = staffmanageService.readStaffList(paramMap);
		
		model.addAttribute("staff", staff);
		model.addAttribute("count", totalRecordCount);
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchType", searchType);
		
		return "pfcp/staff/staffmanage/staffmanageList";
	}
	
	/**
	 * 교직원 상세 조회 (Detail)
	 * 
	 * @return
	 */
	@GetMapping("staffDetail.do")
	public String staffDetail(@RequestParam String no, Model model) {
	    StaffVO staff = staffmanageService.readStaff(no);
	    List<TypeVO> bankList = staffProfessorService.readBankCodeList(); // 은행 코드 조회

	    model.addAttribute("staff", staff);
	    model.addAttribute("bankList", bankList);

	    return "pfcp/staff/staffmanage/staffDetail";
	}

	/**
	 * 교직원 수정 formProcess
	 * 
	 * @return
	 */
	@PostMapping("staffUpdateProcess.do")
	public String professorUpdateProcess(
		@RequestParam String no, 
		@ModelAttribute(MODELNAME) StaffVO staff,
		BindingResult errors, 
		RedirectAttributes redirectAttributes
	) {
		String lvn;
		
		staff.setUserNo(staff.getUser().getUserNo());
		
//		if (!errors.hasErrors()) {
//			if (staff.getStaffRdate() != null) {
//	            // 퇴직이면 deleteProfessor 수행
//				staffmanageService.removeStaff(staff.getUserNo());
//				staffmanageService.modifyStaff(staff);
//	        } else {
//	            // 그 외는 update 수행
//	        	staffmanageService.modifyStaff(staff);
//	        }
//	}
			
		staffmanageService.modifyStaff(staff);
		
		redirectAttributes.addFlashAttribute(MODELNAME, staff);
		
		MultiValueMap<String, String> customErrors = errorsUtils.errorsToMap(errors);
		
		redirectAttributes.addFlashAttribute("errors", customErrors);
		
		
		lvn = "redirect:/staff/staffmanage/staffDetail.do?no=" + no;
		
		redirectAttributes.addFlashAttribute("success", "수정 완료!");

		return lvn;
	}
	
	/**
	 * 교직원 등록 formUI
	 * 
	 * @return
	 */
	@GetMapping("staffInsertFormAD.do")
	public String staffInsertFormUI(
		Principal principal,
		Model model
	) {
		return "pfcp/staff/staffmanage/staffInsertAD";
	}
	
	/**
	 * 교직원 등록 formProcess
	 * 
	 * @return
	 */
	@PostMapping("staffInsertProcess.do")
	public String staffInsertFormProcess(
		@ModelAttribute(MODELNAME) StaffVO staff,
		BindingResult errors,
		RedirectAttributes redirectAttributes
	) {
		String lvn;
		
		if(!errors.hasErrors()) {
			staff.setUserRole("ROLE_STAFF");
			staff.setUserPass("{bcrypt}$2a$10$kmoNG3guGOmsEM3BdxvLYOIEKAf92GEVZG6JaurQkpf5MWYbBmut6");	// Default
			
			staffmanageService.createStaff(staff);
			
			lvn = "redirect:/staff/staffmanage/staffmanageList.do";
			
			redirectAttributes.addFlashAttribute("success", "등록 완료!");
		} else {
			redirectAttributes.addFlashAttribute(MODELNAME, staff);
			
			MultiValueMap<String, String> customErrors = errorsUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);
			
			lvn = "redirect:/staff/staffmanage/staffInsert.do";
			
			redirectAttributes.addFlashAttribute("success", "문제가 발생하였습니다.");
		}
		return lvn;
	}

	/**
	 * 조교 등록 formUI
	 * 
	 * @return
	 */
	@GetMapping("staffInsertFormST.do")
	public String staffSTInsertFormUI(
		Principal principal,
		Model model
	) {
		return "pfcp/staff/staffmanage/staffInsertST";
	}
	
	@PostMapping("studentStaffInsertProcess.do")
    public String staffInsertProcess(
    	@ModelAttribute(MODELNAME) StaffVO staff, // 폼에서 제출된 데이터가 바인딩. user.userNo와 user.userName 포함
        RedirectAttributes rttr,
        Model model // 모델에 에러 메시지를 담기 위해
    ) {
        String submittedUserNo = staff.getUser().getUserNo();
        String actualUserNameFromDB = staffmanageService.getUserNameByUserNo(submittedUserNo);

        if (actualUserNameFromDB == null || !actualUserNameFromDB.equals(staff.getUser().getUserName())) {
            rttr.addFlashAttribute("errorMessage", "사번과 이름 정보가 일치하지 않거나 유효하지 않습니다. 다시 확인해주세요.");
            return "redirect:/staff/staffmanage/staffInsertFormST.do";
        }

        if (!submittedUserNo.startsWith("ST")) {
            rttr.addFlashAttribute("errorMessage", "본교 학생만 조교로 등록할 수 있습니다.");
            return "redirect:/staff/staffmanage/staffInsertFormST.do";
        }

        try {
        	staff.setUserRole("ROLE_STAFF");
        	
            staffmanageService.createStudentStaff(staff); // 실제 등록 로직 호출
            rttr.addFlashAttribute("success", "조교 등록이 성공적으로 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("errorMessage", "조교 등록 중 오류가 발생했습니다: " + e.getMessage());
        }

        return "redirect:/staff/staffmanage/staffmanageList.do"; 
    }
	
	@GetMapping("updateRdate.do")
	public String updateRdate(
		@RequestParam String no, 
		Model model,
		RedirectAttributes redirectAttributes
	) {
		staffmanageService.modifyRdate(no);
		
		redirectAttributes.addFlashAttribute("success", "퇴직처리하였습니다.");
		
		return "redirect:/staff/staffmanage/staffmanageList.do"; 
	}
	
}
