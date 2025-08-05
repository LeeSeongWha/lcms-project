package kr.or.ddit.pfcp.staff.dashBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.GradeStatsDashboardVO;
import kr.or.ddit.pfcp.staff.dashBoard.mapper.GradeStatisticsDashboardMapper;

@Service
public class GradeStatisticsDashboardServiceImpl implements GradeStatisticsDashboardService {
	
	@Autowired
	private GradeStatisticsDashboardMapper mapper;
	@Override
	public GradeStatsDashboardVO getGradeStatList() {
		GradeStatsDashboardVO vo = new GradeStatsDashboardVO();
		vo.setGradeByGenders(mapper.selectGradeByGenderList());
		vo.setGradeByYears(mapper.selectGradeByYearList());
		vo.setGradeDistributions(mapper.selectGradeDistributionList());
		vo.setSemesterAvgGrades(mapper.selectSemesterAvgGradeList());
		return vo;
	}

}
