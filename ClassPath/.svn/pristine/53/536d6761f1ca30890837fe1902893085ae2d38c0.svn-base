package kr.or.ddit.pfcp.professor.evaluation.service;

import java.util.List;

import kr.or.ddit.pfcp.common.vo.LectureEvalVO;

/**
 * @author 김태수
 * @since 2025. 7. 18.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 18.	|	김태수	|	최초 생성
 */
public interface ProfessorLectureEvalService {

	public List<LectureEvalVO> readEvals(String lecNp, int offset, int pageSize);
	public int countEvals(String lecNo);
	public Integer selectTotalScore(String lecNo);
	
	public List<LectureEvalVO> evalDetail(String evalNo);
	public String evalComment(String evalNo);
}
