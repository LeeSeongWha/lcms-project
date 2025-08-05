<%--
 * 개정이력
 * 수정일		수정자	수정내용
 * ========================================
 * 250709	김태수	최초 생성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<title>논문 신청 상세 조회</title>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">  
<link rel="stylesheet" href="/dist/assets/css/pdfView.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="<c:url value='/js/app/pfcp/common/pdfView.js'/>"></script>  


<h2 class="sectionTitle">논문 신청 상세 조회</h2>
<div class="section">
    <div class="card">
        <form style="display:contents"> 
			<div class="form-row" style="display: flex; gap: 20px;">
				<div class="form-group" style="flex: 1;">
					<label for="thesisTitle" class="inputLabel">제목</label> 
					<input type="text" id="thesisTitle" name="thesisTitle" class="inputField" value="${thesis.thesisTitle }" readonly>
				</div>
			</div>
			<div class="form-row" style="display: flex; gap: 20px;">
				<div class="form-group" style="flex: 1;">
					<label for="thesisNo" class="inputLabel">논문 번호</label>
					<input type="text" id="thesisNo" name="thesisNo" class="inputField" value="${thesis.thesisNo}" readonly>
				</div>
				<div class="form-group" style="flex: 1;">
					<label for="userNo" class="inputLabel">신청자(교수 이름)</label>
                	<input type="text" id="userNo" name="userNo"  class="inputField" readonly value="${thesis.userName}">
				</div>
			</div>
			<div class="form-row" style="display: flex; gap: 20px;">
				<div class="form-group" style="flex: 1;">
					<label for="submitDate" class="inputLabel">신청일</label> 
					<%-- submitDate가 이미 "YYYY-MM-DD" 형태의 String이라면 이렇게 바로 출력 --%>
					<input type="text" id="submitDate" name="submitDate" class="inputField" value="${thesis.submitDate}" readonly> 
				</div>
			</div>
			<div class="form-row" style="display: flex; gap: 20px;">
				<div class="form-group" style="flex: 1;">
				    <label for="status" class="inputLabel">처리 현황</label>
					<c:choose>
						<c:when test="${thesis.status eq '대기'}">
							<span class="badge badgeGreen inputField-like-badge">대기</span>
						</c:when>
						<c:when test="${thesis.status eq '반려'}">
							<span class="badge badgeYellow inputField-like-badge">반려</span>
						</c:when>
						<c:when test="${thesis.status eq '취소'}">
							<span class="badge badgeRed inputField-like-badge">취소</span>
						</c:when>
						<c:when test="${thesis.status eq '승인'}">
							<span class="badge badgeBlue inputField-like-badge">승인</span>
						</c:when>
						<c:otherwise>
							<span class="badge inputField-like-badge">${thesis.status}</span>
						</c:otherwise>
					</c:choose>
				</div>
			        <div class="form-group" style="flex: 1;">
			            <label for="rejReason" class="inputLabel">반려 사유</label>
			            <input type="text" id="rejReason" name="rejReason" class="inputField" value="${thesis.rejReason}" readonly>
			        </div>
			    
			</div>
			<div class="form-row" style="display: flex; gap: 20px;">
				<div class="form-group" style="flex: 1;">
					<label for="fileRefNo" class="inputLabel">첨부파일</label>
					<c:choose>
						<c:when test="${not empty thesis.fileRefNo}">
							<a href="/professor/lecture/fileDownload.do?fileRefNo=${thesis.fileRefNo}" download class="download-button"> <i class="fas fa-download"></i> ${thesis.atchFile.atchOriginName}</a>
						</c:when>
						<c:otherwise>
							<a download class="download-button"> No File </a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
            <div style="text-align: right; margin-top: 20px;">
                <button type="button" class="cancelButton" onclick="location.href='<c:url value="/pfcp/staff/thesis/thesisList.do"/>'" style="float:right; ">목록</button>
                
                <c:if test="${thesis.status eq '대기'}"> 
                    <button type="button" class="deleteButton" id="rejectButton" style="float:right; margin-right:20px;">반려</button>
                    <button type="button" class="editButton" id="approveButton" style="float:right; margin-right:20px;">승인</button>
                </c:if>
            </div>
        </form>
    </div>
