package kr.or.ddit.pfcp.staff.lecturemanage.lecture.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.common.vo.LectureVO;

public interface StaffLectureService {

//	public int readTotalCount();
//	public List<LectureEnrVO> readLectureStudent(String what);
//	public int readLectureStudentTotalCount(String what);
	
	// 강의 목록 조회
	public List<LectureVO> readLectureList(Map<String, Object> paramMap);
	public int readLectureTotalCountByKeyword(Map<String, Object> paramMap);
	public int readLectureTotalCount();
	
	// 강의 수강생 조회
	public int readLectureStudentTotalCountByKeyword(Map<String, Object> paramMap);
	public int readLectureStudentTotalCount(String what);
	public List<LectureEnrVO> readLectureStudent(Map<String, Object> paramMap);

}
