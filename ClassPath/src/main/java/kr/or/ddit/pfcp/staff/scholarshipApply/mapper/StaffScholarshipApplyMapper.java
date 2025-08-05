package kr.or.ddit.pfcp.staff.scholarshipApply.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.DepartmentVO;
import kr.or.ddit.pfcp.common.vo.ScholarshipApplyVO;
import kr.or.ddit.pfcp.common.vo.ScholarshipTypeVO;
import kr.or.ddit.pfcp.common.vo.ScholarshipVO;

@Mapper
public interface StaffScholarshipApplyMapper {

//	public List<ScholarshipApplyVO> selectScholarshipApplyList(String schTypeNo, int offset, int pageSize);

	public int selectApplyTotalCount(String schTypeNo);

	public void updateScholarshipApply(ScholarshipApplyVO scholarshipApply);

	public String selectScholarshipTypeName(String schTypeNo);

	public ScholarshipApplyVO selectScholarshipApply(String no);
	
	public int insertAcceptedScholarship(Map<String, Object> paramMap);
	
	public DepartmentVO selectDepartmentTuition(Map<String, Object> paramMap);
	
	public ScholarshipTypeVO selectScholarshipType(String schTypeNo);

	
	// 장학금 신청 목록 조회
	public int selectScholarshipApplyTotalCountByKeyword(Map<String, Object> paramMap);

	public int selectScholarshipApplyTotalCount(Map<String, Object> paramMap);

	public List<ScholarshipApplyVO> selectScholarshipApplyList(Map<String, Object> paramMap);

}
