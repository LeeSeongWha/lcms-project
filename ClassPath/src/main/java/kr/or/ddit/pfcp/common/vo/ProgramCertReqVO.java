package kr.or.ddit.pfcp.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= "certReqno")
public class ProgramCertReqVO {
	private String certReqno;
	private String enrollNo;
	private String userNo;
	private String cerreqDate;
	private String cerreqStatus;
	private String cerreqComment;
}
