package kr.or.ddit.pfcp.staff.thesis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.pfcp.common.service.AtchFileService;
import kr.or.ddit.pfcp.common.service.FileRefService;
import kr.or.ddit.pfcp.common.vo.AtchFileVO;
import kr.or.ddit.pfcp.common.vo.FileRefVO;
import kr.or.ddit.pfcp.common.vo.ThesisVO;
import kr.or.ddit.pfcp.professor.thesis.service.ProfessorThesisService;
import kr.or.ddit.pfcp.staff.thesis.service.StaffThesisService;
import lombok.extern.slf4j.Slf4j;


/**
 * @author 김태수
 * @since 2025. 7. 22.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 22.	|	김태수	|	최초 생성
 */
@Controller
@RequestMapping("/staff/thesis")
@Slf4j
public class ThesisController {
	
	@Autowired
	private StaffThesisService staffThesisService;
	
	@Autowired
	private ProfessorThesisService professorThesisService;
	
	@Autowired
	private FileRefService fileRefService;
	
	@Autowired
	private AtchFileService atchFileService;

	/**
	 * 논문 목록 조회
	 * @return
	 */
	@GetMapping("thesisList.do")
	public String thesis(
			Model model
		) {
		List<ThesisVO> waitingThesisList = staffThesisService.waitThesisList();
        model.addAttribute("thesisList", waitingThesisList); 
        model.addAttribute("currentStatus", "대기"); 
		return "pfcp/staff/thesis/thesisList";
	}
	
	/**
	 * 논문 등록
	 * @return
	 */
	@GetMapping("thesisInsert.do")
	public String thesisInsert() {
		return "pfcp/staff/thesis/thesisInsert";
	}
	
	/**
	 * 논문 상세 조회
	 * 
	 * @return
	 */
	@GetMapping("thesisDetail.do")
	public String thesisDetail(
			@RequestParam(value = "no", required = false) String no, 
			Model model
		) {
		ThesisVO thesis = professorThesisService.readThesisDetail(no);
		if (thesis == null) {
			throw new IllegalArgumentException("해당 논문 정보를 찾을 수 없습니다: " + no);
		}

		if (thesis.getFileRefNo() != null) {
			FileRefVO fileRef = fileRefService.readFileRef(thesis.getFileRefNo());

			if (fileRef != null) {
				AtchFileVO atchFile = atchFileService.readAtchFile(fileRef.getAtchId());
				thesis.setAtchFile(atchFile);
			}
		}
		model.addAttribute("thesis", thesis);
		return "pfcp/staff/thesis/thesisDetail";
	}
	
	 @PostMapping("approveThesis.do")
	    public String approveThesis(
	    		@RequestParam("thesisNo") String thesisNo
	    		, RedirectAttributes ra
	    ) {
	        staffThesisService.approveThesis(thesisNo); 
	        return "redirect:/staff/thesis/thesisList.do";
	    }

	    // 논문 반려 처리
	    @PostMapping("rejectThesis.do")
	    public String rejectThesis(
	    		@RequestParam("thesisNo") String thesisNo
	    		,@RequestParam("rejReason") String rejReason
	    		,RedirectAttributes ra
	    ) {
	        staffThesisService.rejectThesis(thesisNo, rejReason);
	        return "redirect:/staff/thesis/thesisList.do";
	    }
	    
	   
}
