package kr.or.ddit.pfcp.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class ScholarshipDashboardVO {
	  // 유형별 지급 횟수 통계
    private List<ScholarshipStatsVO> grantCounts;

    // 유형별 평균 감면액 통계
    private List<ScholarshipStatsVO> averageDiscounts;

    // 학과별 총 수혜액 통계
    private List<ScholarshipDepartmentVO> departmentTotals;
}
