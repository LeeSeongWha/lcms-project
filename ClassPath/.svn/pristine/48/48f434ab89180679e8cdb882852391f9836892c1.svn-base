package kr.or.ddit.pfcp.staff.certification.controller;

import java.io.OutputStream;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.io.exceptions.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.common.component.NotificationUtils;
import kr.or.ddit.pfcp.common.service.AtchFileService;
import kr.or.ddit.pfcp.common.service.FileRefService;
import kr.or.ddit.pfcp.common.vo.AtchFileVO;
import kr.or.ddit.pfcp.common.vo.BoardVO;
import kr.or.ddit.pfcp.common.vo.CertificateInfoVO;
import kr.or.ddit.pfcp.common.vo.FileRefVO;
import kr.or.ddit.pfcp.staff.certification.service.StaffCertificationService;
import kr.or.ddit.validate.utils.ErrorsUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YSM
 * @since 250630
 */
@Slf4j
@Controller
@RequestMapping("/staff/certification")
public class StaffCertificationController {
	
	@Autowired
	private StaffCertificationService staffCertificationService;
	
	@Autowired
	private FileRefService fileRefService;
	
	@Autowired
	private AtchFileService atchFileService;
	
	static final String MODELNAME = "certification";
	
	@Autowired
	private ErrorsUtils errorsUtils;
	
	@ModelAttribute(MODELNAME)
	public CertificateInfoVO certification() {
		return new CertificateInfoVO();
	}

	/**
	 * 증명서 폼 목록 전체 조회
	 * @return
	 */
	@GetMapping("certificationFormList.do")
	public String certificationFormListUI(
			Model model
	) {
		List<CertificateInfoVO> certificationList = staffCertificationService.readCertificationList();
		model.addAttribute("certificationList", certificationList);
		
		int totalCount = certificationList.size();
		model.addAttribute("totalCount", totalCount);
		
		return "pfcp/staff/certification/certificationFormList";
	}
	
	
	/**
	 * 증명서 비활성화
	 * @return
	 */
	@GetMapping("certificationActiveToNProcess.do")
	public String certificationActiveToNUI(
		Model model,
		@RequestParam("certCode") String certCode,
		RedirectAttributes redirectAttributes
	) {
		staffCertificationService.modifyCertificationActiveToN(certCode);
//		model.addAttribute("certificationList", certificationList);
		
//		redirectAttributes.addFlashAttribute("alert('비활성화가 완료되었습니다')");
		
		return "redirect:/staff/certification/certificationFormList.do";
	}
	//============================================================================================================

	/**
	 * 증명서 등록 fromProcess
	 * @return
	 * @throws java.io.IOException 
	 */
	@PostMapping("staffCertificationInsertProcess.do")
	public String noticeInsertProcessUI(
		@ModelAttribute(MODELNAME) CertificateInfoVO certificationInfo,
		Principal principal,
		BindingResult errors,
		RedirectAttributes redirectAttributes		
	) throws IOException, java.io.IOException {
		String lvn;
		
		if(!errors.hasErrors()) {
			// -------------------------------
	        // 파일 처리 시작!
	        // -------------------------------
			MultipartFile file = certificationInfo.getUploadFile();
			
			if (file != null && !file.isEmpty()) {
				// ID 생성
	            String atchId = "ATCH" + System.currentTimeMillis();
	            String fileRefNo = "FR" + System.currentTimeMillis();
	            
	            byte[] fileBytes = file.getBytes();

	            // ATCH_FILE insert
	            AtchFileVO atchFile = new AtchFileVO();
	            atchFile.setAtchId(atchId);
	            atchFile.setAtchMime(file.getContentType());
	            atchFile.setAtchOriginName(file.getOriginalFilename());
	            atchFile.setAtchSaveName(atchId + "_" + file.getOriginalFilename());
	            atchFile.setAtchSize(file.getSize());
	            atchFile.setAtchDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
	            atchFile.setAtchContent(fileBytes);
	            
	            atchFileService.createAtchFile(atchFile);
	            
	            // FILE_REF insert
	            FileRefVO fileRef = new FileRefVO();
	            fileRef.setFileRefNo(fileRefNo);
	            fileRef.setFileRefType("CERTIFICATION_FORM");
	            fileRef.setFileRefTargetId(certificationInfo.getCertCode());
	            fileRef.setAtchId(atchId);
	            
	            fileRefService.createFileRef(fileRef);
	            
	            certificationInfo.setFileRefNo(fileRefNo);
			}
			// -------------------------------
	        // 파일 처리 끝!
	        // -------------------------------
			staffCertificationService.createCertificateInfo(certificationInfo);
			
			log.info("qwer");
			
			// 알림 발송 로직
//			NotificationUtils.sendToStudent("새로운 증명서 목록이 등록되었습니다", "/staff/notice/noticeDetail.do?what=" + certificationInfo.getCertCode());
			
			redirectAttributes.addFlashAttribute("success", "등록 완료!");
			
			lvn = "redirect:/staff/certification/certificationFormList.do";
		} else {
			redirectAttributes.addFlashAttribute(MODELNAME, certificationInfo);
			
			MultiValueMap<String, String> customErrors = errorsUtils.errorsToMap(errors);
			redirectAttributes.addFlashAttribute("errors", customErrors);
			lvn = "redirect:/staff/certification/certificationFormList.do";
		}
		
		return lvn;
	}
	
	
	
