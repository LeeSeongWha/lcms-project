package kr.or.ddit.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PdfCertGenerator {

	public static byte[] generatePdf(String studentName, String programTitle, String issueDate) {

		// Null-safe 기본값
		if (studentName == null || studentName.isBlank())
			studentName = "수료자 없음";
		if (programTitle == null || programTitle.isBlank())
			programTitle = "프로그램명 없음";
		if (issueDate == null || issueDate.isBlank())
			issueDate = "발급일자 없음";

		try {
			// 문서 생성
			Document document = new Document(PageSize.A4, 50, 50, 70, 50);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, out);
			document.open();

			// 1. 폰트 로딩
			InputStream fontStream = PdfCertGenerator.class.getResourceAsStream("/static/fonts/Pretendard-Regular.ttf");
			if (fontStream == null) {
				throw new RuntimeException("Pretendard 폰트를 찾을 수 없습니다.");
			}
			BaseFont baseFont = BaseFont.createFont("Pretendard-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED,
					true, fontStream.readAllBytes(), null);
			Font titleFont = new Font(baseFont, 24, Font.BOLD);
			Font bodyFont = new Font(baseFont, 11);

			// 2. 배경 이미지 로딩 및 설정
			InputStream imageStream = PdfCertGenerator.class
					.getResourceAsStream("/static/dist/assets/img/buengIssue.png");
			if (imageStream == null) {
				throw new RuntimeException("배경 이미지 파일을 찾을 수 없습니다.");
			}

			Image bgImage = Image.getInstance(imageStream.readAllBytes());
			bgImage.scaleToFit(500f, 620f); // 테두리 안에 최대한 꽉 차게
			float x = (PageSize.A4.getWidth() - bgImage.getScaledWidth()) / 2;
			float y = (PageSize.A4.getHeight() - bgImage.getScaledHeight()) / 2;
			bgImage.setAbsolutePosition(x, y);
			bgImage.setTransparency(new int[] { 0x00, 0x10 });

			PdfContentByte canvas = writer.getDirectContentUnder();
			canvas.addImage(bgImage); // 배경으로 삽입

			// 3. 텍스트 내용 (이미지 위에 얹힘)
			Paragraph title = new Paragraph("비교과 프로그램 이수증", titleFont);
			title.setAlignment(Paragraph.ALIGN_CENTER);
			title.setSpacingAfter(60f);
			document.add(title);
			
			Paragraph spacer = new Paragraph();
			spacer.setSpacingBefore(40f);
			document.add(spacer);


			Paragraph name = new Paragraph("수료자명: " + studentName, bodyFont);
			name.setAlignment(Paragraph.ALIGN_LEFT);           
			name.setIndentationLeft(65f);                    
			name.setSpacingAfter(8f);
			document.add(name);

			Paragraph program = new Paragraph("프로그램명: " + programTitle, bodyFont);
			program.setAlignment(Paragraph.ALIGN_LEFT);
			program.setIndentationLeft(65f);
			program.setSpacingAfter(8f);
			document.add(program);

			Paragraph date = new Paragraph("발급일자: " + issueDate, bodyFont);
			date.setAlignment(Paragraph.ALIGN_LEFT);
			date.setIndentationLeft(65f);
			date.setSpacingAfter(20f);
			document.add(date);


			Paragraph desc = new Paragraph("위 사람은 위 프로그램을 성실히 이수하였음을 확인하며 이에 이수증을 발급합니다.", bodyFont);
			desc.setAlignment(Paragraph.ALIGN_CENTER);
			desc.setSpacingBefore(60f);  // ✔ 더 아래로 내려 깔끔하게
			desc.setSpacingAfter(20f);

			document.add(desc);

			Paragraph footer = new Paragraph("(기관명 또는 담당자 서명)", bodyFont);
			footer.setAlignment(Paragraph.ALIGN_RIGHT);
			footer.setSpacingBefore(30f);
			footer.setIndentationRight(60f); // 기존보다 왼쪽으로 옮김
			document.add(footer);

			document.close();
			return out.toByteArray();

		} catch (Exception e) {
			log.error("PDF 생성 중 오류 발생", e);
			return null;
		}
	}
}
