package kr.or.ddit.pfcp.student.statistics.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.or.ddit.pfcp.common.vo.StudentStatisticsVO;
import kr.or.ddit.pfcp.student.statistics.mapper.StudentStatisticsMapper;

@Service
public class StudentStatisticsServiceImpl implements StudentStatisticsService {
  @Autowired
  private StudentStatisticsMapper studentStatisticsMapper;

  @Override
  public List<StudentStatisticsVO> retrieveStudentStatistics(String studentId) {
    return studentStatisticsMapper.selectAttendanceStatList(studentId);
  }

  @Override
  public List<StudentStatisticsVO> retrieveStudentGradeStatistics(String studentId) {
    return studentStatisticsMapper.selectGradeStatList(studentId);
  }

}
