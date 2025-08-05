package kr.or.ddit.pfcp.student.program.service;

import java.util.List;
import java.util.Map;

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
public interface StudentProgramService {
	public List<ProgramVO> readProgramList();
	
	public int countEnrollNo(String no);
	
	public ProgramVO readProgramDetail(String no);
	
	public ProgramEnrollVO readProgramEnrollDetail(Map<String, Object> paramMap);
	
	public boolean createProgram(ProgramEnrollVO programEnroll);
	
	public List<EvalCriteriaVO> readProgramEvaluationList();
	
	public void createProgramEval(ProgramEvalVO programEval);
	
	public void createProgramEvalScore(ProgramEvalScoreVO programEvalScore);
	
	public boolean existsEvalByEnrollNo(String enrollNo);
	
	public String readProgramEnrollDetailByEnrollNo(String enrollNo);
}
