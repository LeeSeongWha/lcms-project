package kr.or.ddit.pfcp.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class LectureDashBoardVO {

	private int totalLectureCount;
	private int totalProfessorCount;
	private int totalStudentCount;

	private List<StaffSemesterStatVO> openStats;
	private List<StaffTypeRatioVO> typeRatio;
	private List<StaffProfessorGroupAvgVO> avgByGroup;
	private List<StaffLectureCapacityRateVO> capacityRate;

}
