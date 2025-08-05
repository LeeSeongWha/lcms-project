package kr.or.ddit.pfcp.staff.college.service;

import java.util.List;

import kr.or.ddit.pfcp.common.vo.CollegeVO;

/**
 * @author KGM
 * @since 250701
 * @see
 */
public interface CollegeService {
	public CollegeVO readColleageName(String collegeNo);
	
	/**
	 * 이거는 전체단과 조회
	 * @return
	 */
	public List<CollegeVO> readCollegeList();
	
	/**
	 * 이거는 단과대학번호로 학과조회
	 * @param collegeNo
	 * @return
	 */
	public CollegeVO readCollege(String collegeNo);
	
	public int createCollege(CollegeVO college);
	public void modifyCollege(CollegeVO college);
	
	public void disableCollege(String collegeNo);
	
	
	
	public CollegeVO readCollegeByCollegeNo(String collegeNo);
}
