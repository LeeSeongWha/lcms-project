package kr.or.ddit.common.util;

import java.util.function.Consumer;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileUploadRequest {
	private final MultipartFile file;
    private final String fileRefType;
    private final String fileRefTargetId;
    private final Consumer<String> fileRefNoConsumer; // 저장 후 VO에 fileRefNo 세팅

    public FileUploadRequest(MultipartFile file, String fileRefType, String fileRefTargetId, Consumer<String> fileRefNoConsumer) {
        this.file = file;
        this.fileRefType = fileRefType;
        this.fileRefTargetId = fileRefTargetId;
        this.fileRefNoConsumer = fileRefNoConsumer;
    }
    
    public void setFileRefNo(String fileRefNo) {
        fileRefNoConsumer.accept(fileRefNo);
    }
}
