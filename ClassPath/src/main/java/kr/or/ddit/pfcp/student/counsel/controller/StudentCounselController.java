package kr.or.ddit.pfcp.student.counsel.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.servlet.http.HttpSession;
import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.pfcp.common.vo.CounselReqVO;
import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.student.counsel.service.StudentCounselService;
import kr.or.ddit.validate.utils.ErrorsUtils;
import lombok.RequiredArgsConstructor;

/**
 * @author seokyungdeok
 * @since 250630
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * -----------------------------------------------
 * 250630	|	서경덕	|	최초 생성
 * 250702	|	서경덕	|	insertFormUI, insertFormProcess 생성
 */
@Controller
@RequestMapping("/student/counsel")
@RequiredArgsConstructor
public class StudentCounselController {
	private final StudentCounselService service;
	
	static final String MODELNAME = "counselReq";

	@Autowired
	private ErrorsUtils errorsUtils;
	
	@ModelAttribute(MODELNAME)
	public CounselReqVO counselReq() {
		return new CounselReqVO();
	}
	
	@GetMapping("availableTimes.do")
	@ResponseBody
	public List<Map<String, Object>> getAvailableTimes(@RequestParam("userNo") String userNo) {
	    return service.readAvailableTimesByProfessor(userNo);
	}
	
	@GetMapping("professorList.do")
	@ResponseBody
	public List<LectureEnrVO> professorList(
		Principal principal
	) {
		String userNo = principal.getName();
		
		List<LectureEnrVO> professorList = service.readProfessorList(userNo);
		
		return professorList;
	}
	
	@GetMapping("counsel.do")
	public String counsel() {
		return "pfcp/student/counsel/counsel";
	}
	
	/**
	 * 학과 상담 신청 조회 (List)
	 * 
	 * @return
	 */
	@GetMapping("departmentCounsel/departmentCounsel.do")
	public String departmentCounselList(
		@RequestParam(required = false, defaultValue = "1") int page,
		Principal principal,
		Model model
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPageNo(page);
		
		int totalRecordCount = service.readDepartmentCounselTotalCount();
		paging.setTotalRecordCount(totalRecordCount);
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("userNo", principal.getName());
		paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
		paramMap.put("lastRecordIndex", paging.getLastRecordIndex());
		
		List<CounselReqVO> counselList = service.readStudentDepartmentCounselList(paramMap);
		
		model.addAttribute("counselList", counselList);
		model.addAttribute("count", totalRecordCount);
		model.addAttribute("paging", paging);
		
		return "pfcp/student/counsel/departmentCounsel/departmentCounsel";
	}
	
	/**
	 * 학과 상담 신청 상세 조회 (Detail)
	 * 
	 * @return
	 */
	@GetMapping("departmentCounsel/departmentCounselDetail.do")
	public String departmentCounselDetail() {
		return "pfcp/student/counsel/departmentCounsel/departmentCounselDetail";
	}
	
	/**
	 * 학과 상담 신청 등록 (formUI)
	 * 
	 * @return
	 */
	@GetMapping("departmentCounsel/departmentCounselInsert.do")
	public String departmentCounselInsertFormUI(
		Principal principal, 
		Model model
	) {
		String studentNo = principal.getName();  // 로그인된 사용자 ID (userNo)
	    model.addAttribute("studentNo", studentNo);
	    
		return "pfcp/student/counsel/departmentCounsel/departmentCounselInsert";
	}
	
	/**
	 * 학과 상담 신청 등록 (formProcess)
	 * 
	 * @return
	 */
	@PostMapping("departmentCounsel/departmentCounselInsertProcess.do")
	public String departmentCounselInsertFormProcess(
		@ModelAttribute(MODELNAME) CounselReqVO counselReq,
		Principal principal,
		BindingResult errors,
		RedirectAttributes redirectAttributes
	) {
		String lvn;
		
		if (!errors.hasErrors()) {
			counselReq.setUserNo(principal.getName());
			
			service.createStudentCounsel(counselReq);
			
			lvn = "redirect:/student/counsel/departmentCounsel/departmentCounsel.do";
		} else {
			redirectAttributes.addFlashAttribute(MODELNAME, counselReq);
			
			MultiValueMap<String, String> customErrors = errorsUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);
			
			lvn = "redirect:/student/counsel/departmentCounsel/departmentCounselInsert.do";
		}
		
