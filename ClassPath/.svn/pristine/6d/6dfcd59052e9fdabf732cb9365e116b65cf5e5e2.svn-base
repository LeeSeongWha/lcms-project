<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<title>비교과 프로그램</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css" />

<form enctype="multipart/form-data" method="post" action="/student/program/programApplInsert.do">
	<input type="hidden" name="no" value="${program.programNo}">
	<div class="tableContainer">
		<table class="defaultTable">
			<tbody>
				<tr>
					<th class="tableTh">프로그램 종류</th>
					<td class="tableTd">${program.type.typeName }</td>
					<th class="tableTh">운영부서</th>
					<td class="tableTd">취업지원팀</td>
				</tr>
				<tr>
					<th class="tableTh">참여대상</th>
					<td class="tableTd">재학생</td>
					<th class="tableTh">담당자</th>
					<td class="tableTd">${program.user.userName }</td>
				</tr>
				<tr>
					<th class="tableTh">모집기간</th>
					<td class="tableTd">${program.applyStartDate }~
						${program.applyEndDate }</td>
					<th class="tableTh">모집인원</th>
					<td class="tableTd">${program.programCapacity }</td>
				</tr>
				<tr>
					<th class="tableTh">실시기간</th>
					<td class="tableTd">${program.startDate }~ ${program.endDate }</td>
				</tr>
				<tr>
					<th class="tableTh">프로그램명</th>
					<td class="tableTd">${program.programTitle }</td>
					<th class="tableTh">장소</th>
					<td class="tableTd">${program.place }</td>
				</tr>
				<tr>
					<th class="tableTh">내용</th>
					<td class="tableTd">${program.programDesp }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="notice-box" style="margin-top: 20px; padding: 15px; background-color: #f9f9f9; border-left: 4px solid #fee500; border-radius: 8px;">
		<p style="font-weight: bold; margin-bottom: 10px;">📌 신청 전 유의사항</p>
		<ul style="list-style: disc; padding-left: 20px; line-height: 1.6;">
			<li>프로그램 신청은 선착순으로 진행되며, 정원이 초과되면 신청이 자동 마감됩니다.</li>
			<li>신청 후 무단 불참 시, 추후 프로그램 참여에 제한이 있을 수 있습니다.</li>
			<li>부득이하게 취소할 경우, 반드시 모집 마감일 이전에 담당자에게 취소 요청을 해주세요.</li>
			<li>프로그램 참여 완료 시, 여러가지 혜택이 지급될 수 있습니다.</li>
		</ul>
	</div>
	<br>
	<div class="btn-area">
		<button type="button" class="cancelButton" onclick="history.back()">목록으로</button>
		<button type="submit" class="submitButton">신청하기</button>
	</div>
</form>