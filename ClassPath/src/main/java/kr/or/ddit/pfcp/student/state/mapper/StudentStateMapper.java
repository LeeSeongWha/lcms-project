package kr.or.ddit.pfcp.student.state.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.AcademicChangeRequestVO;
import kr.or.ddit.pfcp.common.vo.StudentVO;

/**
 * @author seokyungdeok
 * @since 250704
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * -----------------------------------------------
 * 250704	|	서경덕	|	최초 생성
 *
 */
@Mapper
public interface StudentStateMapper {
	public StudentVO selectStudentInfo(String userNo);
	
	public int selectAcademicChangeRequestMajorChangeTotalCount(String userNo);
	public int selectAcademicChangeRequestLeaveApplyTotalCount(String userNo);
	public int selectAcademicChangeRequestReturnTotalCount(String userNo);
	public int selectAcademicChangeRequestDoubleTotalCount(String userNo);
	public int selectAcademicChangeRequestGraduationSuspensionTotalCount(String userNo);
	
	/**
	 * 학적 조회
	 * 
	 * @return
	 */
	public List<AcademicChangeRequestVO> selectAcademicChangeRequestMajorChange(Map<String, Object> paramMap);
	public List<AcademicChangeRequestVO> selectAcademicChangeRequestLeaveApply(Map<String, Object> paramMap);
	public List<AcademicChangeRequestVO> selectAcademicChangeRequestReturn(Map<String, Object> paramMap);
	public List<AcademicChangeRequestVO> selectAcademicChangeRequestDouble(Map<String, Object> paramMap);
	public List<AcademicChangeRequestVO> selectAcademicChangeRequestGraduationSuspension(Map<String, Object> paramMap);
	
	
	/**
	 * 학적 조회 상세
	 * 
	 * @return
	 */
	public AcademicChangeRequestVO selectAcademicChangeRequestMajorChangeDetail(String requestNo);
	public AcademicChangeRequestVO selectAcademicChangeRequestLeaveApplyDetail(String requestNo);
	public AcademicChangeRequestVO selectAcademicChangeRequestReturnDetail(String requestNo);
	public AcademicChangeRequestVO selectAcademicChangeRequestDoubleDetail(String requestNo);
	public AcademicChangeRequestVO selectAcademicChangeRequestGraduationSuspensionDetail(String requestNo);
	
	/**
	 * 학적 변경 "신청" 수정
	 * 
	 * @return
	 */
	public int insertAcademicChangeRequestMajorChange(AcademicChangeRequestVO academicChangeRequest);
	public int insertAcademicChangeRequestLeaveApply(AcademicChangeRequestVO academicChangeRequest);
	public int insertAcademicChangeRequestReturn(AcademicChangeRequestVO academicChangeRequest);
	public int insertAcademicChangeRequestDouble(AcademicChangeRequestVO academicChangeRequest);
	public int insertAcademicChangeRequestGraduationSuspension(AcademicChangeRequestVO academicChangeRequest);

	public int updateAcademicChangeRequestMajorChange(AcademicChangeRequestVO academicChangeRequest);
	public int updateAcademicChangeRequestLeaveApply(AcademicChangeRequestVO academicChangeRequest);
	public int updateAcademicChangeRequestReturn(AcademicChangeRequestVO academicChangeRequest);
	public int updateAcademicChangeRequestDouble(AcademicChangeRequestVO academicChangeRequest);
	public int updateAcademicChangeRequestGraduationSuspension(AcademicChangeRequestVO academicChangeRequest);

	public int deleteAcademicChangeRequestMajorChange(String requestNo);
	public int deleteAcademicChangeRequestLeaveApply(String requestNo);
	public int deleteAcademicChangeRequestReturn(String requestNo);
	public int deleteAcademicChangeRequestDouble(String requestNo);
	public int deleteAcademicChangeRequestGraduationSuspension(String requestNo);
}
