package kr.or.ddit.pfcp.common.vo;

import lombok.Data;

@Data
public class StudentStatisticsVO {
  private String lectureNo;         // 강의번호
  private String lectureName;       // 강의명
  private String studentId;         // 학생아이디
  private Integer attendanceCount;      // 출석 횟수
  private Integer lateCount;            // 지각 횟수
  private Integer absentCount;
  private Double attendanceRate;    // 출석률 (소수점 포함)
  private Double studentGrade;
  private Double averageGrade;
  private Double gradeDiff;
}
