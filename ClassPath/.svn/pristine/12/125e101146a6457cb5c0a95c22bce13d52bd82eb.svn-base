package kr.or.ddit.pfcp.student.certificate.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.pfcp.common.service.AtchFileService;
import kr.or.ddit.pfcp.common.service.FileRefService;
import kr.or.ddit.pfcp.common.service.KakaoPayService;
import kr.or.ddit.pfcp.common.service.UserService;
import kr.or.ddit.pfcp.common.vo.AtchFileVO;
import kr.or.ddit.pfcp.common.vo.CertificateInfoVO;
import kr.or.ddit.pfcp.common.vo.FileRefVO;
import kr.or.ddit.pfcp.common.vo.KakaoPayVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertIssueVO;
import kr.or.ddit.pfcp.common.vo.ProgramCertReqVO;
import kr.or.ddit.pfcp.common.vo.StudentVO;
import kr.or.ddit.pfcp.student.certificate.service.CertificateRequestResult;
import kr.or.ddit.pfcp.student.certificate.service.StudentCertificateService;
import kr.or.ddit.validate.utils.ErrorsUtils;

/**
 * 목록 조회 없음. 상세 조회만 있음.
 * 
 * @author seokyungdeok
 * @since 250630
 * 
 * << 개정이력(Modification Information) >>
 * 수정일	|	수정자	|	수정 내용
 * -----------------------------------------------
 * 250630	|	서경덕	|	최초 생성
 */
@Controller
@RequestMapping("/student/certificate")
public class StudentCertificateController {
	private String tid;
	
	@Autowired
	private StudentCertificateService studentCertificateService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileRefService fileRefService;
	
	@Autowired
	private AtchFileService atchFileService;
	
	static final String MODEL_NAME = "programCertReq";
	
	@Autowired
	private ErrorsUtils errorsUtils;
	
	@ModelAttribute(MODEL_NAME)
	public ProgramCertReqVO programCertReq() {
		return new ProgramCertReqVO();
	}
	
	@GetMapping("{certCode}.do")
	public String certificatePage(
	    @PathVariable String certCode,
	    Principal principal,
	    Model model
	) {
	    String userNo = principal.getName();
	    
	    Map<String, Object> paramMap = new HashMap<>();
	    
    	paramMap.put("certCode", certCode);
    	
    	CertificateInfoVO certificateInfo = studentCertificateService.readCertificateInfo(paramMap);
    	
    	model.addAttribute("certificateInfo", certificateInfo);
    	model.addAttribute("orderId", System.currentTimeMillis());
    	
    	return "pfcp/student/certificate/graduationCertificate";

//	    switch (certCode) {
//	        case "CERT001":
//	        	
//	            return "pfcp/student/certificate/enrollmentCertificate";
//	            
//	        case "CERT002":
//	        	Map<String, Object> paramMap = new HashMap<>();
//	    
//	        	paramMap.put("certCode", certCode);
//	        	
//	        	CertificateInfoVO certificateInfo = studentCertificateService.readCertificateInfo(paramMap);
//	        	
//	        	model.addAttribute("certificateInfo", certificateInfo);
//	        	model.addAttribute("orderId", System.currentTimeMillis());
//	        	
//	            return "pfcp/student/certificate/graduationCertificate";
//	            
//	        case "CERT003":
//	        	
//	            return "pfcp/student/certificate/transcriptCertificate";
//	            
//	        case "CERT004":
//	        	
//	            return "pfcp/student/certificate/scholarshipCertificate";
//	            
//	        default:
//	            throw new IllegalArgumentException("지원하지 않는 증명서 코드입니다: " + certCode);
//	    }
	}
	
	@GetMapping("/kakaopay/cancel")
    public String kakaoPayCancel() {
        return "pfcp/student/certificate/paymentCancel";
    }

    @GetMapping("/kakaopay/fail")
    public String kakaoPayFail() {
        return "pfcp/student/certificate/paymentFail";
    }
	
	@GetMapping("suryoCertificate.do")
	public String suryoCertificate(
		@ModelAttribute(MODEL_NAME) ProgramCertReqVO programCertReq,
		Principal principal,
		@RequestParam String no,
		BindingResult errors,
		RedirectAttributes redirectAttributes
	) {
		if (errors.hasErrors()) {
	        redirectAttributes.addFlashAttribute("errors", errorsUtils.errorsToMap(errors));
	        return "redirect:/student/certificate/programList.do";
	    }
		
	    String userNo = principal.getName();
	    
	    CertificateRequestResult result = studentCertificateService.requestCertificate(no, userNo);

	    switch (result) {
	    	case ALREADY_APPLY:
	    		redirectAttributes.addFlashAttribute("message", "이미 수료증 발급 신청이 완료되었습니다.");
	            break;
	    
	        case ALREADY_ISSUED:
	            redirectAttributes.addFlashAttribute("message", "이미 수료증이 발급되었습니다.");
	            break;
	            
	        case NOT_COMPLETED:
	            redirectAttributes.addFlashAttribute("message", "이수가 완료되지 않았습니다.");
	            break;
	            
	        case SUCCESS:
	            redirectAttributes.addFlashAttribute("message", "수료증 신청이 완료되었습니다.");
	            break;
	    }
		
		return "redirect:/student/program/myParticipationDetail.do?no=" + no;
	}
	