		return lvn;
	}
	
	/**
	 * 학과 상담 신청 수정 
	 * 
	 * @return
	 */
	@GetMapping("departmentCounsel/departmentCounselUpdate.do")
	public String departmentCounselUpdate() {
		return "pfcp/student/counsel/departmentCounsel/departmentCounselUpdate";
	}
	
	/**
	 * 학과 상담 신청 삭제
	 * 
	 * @return
	 */
	@GetMapping("departmentCounsel/departmentCounselDelete.do")
	public String departmentCounselDelete(
		@RequestParam String no
	) {
		service.removeStudentDepartmentCounsel(no);
		
		return "redirect:/student/counsel/departmentCounsel/departmentCounsel.do";
	}
	
	/**
	 * 취업 상담 신청 조회 (List)
	 * 
	 * @return
	 */
	@GetMapping("employmentCounsel/employmentCounsel.do")
	public String employmentCounselList(
		@RequestParam(required = false, defaultValue = "1") int page,
		Principal principal,
		Model model
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPageNo(page);
		
		int totalRecordCount = service.readEmploymentCounselTotalCount();
		paging.setTotalRecordCount(totalRecordCount);
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("userNo", principal.getName());
		paramMap.put("firstRecordIndex", paging.getFirstRecordIndex());
		paramMap.put("lastRecordIndex", paging.getLastRecordIndex());
		
		List<CounselReqVO> counselList = service.readStudentEmploymentCounselList(paramMap);
		
		model.addAttribute("counselList", counselList);
		model.addAttribute("count", totalRecordCount);
		model.addAttribute("paging", paging);
		
		return "pfcp/student/counsel/employmentCounsel/employmentCounsel";
	}
	
	/**
	 * 취업 상담 신청 상세 조회 (Detail)
	 * 
	 * @return
	 */
	@GetMapping("employmentCounsel/employmentCounselDetail.do")
	public String employmentCounselDetail() {
		return "pfcp/student/counsel/employmentCounsel/employmentCounselDetail";
	}
	
	/**
	 * 취업 상담 신청 등록 (formUI)
	 * 
	 * @return
	 */
	@GetMapping("employmentCounsel/employmentCounselInsert.do")
	public String employmentCounselInsertFormUI(
		Principal principal, 
		Model model
	) {
		String studentNo = principal.getName();  // 로그인된 사용자 ID (userNo)
	    model.addAttribute("studentNo", studentNo);
	    
		return "pfcp/student/counsel/employmentCounsel/employmentCounselInsert";
	}
	
	/**
	 * 취업 상담 신청 등록 (formProcess)
	 * 
	 * @return
	 */
	@PostMapping("employmentCounsel/employmentCounselInsertProcess.do")
	public String employmentCounselInsertFormProcess(
		@ModelAttribute(MODELNAME) CounselReqVO counselReq,
		Principal principal,
		BindingResult errors,
		RedirectAttributes redirectAttributes
	) {
		String lvn;
		
		if (!errors.hasErrors()) {
			counselReq.setUserNo(principal.getName());
			
			service.createStudentCounsel(counselReq);
			
			lvn = "redirect:/student/counsel/employmentCounsel/employmentCounsel.do";
		} else {
			redirectAttributes.addFlashAttribute(MODELNAME, counselReq);
			
			MultiValueMap<String, String> customErrors = errorsUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);
			
			lvn = "redirect:/student/counsel/employmentCounsel/employmentCounselInsert.do";
		}
		
		return lvn;
	}
	
	/**
	 * 취업 상담 신청 수정
	 * 
	 * @return
	 */
	@GetMapping("employmentCounsel/employmentCounselUpdate.do")
	public String employmentCounselUpdate() {
		return "pfcp/student/counsel/employmentCounsel/employmentCounselUpdate";
	}
	
	/**
	 * 취업 상담 신청 삭제
	 * 
	 * @return
	 */
	@GetMapping("employmentCounsel/employmentCounselDelete.do")
	public String employmentCounselDelete() {
		return "redirect:/student/counsel/employmentCounsel/employmentCounsel.do";
	}
}
