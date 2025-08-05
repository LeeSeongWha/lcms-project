package kr.or.ddit.pfcp.student.certificate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.CertificateInfoVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertIssueVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertReqVO;
import kr.or.ddit.pfcp.common.vo.ProgramEnrollVO;
import kr.or.ddit.pfcp.common.vo.ProgramVO;
import kr.or.ddit.pfcp.student.certificate.mapper.StudentCertificateMapper;

/**
 * @author seokyungdeok
 * @since 2025. 7. 23.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 23.	|	서경덕	|	최초 생성
 */
@Service(value = "studentCertificateService")
public class StudentCertificateServiceImpl implements StudentCertificateService {
	@Autowired
	private StudentCertificateMapper studentCertificateMapper;

	@Override
	public String readStudentName(String userNo) {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectStudentName(userNo);
	}

	@Override
	public ProgramVO readProgramTitle(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectProgramTitle(paramMap);
	}

	@Override
	public List<ProgramVO> readProgramList(String userNo) {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectProgramList(userNo);
	}

	@Override
	public void createProgramCertReq(ProgramCertReqVO programCertReq) {
		// TODO Auto-generated method stub
		studentCertificateMapper.insertProgramCertReq(programCertReq);
	}

	@Override
	public List<CertificateInfoVO> readficateList() {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectCertificateList();
	}

	@Override
	public ProgramEnrollVO readIsCompleted(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectIsCompleted(paramMap);
	}

	@Override
	public CertificateRequestResult requestCertificate(String programNo, String userNo) {
		Map<String, Object> paramMap = Map.of(
	        "programNo", programNo,
	        "userNo", userNo
	    );
		
		// 1. 수강 정보 조회
	    ProgramEnrollVO programEnroll = studentCertificateMapper.selectIsCompleted(paramMap);
	    
	    if (programEnroll == null) {
	        return CertificateRequestResult.NO_ENROLL;
	    }
	    
	    if (programEnroll.getCertReqno() != null) {
	    	return CertificateRequestResult.ALREADY_APPLY;
	    }
	    
	    // 2. 이미 발급 여부
	    if ("Y".equals(programEnroll.getIsCertIssued())) {
	        return CertificateRequestResult.ALREADY_ISSUED;
	    }

	    // 3. 수료 여부 확인
	    if (!"Y".equals(programEnroll.getIsCompleted())) {
	        return CertificateRequestResult.NOT_COMPLETED;
	    }

	    // 4. 신청 가능: insert 처리
	    String enrollNo = studentCertificateMapper.selectProgramTitle(paramMap).getEnrollNO();

	    ProgramCertReqVO programCertReq = new ProgramCertReqVO();
	    programCertReq.setEnrollNo(enrollNo);
	    programCertReq.setUserNo(userNo);

	    studentCertificateMapper.insertProgramCertReq(programCertReq);

	    return CertificateRequestResult.SUCCESS;
	}

	@Override
	public List<ProgramCertIssueVO> readProgramCertIssuedCertificates(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectProgramCertIssuedCertificates(paramMap);
	}

	@Override
	public CertificateInfoVO readCertificateInfo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return studentCertificateMapper.selectCertificateInfo(paramMap);
	}

}
