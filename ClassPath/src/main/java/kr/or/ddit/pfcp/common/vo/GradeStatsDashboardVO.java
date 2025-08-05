package kr.or.ddit.pfcp.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class GradeStatsDashboardVO {
	private List<semesterAvgGradeVO> semesterAvgGrades;    
    private List<GradeDistributionVO> gradeDistributions;   
    private List<GradeByYearVO> gradeByYears;             
    private List<GradeByGenderVO> gradeByGenders;    
}
