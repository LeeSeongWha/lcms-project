package kr.or.ddit.pfcp.staff.certification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.CertificateInfoVO;

@Mapper
public interface StaffCertificationMapper {

	public List<CertificateInfoVO> selectCertificationList();

	public String selectFileRefNo(String certCode);

	public void updateFileRefNo(String certCode, String fileRefNo);

	public void insertCertificateInfo(CertificateInfoVO certificationInfo);

	public void updateCertificationActiveToN(String certCode);


}
