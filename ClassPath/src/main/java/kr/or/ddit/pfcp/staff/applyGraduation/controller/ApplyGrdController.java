package kr.or.ddit.pfcp.staff.applyGraduation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.pfcp.common.vo.GraduationRequirementVO;
import kr.or.ddit.pfcp.staff.applyGraduation.service.ApplyGrdSerive;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/staff/applyGrd")
public class ApplyGrdController {

	@Autowired
	private ApplyGrdSerive grdService;
	@GetMapping("/graduateApply.do")
	public String graduateList(
	        @RequestParam(name = "page", defaultValue = "1") int currentPageNo,
	        @RequestParam(name = "searchType", required = false) String searchType,
	        @RequestParam(name = "keyword", required = false) String keyword,
	        @RequestParam(name = "eligible", required = false) String eligible,
	        Model model
	) {
	    int totalCount = grdService.readTotalGradutionCount(searchType, keyword,eligible);

	    log.info("{}>>>>>>>", eligible);
	    // PaginationInfo 객체 생성 및 설정
	    PaginationInfo paging = new PaginationInfo();
	    paging.setCurrentPageNo(currentPageNo);
	    paging.setTotalRecordCount(totalCount);

	    // 조회 파라미터 구성
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("searchType", searchType);
	    paramMap.put("keyword", keyword);
	    paramMap.put("eligible", eligible); 
	    paramMap.put("start", paging.getFirstRecordIndex()); 
	    paramMap.put("end", paging.getLastRecordIndex());    

	    List<GraduationRequirementVO> grdList = grdService.readGradutionList(paramMap);

	    model.addAttribute("grdList", grdList);
	    model.addAttribute("paging", paging);
	    model.addAttribute("searchType", searchType);
	    model.addAttribute("keyword", keyword);
	    model.addAttribute("eligible", eligible);
	    model.addAttribute("count", totalCount);

	    return "pfcp/staff/college/graduateApply";
	}
	@PostMapping("/bulkApply.do")
	public String bulkApply(
			@RequestParam(name = "searchType", required = false) String searchType,
		    @RequestParam(name = "keyword", required = false) String keyword,
		    @RequestParam(name = "eligible", required = false) String eligible,
		    RedirectAttributes redirectAttributes
		    ) {
		  Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("searchType", searchType);
		    paramMap.put("keyword", keyword);
		    paramMap.put("eligible", eligible);
		    log.info("{}>>>>>>>", eligible);
		    log.info("{}>>>>>>>", keyword);
		    log.info("{}>>>>>>>", searchType);
		    
			  int updateCount = grdService.bulkApply(paramMap);
			  redirectAttributes.addFlashAttribute("success", updateCount + "명 졸업처리 완료");
			 
		    return "redirect:/staff/applyGrd/graduateApply.do";
	}



}
