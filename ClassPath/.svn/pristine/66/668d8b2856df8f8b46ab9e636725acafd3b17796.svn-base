package kr.or.ddit.pfcp.staff.dashBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.StaffLectureCapacityRateVO;
import kr.or.ddit.pfcp.common.vo.StaffProfessorGroupAvgVO;
import kr.or.ddit.pfcp.common.vo.StaffSemesterStatVO;
import kr.or.ddit.pfcp.common.vo.StaffTypeRatioVO;

@Mapper
public interface LectureStatisticsMapper {
	public List<StaffSemesterStatVO> selectLectureCountBySemester();
    public List<StaffTypeRatioVO> selectLectureTypeRatio();
    public List<StaffProfessorGroupAvgVO> selectAvgLecturePerProfessorByDeptGroup();
    public List<StaffLectureCapacityRateVO> selectEnrollmentRateByLectureType();

    public int selectTotalLectureCount();
    public int selectTotalProfessorCount();
    public int selectTotalStudentCount();
}
