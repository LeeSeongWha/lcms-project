package kr.or.ddit.pfcp.professor.data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.pfcp.professor.data.service.ProfessorDataRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 김태수
 * @since 2025. 7. 28.
 *
 * << 개정이력(Modification Information) >>
 *  수정일     |   수정자   |   수정 내용
 * -----------------------------------------------
 * 2025. 7. 28. | 김태수   | 최초 생성
 * 2025. 7. 29. | 김태수   | 학과별 학생 통계 기능 추가
 */
@RestController
@RequestMapping("/rest/professorData")
@Slf4j
public class ProfessorDataRestController {
	
	@Autowired
    private ProfessorDataRestService professorDataRestService;

    @GetMapping
    public Map<String, Object> getProfessorStatistics(
    		@RequestParam("departmentNo") String departmentNo
    	) {
        log.info("학과 통계 데이터 요청 수신 - departmentNo: {}", departmentNo);

        Map<String, Object> result = new HashMap<>();

        result.put("totalStd", professorDataRestService.totalStd(departmentNo));
        result.put("currentStd", professorDataRestService.currentStd(departmentNo));
        result.put("gradStd", professorDataRestService.gradStd(departmentNo));
        result.put("leaveStd", professorDataRestService.leaveStd(departmentNo));

        List<Map<String, Object>> admYearData = professorDataRestService.admYearCnt(departmentNo);
        result.put("admYearCnt", admYearData);

        List<Map<String, Object>> gradeData = professorDataRestService.gradeCnt(departmentNo);
        result.put("gradeCnt", gradeData);
        
        List<Map<String, Object>> genderData = professorDataRestService.genderCnt(departmentNo);
        result.put("genderData", genderData);
        
        List<Map<String, Object>> professorData = professorDataRestService.professorCnt(departmentNo);
        result.put("professorData",professorData);
        
        List<Map<String, Object>> dgrData = professorDataRestService.departmentDgr(departmentNo);
        result.put("dgrData", dgrData);
        
        List<Map<String, Object>> dgrDataStatus = professorDataRestService.dgrStatus(departmentNo);
        result.put("dgrDataStatus",dgrDataStatus);
        
        List<Map<String, Object>> totalSubjectData = professorDataRestService.totalSubjectData(departmentNo);
        result.put("totalSubjectData",totalSubjectData);
        
        List<Map<String, Object>> yearSubjectData = professorDataRestService.yearSubjectData(departmentNo);
        result.put("yearSubjectData", yearSubjectData);
        
        List<Map<String, Object>> gradeAvgData = professorDataRestService.gradeAvgData(departmentNo);
        result.put("gradeAvgData",gradeAvgData);
        
        
        List<Map<String, Object>> totalLecture = professorDataRestService.totalLecture(departmentNo);
        result.put("totalLecture",totalLecture);
        
        List<Map<String, Object>> totalLectureEvalAvg = professorDataRestService.totalLectureEvalAvg(departmentNo);
        result.put("totalLectureEvalAvg",totalLectureEvalAvg);
        
        List<Map<String, Object>> totalStdAvg = professorDataRestService.totalStdAvg(departmentNo);
        result.put("totalStdAvg",totalStdAvg);
        
        List<Map<String, Object>> totalYearCreateLec = professorDataRestService.totalYearCreateLec(departmentNo);
        result.put("totalYearCreateLec",totalYearCreateLec);
        
        List<Map<String, Object>> semesterEvalAvg = professorDataRestService.semesterEvalAvg(departmentNo);
        result.put("semesterEvalAvg",semesterEvalAvg);
        
        List<Map<String, Object>> semesterAttAvg = professorDataRestService.semesterAttAvg(departmentNo);
        result.put("semesterAttAvg",semesterAttAvg);
        
        List<Map<String, Object>> allEvalAvg = professorDataRestService.allEvalAvg(departmentNo);
        result.put("allEvalAvg",allEvalAvg);
        
        List<Map<String, Object>> allAttAvg = professorDataRestService.allAttAvg(departmentNo);
        result.put("allAttAvg",allAttAvg);
        
        
        

        return result;
    }
}
