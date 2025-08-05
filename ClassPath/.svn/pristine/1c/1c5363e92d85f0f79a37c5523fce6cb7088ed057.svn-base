package kr.or.ddit.pfcp.staff.thesis.service;

import java.util.List;

import kr.or.ddit.pfcp.common.vo.ThesisVO;

/**
 * @author 김태수
 * @since 2025. 7. 22.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 22.	|	김태수	|	최초 생성
 */
public interface StaffThesisService {
	
	public List<ThesisVO> waitThesisList();
    public List<ThesisVO> thesisList(String status);
    public int approveThesis(String thesisNo); 
    public int rejectThesis(String thesisNo, String rejReason); 
}
