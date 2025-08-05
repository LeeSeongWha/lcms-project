package kr.or.ddit.pfcp.professor.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 김태수
 * @since 2025. 7. 29.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 29.	|	김태수	|	최초 생성
 */
@Mapper
public interface ProfessorDataRestMapper {
	
	public List<Integer> totalStd(String departmentNo);
	public List<Integer> currentStd(String departmentNo);
	public List<Integer> gradStd(String departmentNo);
	public List<Integer> leaveStd(String departmentNo);
	
	public List<Map<String, Object>> admYearCnt(String departmentNo);
	public List<Map<String, Object>> gradeCnt(String departmentNo);
	public List<Map<String, Object>> genderCnt(String departmentNo);
	public List<Map<String, Object>> professorCnt(String departmentNo);
	
	public List<Map<String, Object>> departmentDgr(String departmentNo);
	public List<Map<String, Object>> dgrStatus(String departmentNo);
	
	public List<Map<String, Object>> totalSubjectData(String departmentNo);
	public List<Map<String, Object>> yearSubjectData(String departmentNo);
	public List<Map<String, Object>> gradeAvgData(String departmentNo);
	
	
	public List<Map<String, Object>> totalLecture(String departmentNo);
	public List<Map<String, Object>> totalLectureEvalAvg(String departmentNo);
	public List<Map<String, Object>> totalStdAvg(String departmentNo);
	public List<Map<String, Object>> totalYearCreateLec(String departmentNo);
	public List<Map<String, Object>> semesterEvalAvg(String departmentNo);
	public List<Map<String, Object>> semesterAttAvg(String departmentNo);
	public List<Map<String, Object>> allEvalAvg(String departmentNo);
	public List<Map<String, Object>> allAttAvg(String departmentNo);

	
	
}
