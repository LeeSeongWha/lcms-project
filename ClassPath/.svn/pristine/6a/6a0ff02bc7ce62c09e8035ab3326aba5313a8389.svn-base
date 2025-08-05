/**
 * 
 */

document.addEventListener("DOMContentLoaded", () => {
	let initialPdfViewerAreaHtml = "";
	let currentPdfObjectUrl = null;

	function loadAndDisplayPdf() {
		const fileRefNo = $("#pdfFileRefNo").val();
		const mimeType = $("#pdfMimeType").val();


		if (currentPdfObjectUrl) {
			URL.revokeObjectURL(currentPdfObjectUrl);
			currentPdfObjectUrl = null;
		}

		if (mimeType !== 'application/pdf') {
			showErrorMessage("이 파일은 PDF 형식이 아닙니다. 다운로드하여 확인해주세요.");
			return;
		}

		if (!fileRefNo || fileRefNo === "null" || fileRefNo === "") {
			showErrorMessage("첨부된 파일이 없습니다.");
			return;
		}

		$("#pdfViewerArea").html('<div class="detail-placeholder">PDF를 불러오는 중...</div>');

		let pdfUrl = '/professor/lecture/fileDownload.do?fileRefNo=' + encodeURIComponent(fileRefNo);

		$.ajax({
			url: pdfUrl,
			type: 'GET',
			xhrFields: {
				responseType: 'blob'
			},
			beforeSend: function() {

			},
			success: function(blob, textStatus, xhr) {

				const newPdfObjectUrl = URL.createObjectURL(blob);
				currentPdfObjectUrl = newPdfObjectUrl;

				const pdfViewerHtml =
					'<div class="sectionHeaderLine">' +
					'<div>' +
					'<div class="sectionHeaderTitle">첨부파일 미리보기</div>' +
					'<span style="font-size: 1em; color: red;">* PDF 파일만 미리보기를 지원합니다.</span>' +
					'</div>' +
					'<div style="float:right;">' +
					'<button type="button" class="cancelButton" id="closePdfViewerBtn">X</button>' +
					'</div>' +
					'</div>' +
					'<div class="pdf-container" id="pdfContainer">' +
					'<div id="pdfPlaceholder">PDF를 로드하는 중...</div>' +
					'</div>';

				$("#pdfViewerArea").html(pdfViewerHtml);

				setTimeout(function() {
					const iframe = document.createElement('iframe');
					iframe.id = 'pdfViewerIframe';
					iframe.src = newPdfObjectUrl;
					iframe.width = '100%';
					iframe.height = '800px';
					iframe.frameBorder = '0';
					iframe.style.border = 'none';

					iframe.onload = function() {
						document.getElementById('pdfPlaceholder').style.display = 'none';
					};

					iframe.onerror = function() {
						document.getElementById('pdfPlaceholder').innerHTML = 'PDF 로드 실패';
						if (currentPdfObjectUrl) {
							URL.revokeObjectURL(currentPdfObjectUrl);
							currentPdfObjectUrl = null;
						}
					};

					const container = document.getElementById('pdfContainer');
					container.appendChild(iframe);

					$(document).on("click", "#closePdfViewerBtn", closePdfViewer);

				}, 100);
			},
			error: function(xhr, status, error) {

				try {
					var errorResponse = JSON.parse(xhr.responseText);
					showErrorMessage("서버 오류: " + errorResponse.error);
				} catch (e) {
					showErrorMessage('파일을 불러오는 데 실패했습니다. (상태: ' + xhr.status + ')');
				}
			}
		});
	}


	// 오류 메시지 표시 함수
	function showErrorMessage(message) {
		var errorHtml =
			'<div class="sectionHeaderLine">' +
			'<div>' +
			'<div class="sectionHeaderTitle">첨부파일 미리보기</div>' +
			'<span style="font-size: 1em; color: red;">* PDF 파일만 미리보기를 지원합니다.</span>' +
			'</div>' +
			'</div>' +
			'<div class="error-container" style="text-align: center; padding: 20px;">' +
			'<img src="/dist/assets/errorImg/fileLoadFail.png" alt="파일 로드 실패" class="error-image" style="max-width: 200px; margin-bottom: 20px;">' +
			'<div class="error-message" style="font-size: 16px; color: #666; margin-bottom: 20px;">' + message + '</div>' +
			'<button onclick="location.reload()" class="retry-button" style="padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">다시 시도</button>' +
			'</div>';
		$("#pdfViewerArea").html(errorHtml);

		$(document).on("click", "#closePdfViewerBtn", closePdfViewer);
	}
	function closePdfViewer() {
		if (currentPdfObjectUrl) {
			URL.revokeObjectURL(currentPdfObjectUrl);
			currentPdfObjectUrl = null;
		}
		$("#pdfViewerArea").html(initialPdfViewerAreaHtml);
	}

	$(document).ready(function() {
		initialPdfViewerAreaHtml = $("#pdfViewerArea").html();

		loadAndDisplayPdf();

		window.showErrorMessage = showErrorMessage;
		window.closePdfViewer = closePdfViewer;
		window.loadAndDisplayPdf = loadAndDisplayPdf;
	});
});