	//============================================================================================================
	
	/**
	 * 증명서 폼 목록 등록
	 * @return
	 * @throws java.io.IOException 
	 */
	@PostMapping("certificationFormInsertProcess.do")
	public String certificationFormInsertUI(
		Model model,
		@ModelAttribute(MODELNAME) CertificateInfoVO certificateInfo,
		BindingResult errors,
		RedirectAttributes redirectAttributes
	) throws java.io.IOException {
		// -------------------------------
        // 파일 처리 시작!
        // -------------------------------
		MultipartFile file = certificateInfo.getUploadFile();
		
		if (file != null && !file.isEmpty()) {
			// ID 생성
            String atchId = "ATCH" + System.currentTimeMillis();
            String fileRefNo = "FR" + System.currentTimeMillis();
            
            byte[] fileBytes = file.getBytes();

            // ATCH_FILE insert
            AtchFileVO atchFile = new AtchFileVO();
            atchFile.setAtchId(atchId);
            atchFile.setAtchMime(file.getContentType());
            atchFile.setAtchOriginName(file.getOriginalFilename());
            atchFile.setAtchSaveName(atchId + "_" + file.getOriginalFilename());
            atchFile.setAtchSize(file.getSize());
            atchFile.setAtchDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            atchFile.setAtchContent(fileBytes);
            
            atchFileService.createAtchFile(atchFile);
            
            // FILE_REF insert
            FileRefVO fileRef = new FileRefVO();
            fileRef.setFileRefNo(fileRefNo);
            fileRef.setFileRefType("CERTIFICATION_FORM");
            fileRef.setFileRefTargetId(certificateInfo.getCertCode());
            fileRef.setAtchId(atchId);
            
            fileRefService.createFileRef(fileRef);
            
            certificateInfo.setFileRefNo(fileRefNo);
            
            String certCode = certificateInfo.getCertCode();
            staffCertificationService.modifyFileRefNo(certCode, fileRefNo);
            
            log.info("fileRefNo : {}", fileRefNo);
            log.info("여기까지 옴..??");
		}
		// -------------------------------
        // 파일 처리 끝!
        // -------------------------------
		
		
		
		return "redirect:/staff/certification/certificationFormList.do";
	}
	
	
	
