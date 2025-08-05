package kr.or.ddit.pfcp.staff.dashBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.ProgramStatisticsVO;
import kr.or.ddit.pfcp.common.vo.ProgramStatsDashboardVO;
import kr.or.ddit.pfcp.staff.dashBoard.mapper.StaffProgramStatDashboardMapper;

@Service
public class ProgramStaticsDashboardServiceImpl implements ProgramStaticsDashboardService{

	@Autowired
	private StaffProgramStatDashboardMapper mapper;
	
	@Override
	public ProgramStatsDashboardVO getProgramStatsList() {
		ProgramStatsDashboardVO vo = new ProgramStatsDashboardVO();
		vo.setApplyTrends(mapper.selectMonthlyApplyCount());
		vo.setCollegeParticipationRates(mapper.selectCollegeParticipationRate());
		vo.setMonthlyProgramCounts(mapper.selectMonthlyProgramCount());
		vo.setTypeCounts(mapper.selectProgramTypeCount());	
		return vo;
	}
	
}
