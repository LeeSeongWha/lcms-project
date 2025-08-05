package kr.or.ddit.pfcp.student.program.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.pfcp.common.vo.EvalCriteriaVO;
import kr.or.ddit.pfcp.common.vo.ProgramEnrollVO;
import kr.or.ddit.pfcp.common.vo.ProgramEvalScoreVO;
import kr.or.ddit.pfcp.common.vo.ProgramEvalVO;
import kr.or.ddit.pfcp.common.vo.ProgramVO;

/**
 * @author seokyungdeok
 * @since 2025. 7. 21.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 21.	|	서경덕	|	최초 생성
 */
@Mapper
public interface StudentProgramMapper {
	public List<ProgramVO> selectProgramList();
	
	public int countEnrollNo(String no);
	
	public ProgramVO selectProgramDetail(String no);
	
	public ProgramEnrollVO selectProgramEnrollDetail(Map<String, Object> paramMap);
	
	public int insertProgram(ProgramEnrollVO programEnroll);
	
	public List<ProgramEnrollVO> validDuplication(Map<String, Object> paramMap);
	
	public List<EvalCriteriaVO> selectProgramEvaluationList();
	
	public int insertProgramEval(ProgramEvalVO programEval);
	
	public int insertProgramEvalScore(ProgramEvalScoreVO programEvalScore);
	
	public boolean existsEvalByEnrollNo(@Param("enrollNo") String enrollNo);
	
	public String selectProgramEnrollDetailByEnrollNo(String enrollNo);
}
