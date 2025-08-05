<%-- 
 * == 개정이력(Modification Information) ==
 * 수정일      수정자   수정내용
 * ========================================
 * 2025-07-17   양수민   최초 생성 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>증명서 목록</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/staff/certificationList2.css">

<div class="certificationFormList">
	<div class="sectionHeaderLine">
	    <div>
	        <div class="sectionHeaderTitle">증명서 목록</div>
	        <div class="sectionHeaderDescription">전체 ${totalCount}개의 증명서</div>
	    </div>
	</div>
	
	<c:if test="${not empty successMessage}">
	    <script>
	        alert("${successMessage}");
	    </script>
	</c:if>
	
	<div class="lecture-list-container-flex">
	    <div class="lecture-list-left">
	        <c:set var="displayedCount" value="0" />
	        <c:choose>
	            <c:when test="${not empty certificationList}">
	                <c:forEach items="${certificationList}" var="certification" varStatus="status">
	                    <div class="college-item-card lecture-item-link"
	                         data-cert-code="${certification.certCode}"
	                         data-file-ref-no="${certification.fileRefNo}">
	                         <input value="${certification.fileRefNo}" hidden>
	                        <div class="lecture-info-group">
	                            <div>
	                                <span class="lecture-name">${certification.certName} <button onclick="isActiveToN(this)" class="editButton" style="padding:3px;">비활성화</button></span>
	                                <p class="lecture-details">・ 증명서 번호: ${certification.certCode}</p>
	                                <p class="lecture-details">・ ${certification.certDesc}</p>
	                                <p class="lecture-details">・ 발급 수수료: ${certification.issueFee}</p>
	                            </div>
	                        </div>
	                    </div>
	                    <c:set var="displayedCount" value="${displayedCount + 1}" />
	                </c:forEach>
	            </c:when>
	        </c:choose>
	
	        <div class="college-item-card add-college-card" onclick="openModal()" style="height:140px">
	            <div class="lecture-info-group">
	                <div class="lecture-icon-wrapper">
	                    <svg xmlns="http://www.w3.org/2000/svg" class="lecture-icon"
	                         fill="none" viewBox="0 0 24 24" stroke="currentColor">
	                        <path stroke-linecap="round" stroke-linejoin="round"
	                              stroke-width="2.5" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
	                    </svg>
	                </div>
	            </div>
	        </div>
	
	        <c:if test="${displayedCount == 0}">
	            <div class="no-lecture-message">증명서 목록이 존재하지 않습니다.</div>
	        </c:if>
	    </div>
	
	    <div class="lecture-details-right card">
	        <div id="certificationPdfArea">
	            <div class="detail-placeholder">증명서를 선택하면 증명서PDF 예시가 여기에 표시됩니다.</div>
	        </div>
	    </div>
	</div>
	
	<!-- 등록 모달창 -->
	<div id="registerModal" class="modal" style="display:none;">
	  <div class="modal-content">
	    <span class="close" onclick="closeModal()" style="text-align:right">&times;</span>
	    <h3 style="text-align:center">증명서 등록</h3>
	    <form method="post" enctype="multipart/form-data" action="/staff/certification/staffCertificationInsertProcess.do">
	      <div class="form-group">
	        <label class="inputLabel">증명서명</label>
	        <input type="text" name="certName" class="inputField" required>
	      </div>
	      <div class="form-group">
	        <label class="inputLabel">설명</label>
	        <input type="text" name="certDesc" class="inputField" required>
	      </div>
				<div class="form-group">
					<label class="inputLabel">발급 수수료</label>
					<div class="radioBox" style="display: flex">
						<input class="radioButton" type="radio" id="none_option" name="issueFee" value="">
						<label class="inputLabel"for="none_option" style="margin-right: 10px;">없음</label>
						<input class="radioButton" type="radio" id="two_thousand_won_option" name="issueFee" value="2000">
						<label class="inputLabel" for="two_thousand_won_option">2,000원</label>
					</div>
				</div>
	
				<div class="form-group">
	        <label class="inputLabel">파일</label>
	        <input type="file" name="uploadFile" class="form-control">
	      </div>
	      <div style="text-align: right; margin-top: 1rem;">
	        <button type="submit" class="submitButton">저장</button>
	      </div>
	    </form>
	  </div>
	</div>
</div>

<script>

