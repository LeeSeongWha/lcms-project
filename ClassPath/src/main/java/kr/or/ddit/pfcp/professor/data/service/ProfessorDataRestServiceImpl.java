package kr.or.ddit.pfcp.professor.data.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.professor.data.mapper.ProfessorDataRestMapper;

/**
 * @author 김태수
 * @since 2025. 7. 29.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 29.	|	김태수	|	최초 생성
 */
@Service
public class ProfessorDataRestServiceImpl implements ProfessorDataRestService {
	
	@Autowired
	private ProfessorDataRestMapper professorDataRestMapper;

	@Override
	public List<Integer> totalStd(String departmentNo) {
		return professorDataRestMapper.totalStd(departmentNo);
	}

	@Override
	public List<Integer> currentStd(String departmentNo) {
		return professorDataRestMapper.currentStd(departmentNo);
	}

	@Override
	public List<Integer> gradStd(String departmentNo) {
		return professorDataRestMapper.gradStd(departmentNo);
	}

	@Override
	public List<Integer> leaveStd(String departmentNo) {
		return professorDataRestMapper.leaveStd(departmentNo);
	}

	@Override
	public List<Map<String, Object>> admYearCnt(String departmentNo) {
		return professorDataRestMapper.admYearCnt(departmentNo);
	}

	@Override
	public List<Map<String, Object>> gradeCnt(String departmentNo) {
		return professorDataRestMapper.gradeCnt(departmentNo);
	}

	@Override
	public List<Map<String, Object>> genderCnt(String departmentNo) {
		return professorDataRestMapper.genderCnt(departmentNo);
	}

	@Override
	public List<Map<String, Object>> professorCnt(String departmentNo) {
		return professorDataRestMapper.professorCnt(departmentNo);
	}

	@Override
	public List<Map<String, Object>> departmentDgr(String departmentNo) {
		return professorDataRestMapper.departmentDgr(departmentNo);
	}

	@Override
	public List<Map<String, Object>> dgrStatus(String departmentNo) {
		return professorDataRestMapper.dgrStatus(departmentNo);
	}

	@Override
	public List<Map<String, Object>> totalSubjectData(String departmentNo) {
		return professorDataRestMapper.totalSubjectData(departmentNo);
	}

	@Override
	public List<Map<String, Object>> yearSubjectData(String departmentNo) {
		return professorDataRestMapper.yearSubjectData(departmentNo);
	}

	@Override
	public List<Map<String, Object>> gradeAvgData(String departmentNo) {
		return professorDataRestMapper.gradeAvgData(departmentNo);
	}

	@Override
	public List<Map<String, Object>> totalLecture(String departmentNo) {
		return professorDataRestMapper.totalLecture(departmentNo);
	}

	@Override
	public List<Map<String, Object>> totalLectureEvalAvg(String departmentNo) {
		return professorDataRestMapper.totalLectureEvalAvg(departmentNo);
	}

	@Override
	public List<Map<String, Object>> totalStdAvg(String departmentNo) {
		return professorDataRestMapper.totalStdAvg(departmentNo);
	}

	@Override
	public List<Map<String, Object>> totalYearCreateLec(String departmentNo) {
		return professorDataRestMapper.totalYearCreateLec(departmentNo);
	}

	@Override
	public List<Map<String, Object>> semesterEvalAvg(String departmentNo) {
		return professorDataRestMapper.semesterEvalAvg(departmentNo);
	}

	@Override
	public List<Map<String, Object>> semesterAttAvg(String departmentNo) {
		return professorDataRestMapper.semesterAttAvg(departmentNo);
	}

	@Override
	public List<Map<String, Object>> allEvalAvg(String departmentNo) {
		return professorDataRestMapper.allEvalAvg(departmentNo);
	}

	@Override
	public List<Map<String, Object>> allAttAvg(String departmentNo) {
		return professorDataRestMapper.allAttAvg(departmentNo);
	}

}
