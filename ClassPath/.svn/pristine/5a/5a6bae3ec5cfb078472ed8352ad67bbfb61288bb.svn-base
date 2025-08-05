package kr.or.ddit.pfcp.student.counsel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.pfcp.common.vo.CounselReqVO;
import kr.or.ddit.pfcp.common.vo.LectureEnrVO;

/**
 * 상담관리(CRUD)를 위한 Persistence Layer
 * 
 * @author seokyungdeok
 * @since 250702
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * -----------------------------------------------
 * 250702	|	서경덕	|	최초 생성
 */
@Mapper
public interface StudentCounselMapper {
	public int insertStudentCounsel(CounselReqVO counselReq);
	
	public List<CounselReqVO> selectStudentDepartmentCounselList(Map<String, Object> paramMap);
	
	public List<CounselReqVO> selectStudentEmploymentCounselList(Map<String, Object> paramMap);
	
	public CounselReqVO selectStudentCounsel(String counselReqno);
//	update
	public int deleteStudentDepartmentCounselList(String counselReqno);
	
	public List<LectureEnrVO> selectProfessorList(String userNo);
	
	public List<Map<String, Object>> selectAvailableTimesByProfessor(String userNo);
	
	public int selectDepartmentCounselTotalCount();
	
	public int selectEmploymentCounselTotalCount();
}
