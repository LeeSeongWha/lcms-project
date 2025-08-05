package kr.or.ddit.pfcp.staff.tuition.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.pfcp.common.vo.CollegeVO;
import kr.or.ddit.pfcp.common.vo.DGRRequestVO;
import kr.or.ddit.pfcp.common.vo.DepartmentVO;
import kr.or.ddit.pfcp.staff.tuition.service.StaffTuitionService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YSM
 * @since 250717
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * -----------------------------------------------
 * 250717	|	양수민	|	최초 생성
 *
 */
@Slf4j
@Controller
@RequestMapping("/staff/tuition")
public class StaffTuitionController {
	
	
	@Autowired
	private StaffTuitionService staffTuitionService;
	
	/**
	 * 단과대학 목록 조회
	 * @return
	 */
	@GetMapping("tuitionList.do")
	public String tuitionListUI(
		Model model
	) {
		
		List<CollegeVO> collegeList = staffTuitionService.readCollegeList();
		int totalCount = collegeList.size();
		model.addAttribute("collegeList", collegeList);
		model.addAttribute("totalCount", totalCount);
		return "pfcp/staff/tuition/tuitionList";
	}
	
	/**
	 * 단과대 별 학과 출력
	 * @return
	 */
	@GetMapping("departmentList.do")
	@ResponseBody
	public List<Map<String, String>> getCollegeDetail(@RequestParam("no") String collegeNo) {
	    List<DepartmentVO> deptList = staffTuitionService.readDepartmentsByCollegeNo(collegeNo);

	    List<Map<String, String>> result = new ArrayList<>();
	    for (DepartmentVO dept : deptList) {
	        Map<String, String> map = new HashMap<>();
	        map.put("departmentNo", dept.getDepartmentNo());
	        map.put("dgrNo", dept.getDgrNo());
	        map.put("departmentName", dept.getDepartmentName());
	        Integer tuition = dept.getDepartmentTuition();
	        map.put("tuition", tuition != null ? tuition.toString() : "정보 없음");
	        result.add(map);
	    }

	    return result;
	}


	/**
	 * 학과 별 졸업 요건 출력
	 * @return
	 */
	@GetMapping("tuitionDgrReq.do")
	@ResponseBody
	public List<Map<String, String>> getDgrReq(@RequestParam("dgrNoData") String dgrNoData) {

		log.info("dgrNoData : {}", dgrNoData);
		
		List<DGRRequestVO> dgrReqList = staffTuitionService.readDgrReqByDgrNo(dgrNoData);
		
		List<Map<String, String>> result = new ArrayList<>();
		for (DGRRequestVO dgrReq : dgrReqList) {
	        Map<String, String> map = new HashMap<>();
	        
	        // 정보 꺼내기 시작 !
	        String dgrNo = dgrReq.getDgrNo();
	        map.put("dgrNo", dgrNo != null ? dgrNo : "정보 없음");

	        Integer dgrGrade = dgrReq.getDgrGrade();
	        map.put("dgrGrade", dgrGrade != null ? dgrGrade.toString() : "정보 없음");
	        
	        Integer dgrMc = dgrReq.getDgrMc();
	        map.put("dgrMc", dgrMc != null ? dgrMc.toString() : "정보 없음");
	        
	        Integer dgrLac = dgrReq.getDgrLac();
	        map.put("dgrLac", dgrLac != null ? dgrLac.toString() : "정보 없음");
	        
	        Integer dgrFcc = dgrReq.getDgrFcc();
	        map.put("dgrFcc", dgrFcc != null ? dgrFcc.toString() : "정보 없음");
	        
	        String dgrDate = dgrReq.getDgrDate();
	        map.put("dgrDate", dgrDate != null ? dgrDate : "정보 없음");
	        
	        Integer dgrVolunteerHour = dgrReq.getDgrVolunteerHour();
	        map.put("dgrVolunteerHour", dgrVolunteerHour != null ? dgrVolunteerHour.toString() : "정보 없음");
	        
	        result.add(map);
	    }
		return result;
	}
	
	
	/**
	 * 등록금 폼 등록
	 * @return
	 */
	@GetMapping("tuitionInsert.do")
	public String tuitionInsertUI() {
		return "pfcp/staff/tuition/tuitionInsert";
	}
	
	/**
	 * 등록금 폼 수정
	 * @return
	 */
	@PostMapping("tuitionUpdate.do")
	@ResponseBody
	public String tuitionUpdateUI(
			@RequestBody List<DepartmentVO> tuitionUpdateList,
			RedirectAttributes redirectAttributes
	) {
		for (DepartmentVO item : tuitionUpdateList) {
			String dgrNoData = item.getDgrNo();
			
			log.info("dgrNoData : {}", dgrNoData);
	        Integer departmentTuition = item.getDepartmentTuition();
	        

	        staffTuitionService.modifyTuitionIfChanged(dgrNoData, departmentTuition);
	    }
		redirectAttributes.addFlashAttribute("msg", "수정이 완료되었습니다.");
		
		
		return "redirect:/staff/tuition/departmentList.do";
	}
}