function isActiveToN(button) {
    if (confirm("정말 비활성화하시겠습니까?")) {
        const certCode = $(button).closest(".college-item-card").data("cert-code");
        window.location.href = "/staff/certification/certificationActiveToNProcess.do?certCode=" + certCode;
    }
}


function openModal() {
    document.getElementById('registerModal').style.display = 'block';
  }

  function closeModal() {
    document.getElementById('registerModal').style.display = 'none';
  }
  
  window.onclick = function(event) {
    const modal = document.getElementById('registerModal');
    if (event.target === modal) {
      closeModal();
    }
  }


let isEditMode = false;
let currentCertCode = "";
let currentFileRefNo = "";

function toggleEditMode() {
    isEditMode = true;
    document.getElementById("uploadFile").style.display = "block";
    document.getElementById("editButton").style.display = "none";
    document.getElementById("submitButton").style.display = "inline-block";
    document.getElementById("cancelButton").style.display = "inline-block";
}


function cancel() {
    isEditMode = false;
    document.getElementById("uploadFile").style.display = "none";
    document.getElementById("editButton").style.display = "inline-block";
    document.getElementById("submitButton").style.display = "none";
    document.getElementById("cancelButton").style.display = "none";
}

function filesubmit() {
    const file = $("#uploadFile")[0].files[0];
    const fileRefNo = $("file-ref-no"); 
    if (!file) {
        alert("업로드할 파일을 선택해주세요!");
        return;
    }

    const formData = new FormData();
    formData.append("uploadFile", file);
    formData.append("certCode", currentCertCode);
    
    console.log("uploadFile", file);
    console.log("certCode", currentCertCode);
    console.log("fileRefNo", fileRefNo);

    $.ajax({
        url: "/staff/certification/certificationFormInsertProcess.do",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function () {
            alert("파일이 성공적으로 저장되었습니다.");
            location.reload();
        },
        error: function () {
            alert("파일 저장 중 오류가 발생했습니다.");
        }
    });

    cancel();
}

