package kr.or.ddit.pfcp.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "orderId")
public class KakaoPayVO {
	private String orderId;
	private String tid;
	private String userNo;
	private String createdAt;
}
