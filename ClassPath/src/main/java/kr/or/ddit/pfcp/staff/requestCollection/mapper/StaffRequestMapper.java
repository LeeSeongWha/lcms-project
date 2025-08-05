package kr.or.ddit.pfcp.staff.requestCollection.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.AcademicChangeRequestVO;

@Mapper
public interface StaffRequestMapper {

//  requestStatusMap 시작 ===================================================
	public Integer selectTotalRequest();
	public Integer selectWaitingRequest();
	public Integer selectRejectedRequest();
	public Integer selectProcessingRequest();
	public Integer selectCompleteRequest();
//  requestStatusMap 끝 ===================================================	
	
	
	public List<AcademicChangeRequestVO> selectRequestList(Map<String, Object> paramMap);

	public int selectRequestTotalCountByKeyword(Map<String, Object> paramMap);

	public int selectRequestTotalCount();
	
	public int updateRequest(Map<String, Object> paramMap);
	public int updateRequestStudent(Map<String, Object> paramMap);


}
