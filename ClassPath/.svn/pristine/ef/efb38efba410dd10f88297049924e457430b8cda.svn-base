package kr.or.ddit.pfcp.staff.job.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.pfcp.common.vo.JobPostingVO;
import kr.or.ddit.pfcp.staff.job.service.JobRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@RestController
@RequestMapping("/rest/jobs")
@RequiredArgsConstructor
@Slf4j
public class JobRestController {
	
	private final JobRestService jobRestService;
	
	@GetMapping
	public List<JobPostingVO> getAllJobs() {
		log.info("getAllJobs() 호출됨");
		List<JobPostingVO> jobs = jobRestService.getAllPosts();
		log.info("가져온 데이터 수: {}", jobs.size());
		return jobs;
	}

	// 공고 전체 상세 조회
	@GetMapping("/jobsListDetail")
	public List<JobPostingVO> getAllJobsDetail() {
		List<JobPostingVO> jobs = jobRestService.getAllPosts();
		log.info("가져온 데이터 수: {}", jobs);
		return jobs;
	}
	
	// 특정 공고 상세 페이지
	@GetMapping("/jobsPostDetail/{jobId}")
	public List<JobPostingVO> getPostDetails(@PathVariable String jobId) {
		log.info("받은 jobId: {}", jobId);
		log.info("난 호출 되니 안되니..");
		List<JobPostingVO> jobs = jobRestService.getPostDetails(jobId);
		log.info("가져온 데이터 : ", jobs);
		return jobs;
	}
	
	
	
	/**
	 * 취업게시글 목록 전체 조회
	 * @return
	 */
	@GetMapping("jobNoticeList.do")
	public String jobNoticeListUI() {
		return "pfcp/staff/job/jobNoticeList";
	}
	
	/**
	 * 취업게시글 상세 조회
	 * @return
	 */
	@GetMapping("jobNoticeDetail.do")
	public String jobNoticeDetailUI() {
		return "pfcp/staff/job/jobNoticeDetail";
	}
	
	/**
	 * 취업게시글 등록
	 * @return
	 */
	@GetMapping("jobNoticeInsert.do")
	public String jobNoticeInsertUI() {
		return "pfcp/staff/job/jobNoticeInsert";
	}
	
	/**
	 * 취업게시글 수정
	 * @return
	 */
	@GetMapping("jobNoticeUpdate.do")
	public String jobNoticeUpdateUI() {
		return "pfcp/staff/job/jobNoticeDetail";
	}
	
	/**
	 * 취업게시글 삭제
	 * @return
	 */
	@GetMapping("jobNoticeDelete.do")
	public String jobNoticeDeleteUI() {
		return "redirect:/staff/job/jobNoticeList.do";
	}
	
	
}
