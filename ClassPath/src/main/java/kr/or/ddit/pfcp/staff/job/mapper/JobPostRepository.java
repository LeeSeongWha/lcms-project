package kr.or.ddit.pfcp.staff.job.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.or.ddit.pfcp.common.vo.JobPostingVO;

//@Repository
public interface JobPostRepository extends JpaRepository<JobPostingVO, String> {
	
}
