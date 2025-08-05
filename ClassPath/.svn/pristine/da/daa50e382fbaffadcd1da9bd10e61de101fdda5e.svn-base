package kr.or.ddit.pfcp.professor.data.service;

import java.util.List;
import java.util.Map;

/**
 * @author 김태수
 * @since 2025. 7. 29.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 29.	|	김태수	|	최초 생성
 */
public interface ProfessorDataRestService {
	
	
	// 총 학생 / 학생 / 졸업자 / 휴학생
	public List<Integer> totalStd(String departmentNo);
    public List<Integer> currentStd(String departmentNo);
    public List<Integer> gradStd(String departmentNo);
    public List<Integer> leaveStd(String departmentNo);

    
    // 학과 학생수 / 교수 / 성비 비율 / 입학 신입생수
    public List<Map<String, Object>> admYearCnt(String departmentNo);
    public List<Map<String, Object>> gradeCnt(String departmentNo);
    public List<Map<String, Object>> genderCnt(String departmentNo);
    public List<Map<String, Object>> professorCnt(String departmentNo);
    
    // 학과 졸업요건 / 졸업 현황
    public List<Map<String, Object>> departmentDgr(String departmentNo);
	public List<Map<String, Object>> dgrStatus(String departmentNo);
	
	
	// 성적 분포 및 학업 분석
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
