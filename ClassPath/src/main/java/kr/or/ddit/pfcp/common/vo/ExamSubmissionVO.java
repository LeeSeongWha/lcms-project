package kr.or.ddit.pfcp.common.vo;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "esNo")
public class ExamSubmissionVO {
	private String esNo;
	private String isSubmitted;
	private String studentNo;
	private String examNo;
	private LocalDateTime startTime;
}
