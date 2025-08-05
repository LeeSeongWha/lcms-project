package kr.or.ddit.pfcp.common.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author YSM
 * @since 250722
 * 
 *        << 개정이력(Modification Information) >> 수정일 | 수정자 | 수정 내용
 *        ----------------------------------------------- 250722 | 양수민 | 최초 생성
 *        
 */

@Data
@EqualsAndHashCode(of="benefitId")
@Entity
@Table(name = "job_benefit")
public class jobBenefitVO {
	@Id
	private Integer benefitId;
	private String jobId;
	private String benefitContent;
}
