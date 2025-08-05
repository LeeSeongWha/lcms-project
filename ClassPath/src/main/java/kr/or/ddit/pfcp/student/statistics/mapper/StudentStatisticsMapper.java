package kr.or.ddit.pfcp.student.statistics.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.or.ddit.pfcp.common.vo.StudentStatisticsVO;

@Mapper
public interface StudentStatisticsMapper {
  public List<StudentStatisticsVO> selectAttendanceStatList(String studentId);
  public List<StudentStatisticsVO> selectGradeStatList(String studentId);
}
