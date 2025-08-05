package kr.or.ddit.pfcp.student.eclass.exam.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.pfcp.common.vo.ExamSubmissionVO;
import kr.or.ddit.pfcp.common.vo.ExamVO;
import kr.or.ddit.pfcp.common.vo.StudentExamSubmitRequest;
import kr.or.ddit.pfcp.student.eclass.exam.service.ExamService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/rest/exam")
@Slf4j
public class ExamRestController {
	@Autowired
	private ExamService examService;

	@GetMapping("{userNo}/{lecNo}")
	public ResponseEntity<List<ExamVO>> readExamList(@PathVariable String userNo, @PathVariable String lecNo) {
		List<ExamVO> examList = examService.readExamList(userNo, lecNo);
		
		return ResponseEntity.ok(examList);
	}
	
	@GetMapping("{examNo}")
	public ResponseEntity<ExamVO> readExamDetail(
		@PathVariable String examNo
	) {
		ExamVO exam = examService.readExamDetail(examNo);
		
		return ResponseEntity.ok(exam);
	}
	
	@GetMapping("{examNo}/pdf")
	public ResponseEntity<byte[]> getExamPdf(@PathVariable String examNo) {
		ExamVO rawContent = examService.readPdfContentByExamNo(examNo);
		byte[] content = rawContent.getAtchContent();
	    
	    if (content == null) {
	        throw new RuntimeException("PDF content is null!");
	    }
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
	    headers.setContentDispositionFormData("inline", "exam.pdf");
	    return ResponseEntity.ok()
	        .headers(headers)
	        .body(content);
	}


	@GetMapping("/no")
	public ResponseEntity<?> getExamNoByExamName(
		@RequestParam String examName,
        @RequestParam String lecNo
	) {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("examName", examName);
		paramMap.put("lecNo", lecNo);

	    String examNo = examService.readExamNoByExamName(paramMap);
	    
	    if (examNo == null) {
	        return ResponseEntity.notFound().build();
	    }

	    HttpHeaders headers = new HttpHeaders();
	    headers.setCacheControl("no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");
	    headers.add("ETag", "");

	    return ResponseEntity.ok()
	        .headers(headers)
	        .body(Map.of("examNo", examNo));
	}
	
	@GetMapping("/question-count")
	public ResponseEntity<?> getQuestionCountByExamNo(@RequestParam String examNo) {
	    int count = examService.readQuestionCountByExamNo(examNo);
	    return ResponseEntity.ok(Map.of("questionCount", count));
	}
	
	@PostMapping("/submit")
    public ResponseEntity<?> submitExam(@RequestBody StudentExamSubmitRequest request) {
		ExamVO exam = examService.readExamDetail(request.getExamNo());
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("userNo", request.getUserNo());
		paramMap.put("examNo", request.getExamNo());
		
		ExamSubmissionVO submission = examService.readExamSubmission(paramMap);
		
		if (submission == null || submission.getStartTime() == null) {
	        return ResponseEntity.badRequest().body(Map.of("message", "시험 시작 기록이 없습니다."));
	    }
		
		int limitMinutes = Integer.parseInt(exam.getExamLimit().replaceAll("[^0-9]", ""));
	    LocalDateTime deadline = submission.getStartTime().plusMinutes(limitMinutes);
	    
	    if (LocalDateTime.now().isAfter(deadline)) {
	        return ResponseEntity.badRequest().body(Map.of("message", "시험 시간이 종료되었습니다."));
	    }
		
        int score = examService.calculateScore(request.getExamNo(), request.getAnswers());

        String examType = examService.getExamType(request.getExamNo());
        
        examService.saveGrade(request.getExamNo(), request.getUserNo(), score, examType);
        examService.upsertExamSubmission(request.getUserNo(), request.getExamNo());

        return ResponseEntity.ok(Map.of("message", "시험 제출 완료", "score", score));
    }
	
	@PostMapping("/start")
	public ResponseEntity<?> startExam(
        @RequestParam String userNo,
        @RequestParam String examNo
	) {
	    LocalDateTime startTime = examService.startExam(userNo, examNo);
	    
	    return ResponseEntity.ok(Map.of("startTime", startTime));
	}
	
	@GetMapping("/submission-status")
	public ResponseEntity<?> checkSubmissionStatus(@RequestParam String userNo, @RequestParam String examNo) {
		String status = examService.readSubmissionStatus(userNo, examNo);
		return ResponseEntity.ok(Map.of("isSubmitted", status != null ? status : "N"));
	}
}