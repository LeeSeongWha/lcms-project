package kr.or.ddit.pfcp.staff.dashBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.LectureDashBoardVO;
import kr.or.ddit.pfcp.staff.dashBoard.mapper.LectureStatisticsMapper;

@Service
public class LectureStatisticsServiceImpl implements LectureStatisticsService {

	
	@Autowired
	private LectureStatisticsMapper mapper;
	
	@Override
	public LectureDashBoardVO getLectureStatisticsDashboard() {
		LectureDashBoardVO vo = new LectureDashBoardVO();
		vo.setOpenStats(mapper.selectLectureCountBySemester());
		vo.setTypeRatio(mapper.selectLectureTypeRatio());
		vo.setAvgByGroup(mapper.selectAvgLecturePerProfessorByDeptGroup());
		vo.setCapacityRate(mapper.selectEnrollmentRateByLectureType());

		vo.setTotalLectureCount(mapper.selectTotalLectureCount());
		vo.setTotalProfessorCount(mapper.selectTotalProfessorCount());
		vo.setTotalStudentCount(mapper.selectTotalStudentCount());
		
		return vo;
	}

}
