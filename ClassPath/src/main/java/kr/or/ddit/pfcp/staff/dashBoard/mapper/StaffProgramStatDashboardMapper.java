package kr.or.ddit.pfcp.staff.dashBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.CollegeParticipationRateVO;
import kr.or.ddit.pfcp.common.vo.StaffMonthlyApplyCountVO;
import kr.or.ddit.pfcp.common.vo.StaffMonthlyProgramCountVO;
import kr.or.ddit.pfcp.common.vo.StaffProgramTypeCountVO;

@Mapper
public interface StaffProgramStatDashboardMapper {
	public List<StaffMonthlyProgramCountVO> selectMonthlyProgramCount();
    public List<StaffProgramTypeCountVO> selectProgramTypeCount();
    public List<StaffMonthlyApplyCountVO> selectMonthlyApplyCount();
    public List<CollegeParticipationRateVO> selectCollegeParticipationRate();
}
