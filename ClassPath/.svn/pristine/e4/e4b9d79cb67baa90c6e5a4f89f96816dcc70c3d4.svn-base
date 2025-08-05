package kr.or.ddit.pfcp.staff.staffmanage.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.StaffVO;
import kr.or.ddit.pfcp.common.vo.UserVO;

@Mapper
public interface StaffmanageMapper {

	public int selectStaffTotalCountByKeyword(Map<String, Object> paramMap);

	public int selectStaffTotalCount();

	public List<StaffVO> selectStaffList(Map<String, Object> paramMap);

	public StaffVO selectStaff(String no);

	public void updateStaff(StaffVO staff);

	public void updateUser(UserVO user);

	public void insertStaff(StaffVO staff);

	public String selectUserNameByUserNo(String userNo);

	public void insertStudentStaff(StaffVO staff);

	public void updateRdate(String no);

	public int selectStaffTotalCountByKeywordR(Map<String, Object> paramMap);

	public int selectStaffTotalCountR();

	public List<StaffVO> selectStaffListR(Map<String, Object> paramMap);

}
