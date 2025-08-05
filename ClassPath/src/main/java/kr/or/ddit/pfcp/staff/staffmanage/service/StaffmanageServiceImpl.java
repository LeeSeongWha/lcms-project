package kr.or.ddit.pfcp.staff.staffmanage.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.StaffVO;
import kr.or.ddit.pfcp.staff.staffmanage.mapper.StaffmanageMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StaffmanageServiceImpl implements StaffmanageService {
	
	private final StaffmanageMapper mapper;

	@Override
	public int readStaffTotalCountByKeyword(Map<String, Object> paramMap) {
		return mapper.selectStaffTotalCountByKeyword(paramMap);
	}

	@Override
	public int readStaffTotalCount() {
		return mapper.selectStaffTotalCount();
	}

	@Override
	public List<StaffVO> readStaffList(Map<String, Object> paramMap) {
		return mapper.selectStaffList(paramMap);
	}

	@Override
	public StaffVO readStaff(String no) {
		return mapper.selectStaff(no);
	}

	@Override
	public void modifyStaff(StaffVO staff) {
		mapper.updateUser(staff.getUser());
		
		mapper.updateStaff(staff);
	}

	@Override
	public void createStaff(StaffVO staff) {
		mapper.insertStaff(staff);
	}

	@Override
	public String getUserNameByUserNo(String userNo) {
		return mapper.selectUserNameByUserNo(userNo);
	}

	@Override
	public void createStudentStaff(StaffVO staff) {
		mapper.insertStudentStaff(staff);
	}

	@Override
	public void modifyRdate(String no) {
		mapper.updateRdate(no);
	}

	@Override
	public int readStaffTotalCountByKeywordR(Map<String, Object> paramMap) {
		return mapper.selectStaffTotalCountByKeywordR(paramMap);
	}

	@Override
	public int readStaffTotalCountR() {
		return mapper.selectStaffTotalCountR();
	}

	@Override
	public List<StaffVO> readStaffListR(Map<String, Object> paramMap) {
		return mapper.selectStaffListR(paramMap);
	}

}
