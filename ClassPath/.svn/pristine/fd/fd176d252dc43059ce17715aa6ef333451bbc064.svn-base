package kr.or.ddit.pfcp.staff.program.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.pfcp.common.vo.FacilityVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertIssueVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertReqVO;
import kr.or.ddit.pfcp.common.vo.ProgramEnrollVO;
import kr.or.ddit.pfcp.common.vo.ProgramFeedbackVO;
import kr.or.ddit.pfcp.common.vo.ProgramVO;
import kr.or.ddit.pfcp.common.vo.TypeVO;

@Mapper
public interface StaffProgramMapper {
	
	public List<ProgramVO> selectProgramList();
	
	public List<ProgramVO> selectOpenProgramList();
	
	public ProgramVO selectProgramById(String programNo);
	
	public List<TypeVO> selectProgramType();
	
	public int insertProgram(ProgramVO program);
	
	public int updateProgram(ProgramVO program);
	
	public int deleteProgram(String programNo);
	
	public ProgramVO selectProgramWithEnroll(String programNo);

	public int updateAttended(ProgramEnrollVO enrollVo);
	
	public int updateCompletion(ProgramEnrollVO enrollVo);
	
	public int updateIsCertIssued(String enrollNo);
	
	public ProgramEnrollVO selectEnrollWithCertReq(String enrollNo);
	
	public int insertCertIssue(ProgramCertIssueVO certIssue);
	
	public int updateCertReqStatus(@Param("certReqno") String certReqno);
	
	public ProgramCertIssueVO selectIssueWithFileByReqno(@Param("certReqno") String certReqno);
	
	public List<ProgramFeedbackVO> selectFeedbackStatsByProgram();
	
	public List<Map<String, Object>> selectSatisfactionGroupedByType();
	
	public List<FacilityVO> selectFaciltyByProgram();
}
