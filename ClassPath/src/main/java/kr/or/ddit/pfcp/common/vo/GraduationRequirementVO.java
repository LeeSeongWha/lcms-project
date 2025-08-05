package kr.or.ddit.pfcp.common.vo;

import lombok.Data;

@Data
public class GraduationRequirementVO {
	private String userNo;
	private String userName;
	private String departmentNo;
	
	private int totalCredit;
	private int majorCredit;
	private int generalCredit;
	private String graduationEligible;
}
