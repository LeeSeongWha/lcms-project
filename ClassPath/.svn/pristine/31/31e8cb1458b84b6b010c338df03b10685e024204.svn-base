package kr.or.ddit.pfcp.student.statistics.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.common.vo.StudentStatisticsVO;
import kr.or.ddit.pfcp.student.lecture.grade.service.StudentGradeService;
import kr.or.ddit.pfcp.student.schedule.service.StudentScheduleService;
import kr.or.ddit.pfcp.student.statistics.service.StudentStatisticsService;

@RestController
@RequestMapping("/rest/student/statistics")
public class StudentStatisticRestController {
  
  @Autowired
  private StudentGradeService  studentGradeService;
  
  @Autowired
  private StudentStatisticsService studentStatisticsService;
  
  @GetMapping("/grade/{userNo}")
  public ResponseEntity<?> getGpa(
        @PathVariable String userNo
      ){
    List<LectureEnrVO> lectureEnrList = studentGradeService.readStudentGradeList(userNo, null);
    return ResponseEntity.ok(lectureEnrList);
  }
  
  @GetMapping("/attendance/{userNo}")
  public ResponseEntity<?> getAttendanceRate(
      @PathVariable String userNo
      ){
    List<StudentStatisticsVO> attendanceRate = studentStatisticsService.retrieveStudentStatistics(userNo);
    return ResponseEntity.ok(attendanceRate);
  }
  
  @GetMapping("/gradeAvg/{userNo}")
  public ResponseEntity<?> getGradeAvgRate(
      @PathVariable String userNo
      ){
    List<StudentStatisticsVO> gradeAvgRate = studentStatisticsService.retrieveStudentGradeStatistics(userNo);
    return ResponseEntity.ok(gradeAvgRate);
  }

}
