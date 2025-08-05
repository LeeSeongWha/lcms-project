package kr.or.ddit.pfcp.common.vo;

import lombok.Data;

@Data
public class StaffLectureCapacityRateVO {
	private String typeName;
	private int totalCapacity;
	private int totalEnrolled;
}
