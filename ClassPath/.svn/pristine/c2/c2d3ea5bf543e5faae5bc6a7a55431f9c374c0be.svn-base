package kr.or.ddit.pfcp.professor.evaluation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
@Mapper
public interface ProfessorLectureEvalMapper {

	public List<LectureEvalVO> selectEvals(
			@Param("lecNo") String lecNo,  
			@Param("offset") int offset, 
			@Param("pageSize") int pageSize
	);
	
	public int countEvals(@Param("lecNo")String lecNo);
	public Integer totalScore(@Param("lecNo") String lecNo);
	public List<LectureEvalVO> selectEvalDetail(String evalNo);
	public String selectEvalComment(String evalNo);
	
}
