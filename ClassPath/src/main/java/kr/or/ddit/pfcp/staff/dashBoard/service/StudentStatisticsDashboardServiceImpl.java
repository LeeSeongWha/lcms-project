package kr.or.ddit.pfcp.staff.dashBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.StaffStudentDashboardVO;
import kr.or.ddit.pfcp.staff.dashBoard.mapper.StudentStatisticsDashboardMapper;

@Service
public class StudentStatisticsDashboardServiceImpl implements StudentStatisticsDashboardService {

	@Autowired
	private StudentStatisticsDashboardMapper mapper;
	@Override
	public StaffStudentDashboardVO getStudentStatisticsDashboard() {
		StaffStudentDashboardVO vo = new StaffStudentDashboardVO();
		vo.setDeptGradeStats(mapper.selectStudentCountByCollegeAndGrade());
		vo.setMonthlyTrend(mapper.selectStudentCountByYear());
		vo.setChangeStatus(mapper.selectAcademicChangeStats());
		vo.setGenderGradeStats(mapper.selectGenderGradeStats());
		return vo;
		
	}

}