	/**
	 * 증명서 폼 목록 pdf 불러오기
	 * @return
	 * @throws java.io.IOException 
	 */
	@GetMapping("serveCertificationFormPdf.do")
	@ResponseBody
	public void certificationFormPdfUI(
	        @RequestParam("certCode") String certCode, 
	        HttpServletResponse response,
	        HttpServletRequest request
	) throws IOException, java.io.IOException {
	    
	    try {
	        log.info("PDF 요청 - certCode: {}", certCode);
	        
	        // 1. fileRefNo 조회
	        String fileRefNo = staffCertificationService.readFileRefNo(certCode);
	        log.info("조회된 fileRefNo: {}", fileRefNo);
	        
	        if (fileRefNo == null || fileRefNo.trim().isEmpty()) {
	            log.error("fileRefNo가 없습니다. certCode: {}", certCode);
	            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            response.getWriter().write("파일 참조 정보를 찾을 수 없습니다.");
	            return;
	        }

	        // 2. 파일 참조 정보 조회
	        FileRefVO fileRef = fileRefService.readFileRef(fileRefNo);
	        log.info("파일 참조 정보 조회 완료: {}", fileRef != null);
	        
	        if (fileRef == null) {
	            log.error("파일 참조 정보가 없습니다. fileRefNo: {}", fileRefNo);
	            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            response.getWriter().write("파일 참조 정보가 없습니다.");
	            return;
	        }
	        
	        String atchId = fileRef.getAtchId();
	        log.info("첨부파일 ID: {}", atchId);

	        // 3. 첨부파일 정보 조회
	        AtchFileVO atchFile = atchFileService.readAtchFile(atchId);
	        log.info("첨부파일 조회 완료 - 파일명: {}, 크기: {}", 
	                atchFile != null ? atchFile.getAtchOriginName() : "null",
	                atchFile != null ? atchFile.getAtchSize() : 0);
	        
	        if (atchFile == null || atchFile.getAtchContent() == null) {
	            log.error("첨부파일 정보가 없습니다. atchId: {}", atchId);
	            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            response.getWriter().write("파일 정보가 없습니다.");
	            return;
	        }
	        
	        // 4. PDF 파일인지 확인
	        String mimeType = atchFile.getAtchMime();
	        if (mimeType == null || !mimeType.equals("application/pdf")) {
	            log.warn("PDF가 아닌 파일입니다. MIME Type: {}", mimeType);
	            // PDF가 아니어도 응답은 보내되, 클라이언트에서 처리하도록
	        }

	        // 5. 응답 헤더 설정
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "inline; filename=\"" + 
	            new String(atchFile.getAtchOriginName().getBytes("UTF-8"), "ISO-8859-1") + "\"");
	        response.setContentLength((int) atchFile.getAtchSize());
	        response.setHeader("Cache-Control", "no-cache");

	        // 6. 파일 데이터 전송
	        try (OutputStream out = response.getOutputStream()) {
	            out.write(atchFile.getAtchContent());
	            out.flush();
	            log.info("PDF 파일 전송 완료");
	        }

	    } catch (Exception e) {
	        log.error("PDF 파일 서비스 오류: ", e);
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        
	        // AJAX 요청이므로 JSON 형태로 오류 응답
	        response.setContentType("application/json");
	        response.getWriter().write("{\"error\": \"PDF 파일을 불러올 수 없습니다: " + e.getMessage() + "\"}");
	    }
	}


	
	
	
	
	@GetMapping("/cert/student")
	public void generateStudentCertificate(@RequestParam String studentId, HttpServletResponse response)
			throws IOException {
		staffCertificationService.generateStudentCertificateById(studentId, response);
	}

	// ======================================================================================
	
	
	
	/**
	 * 증명서 폼 상세 조회
	 * @return
	 */
	@GetMapping("certificationFormDetail.do")
	public String certificationFormDetailUI() {
		return "pfcp/staff/certification/certificationFormDetail";
	}
	
	/**
	 * 증명서 폼 등록
	 * @return
	 */
	@GetMapping("certificationFormInsert.do")
	public String certificationFormInsertUI() {
		return "pfcp/staff/certification/certificationFormInsert";
	}
	
	/**
	 * 증명서 폼 수정
	 * @return
	 */
	@GetMapping("certificationFormUpdate.do")
	public String certificationFormUpdateUI() {
		return "pfcp/staff/certification/certificationFormDetail";
	}
}
