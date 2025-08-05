package kr.or.ddit.pfcp.student.eclass.assignement.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.or.ddit.pfcp.common.vo.AssignmentVO;

/**
 * @author LSH
 * @since 20250710
 */
@Mapper
public interface AssignmentMapper {
  /**
   * 강의 과제 목록
   * @param lecNo
   * @return
   */
  public List<AssignmentVO> selectAssignmentList(String lecNo);
  
  /**
   * 학생 파라미터로 강의 과제 목록 
   * @param userNo
   * @return
   */
  public List<AssignmentVO> selectAssignmentListByUserNo(String userNo);
  
  /**
   * 과제 insert
   * @param lecNo
   * @return
   */
  public int insertAssignment(AssignmentVO assignment);
  
  
  /**
   * 과제 update
   * @param assignment
   * @return
   */
  public int updateAssignment(AssignmentVO assignment);
}
