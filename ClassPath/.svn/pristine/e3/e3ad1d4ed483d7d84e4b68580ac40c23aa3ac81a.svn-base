<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">

<c:if test="${not empty success}">
	<script>
		alert("${success}");
	</script>
</c:if>

<h4 class="pageTitle">공지 상세 정보</h4>

<div class="detail-section">
	<input type="hidden" id="boardNo" value="${noticeDetail.boardNo}" /> <input
		type="hidden" id="userNo" value="${userNo}" /> <input type="hidden"
		id="writerNo" value="${noticeDetail.writerNo}" />

	<div class="titleContainer">
		<h2>${noticeDetail.boardTitle}</h2>

		<div class="metaInfo">
			<p>
				<strong>작성자:</strong> ${noticeDetail.user.userName}
			</p>
			<p>
				<strong>작성일:</strong> ${noticeDetail.updateDate}
			</p>
		</div>
	</div>

	<div>
		<strong>공지 내용:</strong>
		<div class="content-box">${noticeDetail.boardContent}</div>
	</div>

	<!-- 개선된 버튼 레이아웃 -->
	<div class="button-group">
		<!-- 목록 버튼은 왼쪽에 -->
		<div class="button-left">
			<a class="btn btn-list" href="/student/notice/noticeList.do">목록으로</a>
		</div>

		<!-- 수정/삭제 버튼은 오른쪽에 -->
		<div class="button-right">
			<c:if test="${userNo eq noticeDetail.writerNo}">
				<button type="button" class="btn btn-edit" onclick="goToEdit()">수정</button>
				<button type="button" class="btn btn-delete"
					onclick="confirmDelete()">삭제</button>
			</c:if>
		</div>
	</div>
</div>

<script>
	function goToEdit() {
		const boardNo = document.getElementById("boardNo").value;
		window.location.href = "/staff/notice/noticeUpdate.do?what=" + boardNo;
	}

	function confirmDelete() {
		const boardNo = document.getElementById("boardNo").value;
		if (confirm("정말로 삭제하시겠습니까?")) {
			window.location.href = "/staff/notice/noticeDelete.do?what="
					+ boardNo;
		}
	}
</script>

<style>
.titleContainer {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	width: 100%;
	margin-bottom: 20px;
}

.titleContainer h2 {
	margin: 0;
	font-size: 24px;
}

.metaInfo {
	text-align: right;
}

.metaInfo p {
	margin: 0 0 4px;
	color: #444;
}

.detail-section {
	margin-top: 30px;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 8px;
	background-color: #f9f9f9;
}

.detail-section h2 {
	font-size: 24px;
	margin-bottom: 10px;
}

.detail-section p {
	margin-bottom: 8px;
	color: #444;
}

.content-box {
	margin-top: 10px;
	white-space: pre-wrap;
	background: #fff;
	padding: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 15px;
	line-height: 1.6;
	min-height: 400px;
}

/* 개선된 Button Group 레이아웃 */
.button-group {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-top: 20px;
	padding-top: 20px;
	border-top: 1px solid #eee;
}

.button-left {
	display: flex;
	gap: 10px;
}

.button-right {
	display: flex;
	gap: 10px;
}

/* General Button Styles */
.btn {
	padding: 12px 24px;
	border: none;
	border-radius: 6px;
	font-size: 14px;
	font-weight: 500;
	cursor: pointer;
	text-decoration: none;
	display: inline-flex;
	align-items: center;
	justify-content: center;
	transition: all 0.2s ease;
	width: 100px;
	height: 34px;
	text-align: center;
	box-sizing: border-box;
}

/* 목록 버튼 스타일 */
.btn-list {
	background-color: #95a5a6;
	color: #fff;
}

.btn-list:hover {
	background-color: #7f8c8d;
	transform: translateY(-1px);
	box-shadow: 0 4px 8px rgba(149, 165, 166, 0.3);
}

/* 수정 버튼 스타일 */
.btn-edit {
	background-color: #3498db;
	color: #fff;
}

.btn-edit:hover {
	background-color: #2980b9;
	transform: translateY(-1px);
	box-shadow: 0 4px 8px rgba(52, 152, 219, 0.3);
}

/* 삭제 버튼 스타일 */
.btn-delete {
	background-color: #e74c3c;
	color: #fff;
}

.btn-delete:hover {
	background-color: #c0392b;
	transform: translateY(-1px);
	box-shadow: 0 4px 8px rgba(231, 76, 60, 0.3);
}

/* 반응형 디자인 */
@media ( max-width : 768px) {
	.button-group {
		flex-direction: column;
		gap: 15px;
		align-items: stretch;
	}
	.button-left, .button-right {
		justify-content: center;
	}
	.btn {
		width: 120px;
		height: 44px;
	}
}
</style>