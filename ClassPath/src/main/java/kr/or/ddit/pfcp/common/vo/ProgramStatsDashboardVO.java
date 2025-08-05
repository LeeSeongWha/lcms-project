package kr.or.ddit.pfcp.common.vo;

import java.util.List;

import lombok.Data;


@Data
public class ProgramStatsDashboardVO {
	private List<StaffMonthlyProgramCountVO> monthlyProgramCounts;
	private List<StaffProgramTypeCountVO> typeCounts;
	private List<StaffMonthlyApplyCountVO> applyTrends;
	private List<CollegeParticipationRateVO> collegeParticipationRates;
}
