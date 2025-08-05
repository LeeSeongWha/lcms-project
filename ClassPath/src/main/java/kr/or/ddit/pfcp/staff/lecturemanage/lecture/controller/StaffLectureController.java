package kr.or.ddit.pfcp.staff.lecturemanage.lecture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.common.vo.LectureVO;
import kr.or.ddit.pfcp.common.vo.StudentVO;
import kr.or.ddit.pfcp.staff.lecturemanage.lecture.service.StaffLectureService;
import kr.or.ddit.validate.utils.ErrorsUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YSM
 * @since 250628
 */
@Slf4j
@Controller
@RequestMapping("/staff/lecturemanage/lecture")

public class StaffLectureController {
	
	@Autowired
	private StaffLectureService service;
	
	static final String MODELNAME = "lecture";
	
	@ModelAttribute(MODELNAME)
	public LectureVO lecture() {
		return new LectureVO();
	}
	
	@Autowired
	private ErrorsUtils errorsUtils;
	
	//=========================================================================================
	
	/**
	 * 강의 목록 전체 조회
	 * @return
	 */
	@GetMapping("lectureList.do")
	public String lectureListUI(
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
			totalRecordCount = service.readLectureTotalCountByKeyword(paramMap);
		} else {
			totalRecordCount = service.readLectureTotalCount();
		}
		
		paging.setTotalRecordCount(totalRecordCount);

		paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
	    paramMap.put("lastRecordIndex", paging.getLastRecordIndex());
	    
		List<LectureVO> lecture = service.readLectureList(paramMap);
		model.addAttribute("lecture", lecture);
		log.info("lecture" + lecture);
		
		model.addAttribute("count", totalRecordCount);
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchType", searchType);
		
		
		return "pfcp/staff/lecturemanage/lecture/lectureList";
	}
	
	/**
	 * 강의 상세 조회
	 * @return
	 */
	@GetMapping("lectureDetail.do")
	public String lectureDetailUI(
		@RequestParam String what,
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
			totalRecordCount = service.readLectureStudentTotalCountByKeyword(paramMap);
		} else {
			totalRecordCount = service.readLectureStudentTotalCount(what);
		}
		
		paging.setTotalRecordCount(totalRecordCount);

		paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
	    paramMap.put("lastRecordIndex", paging.getLastRecordIndex());
	    paramMap.put("lecNo", what);
	    
		List<LectureEnrVO> lectureStudent = service.readLectureStudent(paramMap);
		model.addAttribute("lectureStudent", lectureStudent);
		log.info("lectureStudent" + lectureStudent);
		
		model.addAttribute("count", totalRecordCount);
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchType", searchType);
		
		
		
//		if (!lectureStudent.isEmpty()) {
//		    model.addAttribute("enrNo", lectureStudent.get(0).getEnrollNo());
//		    model.addAttribute("userName", lectureStudent.get(0).getUser().getUserName());
//		}
		
		return "pfcp/staff/lecturemanage/lecture/lectureDetail";
	}
	
}
