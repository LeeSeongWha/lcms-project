package kr.or.ddit.pfcp.staff.dashBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.pfcp.common.vo.GradeStatsDashboardVO;
import kr.or.ddit.pfcp.common.vo.LectureDashBoardVO;
import kr.or.ddit.pfcp.common.vo.ProgramStatsDashboardVO;
import kr.or.ddit.pfcp.common.vo.ScholarshipDashboardVO;
import kr.or.ddit.pfcp.common.vo.StaffStudentDashboardVO;
import kr.or.ddit.pfcp.staff.dashBoard.service.GradeStatisticsDashboardService;
import kr.or.ddit.pfcp.staff.dashBoard.service.LectureStatisticsService;
import kr.or.ddit.pfcp.staff.dashBoard.service.ProgramStaticsDashboardService;
import kr.or.ddit.pfcp.staff.dashBoard.service.ScholarshipStatSerivce;
import kr.or.ddit.pfcp.staff.dashBoard.service.StudentStatisticsDashboardService;

@RestController
public class StaffLectureStatisticsController {
	
	@Autowired
	private LectureStatisticsService LectureService; 
	
	@Autowired
	private StudentStatisticsDashboardService StudentService;
	
	@Autowired
	private ProgramStaticsDashboardService ProgramService;
	
	@Autowired
	private GradeStatisticsDashboardService GradeSerivce;
	
	@Autowired
	private ScholarshipStatSerivce ScholarShipSerivce;
	
	@GetMapping("/rest/staff/statistics/lecture")
	public LectureDashBoardVO getLectureStatistics() {
		return LectureService.getLectureStatisticsDashboard();
	}
	
	@GetMapping("/rest/staff/statistics/student")
	public StaffStudentDashboardVO getStudentStatistics() {
		return StudentService.getStudentStatisticsDashboard();
	}
	
	@GetMapping("/rest/staff/statistics/grade")
	public GradeStatsDashboardVO getGradeStatistics() {
		return GradeSerivce.getGradeStatList();
	}
	
	@GetMapping("/rest/staff/statistics/program")
	public ProgramStatsDashboardVO getProgramStatList() {
		return ProgramService.getProgramStatsList();
	}
	
	@GetMapping("/rest/staff/statistics/scholarship")
	public ScholarshipDashboardVO getScholarshipStatList() {
		return ScholarShipSerivce.getScholarshipStatList();
	}
}
