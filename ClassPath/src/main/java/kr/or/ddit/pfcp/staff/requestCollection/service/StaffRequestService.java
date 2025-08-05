package kr.or.ddit.pfcp.staff.requestCollection.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.pfcp.common.vo.AcademicChangeRequestVO;
import kr.or.ddit.pfcp.common.vo.PaginationInfoVO;

public interface StaffRequestService {


//  requestStatusMap 시작 ===================================================
	public Integer readTotalRequest();
	public Integer readWaitingRequest();
	public Integer readRejectedRequest();
	public Integer readProcessingRequest();
	public Integer readCompleteRequest();
//  requestStatusMap 끝 ===================================================	
	
	public List<AcademicChangeRequestVO> readRequestList(Map<String, Object> paramMap);

	public int readRequestTotalCountByKeyword(Map<String, Object> paramMap);

	public int readRequestTotalCount();
	
	public int modifyRequest(Map<String, Object> paramMap);



}
