package kr.or.ddit.pfcp.staff.lecturemanage.lecture.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.common.vo.LectureVO;

@Mapper
public interface StaffLectureMapper {

//	public int selectLectureStudentTotalCount(String what);

//	public List<LectureVO> selectLectureList(@Param("offset") int offset, @Param("pageSize") int pageSize);

//	public int selectTotalCount();

//	public List<LectureEnrVO> selectLectureStudent(String what);

	// 강의 목록 조회
	public List<LectureVO> selectLectureList(Map<String, Object> paramMap);

	public int selectLectureTotalCountByKeyword(Map<String, Object> paramMap);

	public int selectLectureTotalCount();

	// 강의 수강생 목록 조회
	public List<LectureEnrVO> selectLectureStudent(Map<String, Object> paramMap);

	public int selectLectureStudentTotalCount(String what);

	public int selectLectureStudentTotalCountByKeyword(Map<String, Object> paramMap);

	
	

}
