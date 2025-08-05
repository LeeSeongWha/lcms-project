package kr.or.ddit.pfcp.student.certificate.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.pfcp.common.vo.CertificateInfoVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertIssueVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertReqVO;
import kr.or.ddit.pfcp.common.vo.ProgramEnrollVO;
import kr.or.ddit.pfcp.common.vo.ProgramVO;

/**
 * @author seokyungdeok
 * @since 2025. 7. 23.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 23.	|	서경덕	|	최초 생성
 */
public interface StudentCertificateService {
	public List<CertificateInfoVO> readficateList();
	
	public List<ProgramVO> readProgramList(String userNo);
	
	public ProgramEnrollVO readIsCompleted(Map<String, Object> paramMap);
	
	public String readStudentName(String userNo);
	
	public List<ProgramCertIssueVO> readProgramCertIssuedCertificates(Map<String, Object> paramMap);
	
	public ProgramVO readProgramTitle(Map<String, Object> paramMap);
	
	public void createProgramCertReq(ProgramCertReqVO programCertReq);
	
	public CertificateRequestResult requestCertificate(String programNo, String userNo);
	
	public CertificateInfoVO readCertificateInfo(Map<String, Object> paramMap);
}
