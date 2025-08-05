package kr.or.ddit.pfcp.staff.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.JobPostingVO;
import kr.or.ddit.pfcp.staff.job.mapper.JobRestMapper;
import lombok.RequiredArgsConstructor;

/**
*
* @author 양수민
* @since 2025.06.28
* @see
*
* 수정일         |     수정자 |   수정 내용
* ------------|-------------|--------------------------
* 2025.06.28  |     양수민     |  최초 작성
* 2025.07.23  |     양수민     |  작업 시작
*/
@Service
@RequiredArgsConstructor
public class JobRestServiceImpl implements JobRestService {

	private final JobRestMapper jobRestMapper;
	
	@Override
	public List<JobPostingVO> getAllPosts() {
		return jobRestMapper.selectAllPosts();
	}

	@Override
	public List<JobPostingVO> getPostDetails(String jobId) {
		return jobRestMapper.selectPostDetails(jobId);
	}

}
