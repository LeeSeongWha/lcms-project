package kr.or.ddit.pfcp.staff.dashBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.ScholarshipDashboardVO;
import kr.or.ddit.pfcp.staff.dashBoard.mapper.ScholarshipStatMapper;

@Service
public class ScholarshipStatServiceImpl implements ScholarshipStatSerivce {

	
	@Autowired
	private ScholarshipStatMapper mapper;
	@Override
	public ScholarshipDashboardVO getScholarshipStatList() {
		ScholarshipDashboardVO vo = new ScholarshipDashboardVO();
		vo.setAverageDiscounts(mapper.selectScholarshipAverageDiscounts());
		vo.setDepartmentTotals(mapper.selectScholarshipDepartmentTotals());
		vo.setGrantCounts(mapper.selectScholarshipGrantCounts());
		return vo;
	}

}
