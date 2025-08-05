package kr.or.ddit.pfcp.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author seokyungdeok
 * @since 2025. 7. 28.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 28.	|	서경덕	|	최초 생성
 */
@Data
@EqualsAndHashCode(of = "evalScore")
public class ProgramEvalScoreVO {
	private Integer evalScore;
	private String evalNo;
	private String criteriaNo;
}