	@PostMapping("/paymentComplete")
	public void paymentComplete(
		@RequestBody Map<String, String> payload,
		HttpServletResponse response,
		Principal principal
	) throws IOException {
		String impUid = payload.get("imp_uid");
	    String merchantUid = payload.get("merchant_uid");
	    String userNo = principal.getName();
	    String certCode = payload.get("certCode");
	    
	    CertificateInfoVO certInfo = studentCertificateService.readCertificateInfo(Map.of("certCode", certCode));
	    StudentVO student = userService.readStudent(userNo);
	    
	    FileRefVO fileRef = fileRefService.readFileRef(certInfo.getFileRefNo());
	    
	    if (fileRef == null) {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.setContentType("application/json; charset=UTF-8");
	        response.getWriter().write("{\"error\": \"아직 해당 증명서가 등록되지 않았습니다. 나중에 다시 시도해주세요.\"}");
	    	
	        return;
	    }
	    
	    AtchFileVO atchFile = atchFileService.readAtchFile(fileRef.getAtchId());
	    
	    byte[] fileContent = atchFile.getAtchContent();
	    System.out.println("템플릿 PDF 바이트 크기: " + (fileContent != null ? fileContent.length : 0));
	    
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "inline; filename=CERT002_certificate.pdf");

	    try (ByteArrayInputStream bais = new ByteArrayInputStream(fileContent)) {

	        // 1. 템플릿 PDF 읽기
	        PdfDocument templatePdf = new PdfDocument(new PdfReader(bais));

	        // 2. 출력 PDF 준비
	        PdfWriter writer = new PdfWriter(response.getOutputStream());
	        PdfDocument pdf = new PdfDocument(writer);

	        // 3. 템플릿 페이지를 새 PDF로 복사
	        templatePdf.copyPagesTo(1, templatePdf.getNumberOfPages(), pdf);

	        // 4. 첫 페이지 가져오기
	        PdfPage page = pdf.getPage(1);
	        System.out.println("페이지 크기: " + page.getPageSize());

	        // 5. Canvas로 글자 오버레이
	        PdfCanvas pdfCanvas = new PdfCanvas(page);
	        Canvas canvas = new Canvas(pdfCanvas, page.getPageSize());

	        String fontPath = new ClassPathResource("static/fonts/NanumGothic-Regular.ttf")
	                .getFile().getPath();
	        PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, pdf);
	        canvas.setFont(font).setFontSize(24);

	        float x = 250;
	        float y = 540;
	        
	        System.out.println("좌표에 텍스트 출력 시작: (" + x + ", " + y + ")");
	        canvas.showTextAligned(student.getUserName(), x, y, TextAlignment.LEFT);
	        canvas.showTextAligned(student.getUserRegno1() + " - *******", x, y - 50, TextAlignment.LEFT);
	        canvas.showTextAligned(student.getCollege().getCollegeName(), x, y - 100, TextAlignment.LEFT);
	        canvas.showTextAligned(student.getDepartmentName(), x, y - 150, TextAlignment.LEFT);
	        canvas.showTextAligned("" + student.getStudentGrade(), x, y - 200, TextAlignment.LEFT);

	        canvas.close();
	        pdf.close();
	        templatePdf.close();
	    }
	    System.out.println("=== PDF 생성 완료 ===");
	}
	
	
	/**
	 * 증명서 발급 내역 조회
	 * 
	 * @return
	 */
	@GetMapping("issuedCertificateHistory.do")
	public String issuedCertificateHistory(
		Principal principal,
		Model model
	) {
		String userNo = principal.getName();
		
		Map<String, Object> paramMap = Map.of(
			"userNo", userNo
		);
		
		List<CertificateInfoVO> certificateList = studentCertificateService.readficateList();
		List<ProgramCertIssueVO> programIssuedList = studentCertificateService.readProgramCertIssuedCertificates(paramMap);
		
		model.addAttribute("certificateList", certificateList);
		model.addAttribute("programIssuedList", programIssuedList);
		
		return "pfcp/student/certificate/issuedCertificateHistory";
	}
	
	@GetMapping("fileDownload.do")
	public void fileDownload(
		@RequestParam("fileRefNo") String fileRefNo,
		HttpServletResponse response
	) throws IOException {
		// FILE_REF에서 ATCH_ID 가져오기
		FileRefVO fileRef = fileRefService.readFileRef(fileRefNo);
		
		if (fileRef == null) {
	        throw new RuntimeException("파일 참조 정보가 없습니다.");
	    }
		
		String atchId = fileRef.getAtchId();
		
		// ATCH_FILE에서 파일 정보 가져오기
	    AtchFileVO atchFile = atchFileService.readAtchFile(atchId);
	    
	    if (atchFile == null || atchFile.getAtchContent() == null) {
	        throw new RuntimeException("파일 정보가 없습니다.");
	    }
	    
	    // 응답 헤더 설정
	    response.setContentType(atchFile.getAtchMime());
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + 
	        new String(atchFile.getAtchOriginName().getBytes("UTF-8"), "ISO-8859-1") + "\"");
	    response.setContentLength((int) atchFile.getAtchSize());

	    // 파일 데이터 쓰기
	    try (OutputStream out = response.getOutputStream()) {
	        out.write(atchFile.getAtchContent());
	        out.flush();
	    }
	}
}
