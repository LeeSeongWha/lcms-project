package kr.or.ddit.pfcp.staff.facility.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.FacilityVO;
import kr.or.ddit.pfcp.common.vo.ReservationTimestampVO;
import kr.or.ddit.pfcp.staff.facility.mapper.FacilityMapper;
import lombok.RequiredArgsConstructor;

/**
 * @author seokyungdeok
 * @since 250630
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * 250702	|	양수민	|	메소드 생성
 * -----------------------------------------------
 * 250630	|	양수민	|	최초 생성
 */
@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {
	
	private final FacilityMapper mapper;
	
//	@Override
//	public List<FacilityVO> readFacilityList() {
//		return mapper.selectFacilityList();
//	}

	@Override
	public FacilityVO readFacility(String facilityNo) {
		return mapper.selectFacility(facilityNo);
	}

	@Override
	public void createFacility(FacilityVO facility) {
		mapper.insertFacility(facility);
	}


	@Override
	public void modifyFacility(FacilityVO facility) {
		mapper.updateFacility(facility);
		
	}

	
	// 시설 전체 목록 조회
	@Override
	public int readFacilityTotalCountByKeyword(Map<String, Object> paramMap) {
		return mapper.selectFacilityTotalCountByKeyword(paramMap);
	}

	@Override
	public int readFacilityTotalCount() {
		return mapper.selectFacilityTotalCount();
	}

	@Override
	public List<FacilityVO> readFacilityList(Map<String, Object> paramMap) {
		return mapper.selectFacilityList(paramMap);
	}

	


}
