package kr.or.ddit.pfcp.student.program.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.EvalCriteriaVO;
import kr.or.ddit.pfcp.common.vo.ProgramEnrollVO;
import kr.or.ddit.pfcp.common.vo.ProgramEvalScoreVO;
import kr.or.ddit.pfcp.common.vo.ProgramEvalVO;
import kr.or.ddit.pfcp.common.vo.ProgramVO;
import kr.or.ddit.pfcp.student.program.mapper.StudentProgramMapper;

@Service(value = "studentProgramService")
public class StudentProgramServiceImpl implements StudentProgramService {
	@Autowired
	StudentProgramMapper studentProgramMapper;

	@Override
	public List<ProgramVO> readProgramList() {
		
		return studentProgramMapper.selectProgramList();
	}

	@Override
	public ProgramVO readProgramDetail(String no) {
		
		return studentProgramMapper.selectProgramDetail(no);
	}

	@Override
	public boolean createProgram(ProgramEnrollVO programEnroll) {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("programNo", programEnroll.getProgramNo());
		paramMap.put("userNo", programEnroll.getUserNo());
		
		List<ProgramEnrollVO> cntList = studentProgramMapper.validDuplication(paramMap);
		
		if (!cntList.isEmpty()) {
			return false;
		}
		
		studentProgramMapper.insertProgram(programEnroll);
		
		return true;
	}

	@Override
	public int countEnrollNo(String no) {
		
		return studentProgramMapper.countEnrollNo(no);
	}

	@Override
	public ProgramEnrollVO readProgramEnrollDetail(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return studentProgramMapper.selectProgramEnrollDetail(paramMap);
	}

	@Override
	public List<EvalCriteriaVO> readProgramEvaluationList() {
		// TODO Auto-generated method stub
		return studentProgramMapper.selectProgramEvaluationList();
	}

	@Override
	public void createProgramEval(ProgramEvalVO programEval) {
		// TODO Auto-generated method stub
		studentProgramMapper.insertProgramEval(programEval);
	}

	@Override
	public void createProgramEvalScore(ProgramEvalScoreVO programEvalScore) {
		// TODO Auto-generated method stub
		studentProgramMapper.insertProgramEvalScore(programEvalScore);
	}

	@Override
	public boolean existsEvalByEnrollNo(String enrollNo) {
		// TODO Auto-generated method stub
		return studentProgramMapper.existsEvalByEnrollNo(enrollNo);
	}

	@Override
	public String readProgramEnrollDetailByEnrollNo(String enrollNo) {
		// TODO Auto-generated method stub
		return studentProgramMapper.selectProgramEnrollDetailByEnrollNo(enrollNo);
	}

}
