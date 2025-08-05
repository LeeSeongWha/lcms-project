package kr.or.ddit.pfcp.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "requestNo")
public class AcademicChangeRequestVO {
	private Integer rnum;

	private String requestNo;
	private String userNo;
	private String typeCode;
	private String semesterNo;
	private String reason;
	private String requestDate;
	private String status;
	private String requestThing;
	private String statusComment;
	private String handler;
	private String decisionDate;
	
	private String studentName;  // SQL의 STUDENT_NAME 별칭용
    private String staffName;    // SQL의 STAFF_NAME 별칭용
    private String requestDepartmentName;    // SQL의 STAFF_NAME 별칭용

	private StudentVO student;
	private transient UserVO user;
	private transient DepartmentVO department;
	private transient CollegeVO college;
	private transient TypeVO type;

	private String keyword;
	private String searchType;

}
