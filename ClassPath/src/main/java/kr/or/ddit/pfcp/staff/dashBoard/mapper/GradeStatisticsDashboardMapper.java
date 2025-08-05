package kr.or.ddit.pfcp.staff.dashBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.GradeByGenderVO;
import kr.or.ddit.pfcp.common.vo.GradeByYearVO;
import kr.or.ddit.pfcp.common.vo.GradeDistributionVO;
import kr.or.ddit.pfcp.common.vo.semesterAvgGradeVO;

@Mapper
public interface GradeStatisticsDashboardMapper {
	public List<semesterAvgGradeVO> selectSemesterAvgGradeList();
	public List<GradeDistributionVO> selectGradeDistributionList();
	public List<GradeByYearVO> selectGradeByYearList();
	public List<GradeByGenderVO> selectGradeByGenderList();
}