</div>
<div class="card">
		<div id="pdfViewerArea">
            <div class="detail-placeholder">
                <span style="font-size: 1.2em;">첨부파일을 불러오는 중...</span>
                <p style="color: red; font-size: 0.1;">* PDF 파일만 미리보기가 지원됩니다.</p>
                <input type="hidden" id="pdfFileRefNo" value="${thesis.fileRefNo}">
                <input type="hidden" id="pdfMimeType" value="${thesis.atchFile.atchMime}">
            </div>
		</div>
	</div>

<div id="rejectModal" style="display:none; position:fixed; top:50%; left:50%; transform:translate(-50%, -50%); background:#fff; padding:20px; border:1px solid #ccc; z-index:1000; box-shadow: 0 4px 8px rgba(0,0,0,0.1);
             width: 500px; 
             max-width: 90%;"> 
    <h3>논문 반려 사유</h3>
    <textarea id="rejReasonInput" rows="10" cols="60" placeholder="반려 사유를 입력하세요." 
              style="width: 100%; margin-bottom: 10px; resize: vertical;"> 
    </textarea>
    <br>
    <div style="text-align: right;">
        <button type="button" id="confirmReject" class="editButton">확인</button>
        <button type="button" id="cancelReject" class="deleteButton" style="margin-left: 10px;">취소</button>
    </div>
</div>
<div id="modalBackdrop" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.5); z-index:999;"></div>

<script>
document.addEventListener("DOMContentLoaded", function() {
    const thesisNo = "${thesis.thesisNo}";
    const CPATH = "<c:url value="/pfcp"/>";

    document.querySelector(".cancelButton").addEventListener("click", function() {
        location.href = `${CPATH}/staff/thesis/thesisList.do`;
    });

    const approveButton = document.getElementById("approveButton");
    if (approveButton) {
        approveButton.addEventListener("click", function() {
            if (confirm("정말로 이 논문을 승인하시겠습니까?")) {
                const form = document.createElement('form');
                form.method = 'POST';
                form.action = `${CPATH}/staff/thesis/approveThesis.do`;
                
                let inputThesisNo = document.createElement('input');
                inputThesisNo.type = 'hidden';
                inputThesisNo.name = 'thesisNo';
                inputThesisNo.value = thesisNo;
                form.appendChild(inputThesisNo);
                
                document.body.appendChild(form);
                form.submit();
            }
        });
    }

    const rejectButton = document.getElementById("rejectButton");
    const rejectModal = document.getElementById("rejectModal");
    const modalBackdrop = document.getElementById("modalBackdrop");
    const rejReasonInput = document.getElementById("rejReasonInput");
    const confirmReject = document.getElementById("confirmReject");
    const cancelReject = document.getElementById("cancelReject");

    if (rejectButton) {
        rejectButton.addEventListener("click", function() {
            rejReasonInput.value = '';
            rejectModal.style.display = 'block';
            modalBackdrop.style.display = 'block';
        });

        cancelReject.addEventListener("click", function() {
            rejectModal.style.display = 'none';
            modalBackdrop.style.display = 'none';
        });

        confirmReject.addEventListener("click", function() {
            const rejReason = rejReasonInput.value.trim();
            if (rejReason === "") {
                alert("반려 사유를 입력해주세요.");
                return;
            }

            if (confirm("정말로 이 논문을 반려하고, 사유를 제출하시겠습니까?")) {
                const form = document.createElement('form');
                form.method = 'POST';
                form.action = `${CPATH}/staff/thesis/rejectThesis.do`;
                
                let inputThesisNo = document.createElement('input');
                inputThesisNo.type = 'hidden';
                inputThesisNo.name = 'thesisNo';
                inputThesisNo.value = thesisNo;
                form.appendChild(inputThesisNo);
                
                let inputRejReason = document.createElement('input');
                inputRejReason.type = 'hidden';
                inputRejReason.name = 'rejReason';
                inputRejReason.value = rejReason;
                form.appendChild(inputRejReason);
                
                document.body.appendChild(form);
                form.submit();
            }
        });
    }

    const flashMessage = "${message}";
    if (flashMessage && flashMessage !== "") {
        alert(flashMessage);
    }
});
</script>