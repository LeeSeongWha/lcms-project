package kr.or.ddit.pfcp.staff.lecturemanage.lecture.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.common.vo.LectureVO;
import kr.or.ddit.pfcp.staff.lecturemanage.lecture.mapper.StaffLectureMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StaffLectureServiceImpl implements StaffLectureService {

	private final StaffLectureMapper mapper;
	
//	@Override
//	public List<LectureVO> readLectureList(int offset, int totalPage) {
//		return mapper.selectLectureList(offset, totalPage);
//	}

//	@Override
//	public int readTotalCount() {
//		return mapper.selectTotalCount();
//	}

//	@Override
//	public List<LectureEnrVO> readLectureStudent(String what) {
//		return mapper.selectLectureStudent(what);
//	}
//
//	@Override
//	public int readLectureStudentTotalCount(String what) {
//		return mapper.selectLectureStudentTotalCount(what);
//	}

	// 강의 목록 조회 =============================
	@Override
	public List<LectureVO> readLectureList(Map<String, Object> paramMap) {
		return mapper.selectLectureList(paramMap);
	}

	@Override
	public int readLectureTotalCountByKeyword(Map<String, Object> paramMap) {
		return mapper.selectLectureTotalCountByKeyword(paramMap);
	}

	@Override
	public int readLectureTotalCount() {
		return mapper.selectLectureTotalCount();
	}

	
	// 강의 강의 수강생 목록 조회 =============================
	@Override
	public List<LectureEnrVO> readLectureStudent(Map<String, Object> paramMap) {
		return mapper.selectLectureStudent(paramMap);
	}
	
	@Override
	public int readLectureStudentTotalCountByKeyword(Map<String, Object> paramMap) {
		return mapper.selectLectureStudentTotalCountByKeyword(paramMap);
	}

	@Override
	public int readLectureStudentTotalCount(String what) {
		return mapper.selectLectureStudentTotalCount(what);
	}


}
