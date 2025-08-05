package kr.or.ddit.pfcp.staff.programStatistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.ProgramStatisticsVO;
import kr.or.ddit.pfcp.common.vo.ProgramTypeStatVO;

@Mapper
public interface ProgramStatisticsMapper {
	
	public int countAllPrograms();
	
    public int countAllApplicants();

    public int countThisMonthApplicants();

    public int calculateCompleteRate();

    public void insertStatistics(ProgramStatisticsVO stat);
    
    public ProgramStatisticsVO selectTodayStatistics();
    
    public List<ProgramTypeStatVO> selectTodayTypeApplyStats();
    
    public List<ProgramTypeStatVO> selecteProgramBytypeCount();
    
    public int insertTypeStat(ProgramTypeStatVO typeStatVO);
    
    public List<ProgramTypeStatVO> selectTypeStat();
	
}
