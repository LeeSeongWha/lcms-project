package kr.or.ddit.pfcp.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.StudentVO;
import kr.or.ddit.pfcp.common.vo.UserDataVO;
import kr.or.ddit.pfcp.common.vo.UserVO;

@Mapper
public interface UserMapper {
	public UserVO selectUser(String userNo);

	public String findUserId(UserDataVO userdata);

	public int countByEmail(String email);

	public int updateUserPassword(UserVO user);

	public UserVO findUserEmail(String email);

	public List<String> selectAllStudentList();
	
	public StudentVO selectStudent(String userNo);
	
	public List<String> selectAllProfessorList();
	
	public List<String> selectAllStaffList();
	
	public int changeUserPassword(UserVO user);
}
