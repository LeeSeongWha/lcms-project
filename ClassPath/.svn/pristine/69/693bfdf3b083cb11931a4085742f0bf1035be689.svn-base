package kr.or.ddit.pfcp.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SemesterMapper {
  
  @Select("SELECT SEMESTER_NAME FROM SEMESTER WHERE SEMESTER_ACT='Y'")
  public String currentSemester();
}
