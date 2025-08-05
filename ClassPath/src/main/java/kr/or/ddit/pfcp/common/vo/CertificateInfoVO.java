package kr.or.ddit.pfcp.common.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author YSM
 * @since 2025. 7. 19.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 19.	|	양수민	|	최초 생성
 * 
 */
@Data
@EqualsAndHashCode(of = "certCode")
public class CertificateInfoVO {
	
	@NotBlank
	private String certCode;
	@NotBlank
	private String certName;
	private String certDesc;
	private String isActive;
	private Integer issueFee;
	
	// ADDED
	private String fileRefNo;
	private AtchFileVO atchFile;
	private MultipartFile uploadFile;
	private byte[] atchContent;
}
