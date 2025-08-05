package kr.or.ddit.pfcp.staff.tuition.service;

import java.util.List;

import kr.or.ddit.pfcp.common.vo.CollegeVO;
import kr.or.ddit.pfcp.common.vo.DGRRequestVO;
import kr.or.ddit.pfcp.common.vo.DepartmentVO;

/**
 * @author YSM
 * @since 250717
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * -----------------------------------------------
 * 250717	|	양수민	|	최초 생성
 *
 */
public interface StaffTuitionService {

	public List<CollegeVO> readCollegeList();

	public List<DepartmentVO> readDepartmentsByCollegeNo(String collegeNo);

	public List<DGRRequestVO> readDgrReqByDgrNo(String dgrNoData);

	public void modifyTuitionIfChanged(String dgrNoData, Integer departmentTuition);

	public Integer readCurrentTuition(String dgrNoData);

}
