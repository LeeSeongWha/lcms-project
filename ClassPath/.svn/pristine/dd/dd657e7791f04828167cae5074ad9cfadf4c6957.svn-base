package kr.or.ddit.pfcp.student.eclass.assignement.service;

import java.util.List;
import kr.or.ddit.pfcp.common.vo.AssignmentVO;

/**
 * @author LSH
 * @since 20250710
 */
public interface AssignmentService {
  /**
   * 과제 목록 서비스
   * @param lecNo
   * @return
   */
  public List<AssignmentVO> retrieveAssignments(String lecNo);
  
  /**
   * 과제 목록 서비스 사용자 번호
   * @param userNo
   * @return
   */
  public List<AssignmentVO> retrieveAssignmentsByUserNo(String userNo);
  
  /**
   * 과제 생성 서비스
   * @param lecNo
   * @return
   */
  public int createAssignment(AssignmentVO assignment);
  
  /**
   * 과제 수정 서비스
   * @param assignment
   * @return
   */
  public int modifyAssignment(AssignmentVO assignment);
}
