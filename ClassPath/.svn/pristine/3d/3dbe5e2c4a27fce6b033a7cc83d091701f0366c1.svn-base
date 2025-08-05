package kr.or.ddit.pfcp.student.counsel.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.PaginationInfo;
import kr.or.ddit.pfcp.common.vo.CounselReqVO;
import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.student.counsel.mapper.StudentCounselMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentCounselServiceImpl implements StudentCounselService {
	private final StudentCounselMapper mapper;
	
	@Override
	public void createStudentCounsel(CounselReqVO counselReq) {
		
		mapper.insertStudentCounsel(counselReq);
	}
	
	@Override
	public List<CounselReqVO> readStudentDepartmentCounselList(Map<String, Object> paramMap) {
		
		return mapper.selectStudentDepartmentCounselList(paramMap);
	}
	
	@Override
	public List<CounselReqVO> readStudentEmploymentCounselList(Map<String, Object> paramMap) {
		
		return mapper.selectStudentEmploymentCounselList(paramMap);
	}

	@Override
	public CounselReqVO readStudent(String counselReqno) {
		
		return mapper.selectStudentCounsel(counselReqno);
	}

	@Override
	public void removeStudentDepartmentCounsel(String counselReqno) {
		
		mapper.deleteStudentDepartmentCounselList(counselReqno);
	}

	@Override
	public List<LectureEnrVO> readProfessorList(String userNo) {
		// TODO Auto-generated method stub
		return mapper.selectProfessorList(userNo);
	}

	@Override
	public List<Map<String, Object>> readAvailableTimesByProfessor(String userNo) {
		// TODO Auto-generated method stub
		return mapper.selectAvailableTimesByProfessor(userNo);
	}

	@Override
	public int readDepartmentCounselTotalCount() {
		// TODO Auto-generated method stub
		return mapper.selectDepartmentCounselTotalCount();
	}

	@Override
	public int readEmploymentCounselTotalCount() {
		// TODO Auto-generated method stub
		return mapper.selectEmploymentCounselTotalCount();
	}
}
