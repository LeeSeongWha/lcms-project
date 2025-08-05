package kr.or.ddit.pfcp.staff.dashBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.StudentChangeStatusVO;
import kr.or.ddit.pfcp.common.vo.StudentDeptGradeStatVO;
import kr.or.ddit.pfcp.common.vo.StudentGenderGradeStatVO;
import kr.or.ddit.pfcp.common.vo.StudentMonthlyTrendVO;

@Mapper
public interface StudentStatisticsDashboardMapper {
	// 1. 단과대학/학년별 재학생 수
    public List<StudentDeptGradeStatVO> selectStudentCountByCollegeAndGrade();

    // 2. 연도별 재학생 수 변화
    public List<StudentMonthlyTrendVO> selectStudentCountByYear();

    // 3. 학적 변동 현황
    public List<StudentChangeStatusVO> selectAcademicChangeStats();

    // 4. 성별/학년별 분포
    public List<StudentGenderGradeStatVO> selectGenderGradeStats();
}
