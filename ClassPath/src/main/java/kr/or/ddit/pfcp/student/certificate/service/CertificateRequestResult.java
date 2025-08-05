package kr.or.ddit.pfcp.student.certificate.service;

public enum CertificateRequestResult {
	SUCCESS,          // 신청 완료
	ALREADY_APPLY,	  // 이미 발급 신청 완료
    ALREADY_ISSUED,   // 이미 발급됨
    NOT_COMPLETED,    // 이수 미완료
    NO_ENROLL         // 수강 이력 없음
}
