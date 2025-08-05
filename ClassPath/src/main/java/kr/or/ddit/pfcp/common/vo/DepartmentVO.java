package kr.or.ddit.pfcp.common.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="departmentNo")
public class DepartmentVO implements Serializable {
	private String departmentNo;
	private String departmentName;
	private Integer departmentTuition;
	private String dgrNo;
	private String collegeNo;
	private String departmentDesc;
	
	// iframe 경로 저장
	private String departmentJspPath;
	
	private String delYN;
	private String dcount;
	
	
	// 커리큘럼 vo만들어서 join
	private transient CurriculumVO curriculumVO;
	
	private transient DGRRequestVO dgrReqVO;
	
	// 학과 리스트에 보이는 단과대학 이름
	private String collegeName;
}
