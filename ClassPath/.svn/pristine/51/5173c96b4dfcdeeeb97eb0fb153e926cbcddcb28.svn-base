package kr.or.ddit.common.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import kr.or.ddit.pfcp.common.service.AtchFileService;
import kr.or.ddit.pfcp.common.service.FileRefService;
import kr.or.ddit.pfcp.common.vo.AtchFileVO;
import kr.or.ddit.pfcp.common.vo.FileRefVO;

/**
 * == 이렇게 쓰시지요 ==
 * 
 * FileUploadRequest req = new FileUploadRequest(
 *	  [VO].getUploadFile(),
 *	  "파일 유형",
 *    [VO].get[PK],
 *    [VO]::setFileRefNo
 * );
 *
 * FileUtils.uploadFile(req);
 * 
 * ex) 학생이 장학금 신청을 할 때 증빙 서류 업로드
 * - kr.or.ddit.pfcp.student.bill.scholarship.controller -> studentScholarshipInsertFormProcess()
 * 
 * FileUploadRequest req = new FileUploadRequest(
 *     scholarshipApply.getUploadFile(),
 *     "SCHOLARSHIP_APPLY",
 *     scholarshipApply.getApplyNo(),
 *     scholarshipApply::setFileRefNo
 * );
 * 
 * FileUtils.uploadFile(req);
 *		
 * @author seokyungdeok
 * @since 2025. 7. 19.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 19.	|	서경덕	|	최초 생성
 */
@Component
public class FileUtils {
	private static AtchFileService staticAtchFileService;
	private static FileRefService staticFileRefService;
	
	@Autowired
	private AtchFileService atchFileService;
	
	@Autowired
	private FileRefService fileRefService;
	
	@PostConstruct
	public void init() {
		staticAtchFileService = atchFileService;
		staticFileRefService = fileRefService;
    }
	
	public static void uploadFile(FileUploadRequest req) throws IOException {
		MultipartFile file = req.getFile();
		
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
            atchFile.setAtchDate(DateUtils.getToday("yyyy-MM-dd"));
            atchFile.setAtchContent(fileBytes);
            
            staticAtchFileService.createAtchFile(atchFile);
            
            // FILE_REF insert
            FileRefVO fileRef = new FileRefVO();
            fileRef.setFileRefNo(fileRefNo);
            fileRef.setFileRefType(req.getFileRefType());
            fileRef.setFileRefTargetId(req.getFileRefTargetId());
            fileRef.setAtchId(atchId);
            
            staticFileRefService.createFileRef(fileRef);
            
            req.setFileRefNo(fileRefNo);
		}
	}
}
