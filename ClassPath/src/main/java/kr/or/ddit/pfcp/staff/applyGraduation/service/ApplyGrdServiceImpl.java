package kr.or.ddit.pfcp.staff.applyGraduation.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.GraduationRequirementVO;
import kr.or.ddit.pfcp.staff.applyGraduation.mapper.ApplyGrdMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ApplyGrdServiceImpl implements ApplyGrdSerive {

	@Autowired
	private ApplyGrdMapper mapper;
	
	
	@Override
	public List<GraduationRequirementVO> readGradutionList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.selectGraduationList(paramMap);
	}

	@Override
	public int readTotalGradutionCount(String searchType, String keyword, String eligible) {
		// TODO Auto-generated method stub
		return mapper.selectGraduationCount(searchType, keyword, eligible);
	}

	@Override
	public int bulkApply(Map<String, Object> paramMap) {
		List<String> userNoList = mapper.selectGraduatableUserNos(paramMap);
		int count = 0;
		for(String userNo: userNoList) {
			log.info(userNo);
			count += mapper.updateUserGradustatus(userNo);
		}
		
		return count;
	}

}
