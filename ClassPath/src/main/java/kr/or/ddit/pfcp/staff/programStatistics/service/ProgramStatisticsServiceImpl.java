package kr.or.ddit.pfcp.staff.programStatistics.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.ProgramStatisticsVO;
import kr.or.ddit.pfcp.common.vo.ProgramTypeStatVO;
import kr.or.ddit.pfcp.staff.programStatistics.mapper.ProgramStatisticsMapper;

@Service
public class ProgramStatisticsServiceImpl implements ProgramStatisticsService {

	@Autowired
	private ProgramStatisticsMapper statisticsMapper;

	@Override
	public void collectAndStatistics() {
		int totalPrograms = statisticsMapper.countAllPrograms();
		int totalApplicants = statisticsMapper.countAllApplicants();
		int monthlyApply = statisticsMapper.countThisMonthApplicants();
		int completeRate = statisticsMapper.calculateCompleteRate();

		ProgramStatisticsVO stat = new ProgramStatisticsVO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = LocalDate.now().format(formatter);
		stat.setStatDate(today);
		stat.setTotalPrograms(totalPrograms);
		stat.setTotalApplicants(totalApplicants);
		stat.setMonthlyApply(monthlyApply);
		stat.setCompleteRate(completeRate);

		statisticsMapper.insertStatistics(stat);
	}

	@Override
	public ProgramStatisticsVO readStatistics() {
		return statisticsMapper.selectTodayStatistics();
	}

	
	// 실시간 반영 
	@Override
	public int readProgramCount() {
		// TODO Auto-generated method stub
		return statisticsMapper.countAllPrograms();
	}

	@Override
	public int readApplicantsCount() {
		// TODO Auto-generated method stub
		return statisticsMapper.countAllApplicants();
	}

	@Override
	public int readCountThisMonthApplicants() {
		// TODO Auto-generated method stub
		return statisticsMapper.countThisMonthApplicants();
	}

	@Override
	public int readCalculateCompleteRate() {
		return statisticsMapper.calculateCompleteRate();
	}


	

	@Override
	public void collectAndTypeStatistics() {
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		// 1. 신청자 수 기준 유형 통계
	    List<ProgramTypeStatVO> applyStats = statisticsMapper.selectTodayTypeApplyStats();
	    for (ProgramTypeStatVO vo : applyStats) {
	        vo.setStatDate(today);
	        vo.setStatGroup("APPLY"); // 신청자 수 그룹 구분자
	        statisticsMapper.insertTypeStat(vo);
	    }

	    // 2. 개설된 프로그램 수 기준 유형 통계
	    List<ProgramTypeStatVO> programStats = statisticsMapper.selecteProgramBytypeCount();
	    for (ProgramTypeStatVO vo : programStats) {
	        vo.setStatDate(today);
	        vo.setStatGroup("PROGRAM"); // 프로그램 개수 그룹 구분자
	        statisticsMapper.insertTypeStat(vo);
	    }
		
	}

	@Override
	public List<ProgramTypeStatVO> readTypeStat() {
		return statisticsMapper.selectTypeStat();
	}
	
	
	
	
	

}
