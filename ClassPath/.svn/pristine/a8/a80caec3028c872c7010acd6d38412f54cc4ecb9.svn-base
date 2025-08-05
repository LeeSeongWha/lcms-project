package kr.or.ddit.pfcp.staff.requestCollection.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.AcademicChangeRequestVO;
import kr.or.ddit.pfcp.staff.requestCollection.mapper.StaffRequestMapper;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StaffRequestServiceImpl implements StaffRequestService {

	private final StaffRequestMapper mapper;
	
//  requestStatusMap 시작 ===================================================
	@Override
	public Integer readTotalRequest() { return mapper.selectTotalRequest(); }
	@Override
	public Integer readWaitingRequest() { return mapper.selectWaitingRequest(); }
	@Override
	public Integer readRejectedRequest() { return mapper.selectRejectedRequest(); }
	@Override
	public Integer readCompleteRequest() { return mapper.selectCompleteRequest(); }
	@Override
	public Integer readProcessingRequest() { return mapper.selectProcessingRequest(); }
//  requestStatusMap 끝 ===================================================	
	
	@Override
	public int readRequestTotalCountByKeyword(Map<String, Object> paramMap) {
		return mapper.selectRequestTotalCountByKeyword(paramMap);
	}
	
	
	@Override
	public List<AcademicChangeRequestVO> readRequestList(Map<String, Object> paramMap) {
		return mapper.selectRequestList(paramMap);
	}


	@Override
	public int readRequestTotalCount() {
		return mapper.selectRequestTotalCount();
	}
	
	@Override
	public int modifyRequest(Map<String, Object> paramMap) {
		String status = (String) paramMap.get("status");
		
		if (!"승인".equals(status)) {
			return mapper.updateRequest(paramMap);
		}else {
			mapper.updateRequest(paramMap);
			return mapper.updateRequestStudent(paramMap);
		}

	}
	

	

}