$(document).ready(function () {
    $(".college-item-card").on("click", function () {
        const certCode = $(this).data("cert-code");
        const fileRefNo = $(this).data("file-ref-no");

        console.log("=== PDF 로딩 시작 ===");
        console.log("클릭한 certCode:", certCode);
        console.log("클릭한 fileRefNo:", fileRefNo);

//         if (!certCode) {
//             alert("증명서 코드가 없습니다.");
//             return;
//         }
        
        if (certCode === "add-new") return;

        currentCertCode = certCode;
        currentFileRefNo = fileRefNo;

        $(".college-item-card").removeClass("active");
        $(this).addClass("active");

        isEditMode = false;
        $("#certificationPdfArea").html('<div class="detail-placeholder">PDF를 불러오는 중...</div>');

        // PDF URL 생성
        let pdfUrl = '/staff/certification/serveCertificationFormPdf.do?certCode=' + encodeURIComponent(certCode);
        console.log("요청 URL:", pdfUrl);

        // AJAX로 PDF 요청
        $.ajax({
            url: pdfUrl,
            type: 'GET',
            xhrFields: { 
                responseType: 'blob' 
            },
            beforeSend: function() {
                console.log("PDF 요청 전송 중...");
            },
         // AJAX success 함수 내부에서 사용할 대안 방법
            success: function (blob, textStatus, xhr) {
                console.log("=== 동적 iframe 생성 방법 ===");
                
                // Blob URL 생성
                const pdfObjectUrl = URL.createObjectURL(blob);
                console.log("생성된 Blob URL:", pdfObjectUrl);
                
                // 먼저 기본 HTML 구조 생성 (iframe 제외)
                const baseHtml = 
                    '<div class="sectionHeaderLine">' +
                        '<div>' +
                            '<div class="sectionHeaderTitle">증명서 PDF 폼</div>' +
                        '</div>' +
                        '<div style="float:right;">' +
	                        '<button id="editButton" class="editButton" style="float:right;" onclick="toggleEditMode()">수정</button>' +
	                        '<button id="submitButton" class="submitButton" style="display:none; margin-right:1rem;" onclick="filesubmit()">저장</button>' +
	                        '<button id="cancelButton" class="cancelButton" style="display:none;" onclick="cancel()">취소</button>' +
                        '</div>' +
                    '</div>' +
                    '<input type="file" id="uploadFile" name="uploadFile" class="form-control" accept=".pdf" style="display:none; margin: 15px 0;">' +
                    '<div class="pdf-container" id="pdfContainer">' +
                        '<div id="pdfPlaceholder">PDF를 로드하는 중...</div>' +
                    '</div>';
                
                $("#certificationPdfArea").html(baseHtml);
                
                // iframe을 JavaScript로 동적 생성
                setTimeout(function() {
                    const iframe = document.createElement('iframe');
                    iframe.id = 'pdfViewer';
                    iframe.src = pdfObjectUrl;
                    iframe.width = '100%';
                    iframe.height = '800px';
                    iframe.frameBorder = '0';
                    iframe.style.border = 'none';
                    
                    console.log("동적 생성된 iframe src:", iframe.src);
                    
                    // 로드 이벤트 리스너 추가
                    iframe.onload = function() {
                        console.log("동적 iframe 로드 완료");
                        document.getElementById('pdfPlaceholder').style.display = 'none';
                    };
                    
                    iframe.onerror = function() {
                        console.error("동적 iframe 로드 오류");
                        document.getElementById('pdfPlaceholder').innerHTML = 'PDF 로드 실패';
                    };
                    
                    // DOM에 추가
                    const container = document.getElementById('pdfContainer');
                    container.appendChild(iframe);
                    
                    console.log("iframe이 DOM에 추가됨");
                }, 100);
            },
            error: function (xhr, status, error) {
                console.log("=== AJAX 오류 ===");
                console.error("상태:", xhr.status);
                console.error("상태 텍스트:", xhr.statusText);
                console.error("오류:", error);
                console.error("응답 텍스트:", xhr.responseText);
                
                // 응답이 JSON인지 확인
                try {
                    var errorResponse = JSON.parse(xhr.responseText);
                    console.error("서버 오류 메시지:", errorResponse.error);
                    showErrorMessage("서버 오류: " + errorResponse.error);
                } catch (e) {
                    showErrorMessage('파일을 불러오는 데 실패했습니다. (상태: ' + xhr.status + ')');
                }
            }
        });
    });

    // 오류 메시지 표시 함수
    function showErrorMessage(message) {
        console.log("오류 메시지 표시:", message);
        var errorHtml = 
            '<div class="sectionHeaderLine">' +
                '<div>' +
                    '<div class="sectionHeaderTitle">증명서 PDF 폼</div>' +
                '</div>' +
                '<div style="float:right;">' +
	                '<button id="editButton" class="editButton" style="float:right;" onclick="toggleEditMode()">수정</button>' +
	                '<button id="submitButton" class="submitButton" style="display:none; margin-right:1rem;" onclick="filesubmit()">저장</button>' +
	                '<button id="cancelButton" class="cancelButton" style="display:none;" onclick="cancel()">취소</button>' +
                '</div>' +
            '</div>' +
            '<input type="file" id="uploadFile" name="uploadFile" class="form-control" accept=".pdf" style="display:none; margin: 15px 0;">' +
            '<div class="error-container" style="text-align: center; padding: 20px;">' +
                '<img src="/dist/assets/errorImg/fileLoadFail.png" alt="파일 로드 실패" class="error-image" style="max-width: 200px; margin-bottom: 20px;">' +
                '<div class="error-message" style="font-size: 16px; color: #666; margin-bottom: 20px;">' + message + '</div>' +
                '<button onclick="location.reload()" class="retry-button" style="padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">다시 시도</button>' +
            '</div>';
        $("#certificationPdfArea").html(errorHtml);
    }

    // 전역 함수로 showErrorMessage 노출
    window.showErrorMessage = showErrorMessage;
});
</script>

<style>
.error-message {
    margin-top: 20px;
    font-size: 1.2em;
    color: #333;
    text-align: center;
}
.error-image {
    display: block;
    margin: auto;
    max-width: 80%;
    border: 1px solid #ddd;
    box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
}
</style>

<style>
.modal {
  position: fixed;
  z-index: 1000;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0,0,0,0.4);
}

.modal-content {
  background-color: #fefefe;
  margin: 10% auto; 
  padding: 20px;
  border: 1px solid #888;
  width: 40%;
  border-radius: 8px;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
  cursor: pointer;
}

.close:hover,
.close:focus {
  color: black;
}
</style>
