<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<title>전공 변경</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">

<!-- ======================================== -->
<div class="sectionHeaderLine">
  	<!-- 왼쪽 제목 및 설명 -->
	<div>
		<div class="sectionHeaderTitle">전공 변경 신청 목록</div>
		<div class="sectionHeaderDescription">전체 ${count}개의 게시글</div>
	</div>

	<!-- 오른쪽 등록 버튼 -->
	<button type="button" class="submitButton" onclick="location.href='/student/counsel/majorChangeInsert.do'">+ 등록</button>
</div>
<!-- ======================================== -->
<div class="tableContainer">
	<table class="defaultTable">
		<thead class="tableHead">
			<tr>
				<th class="tableTh">번호</th>
				<th class="tableTh">신청일자</th>
				<th class="tableTh">내용</th>
				<th class="tableTh">처리 현황</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty majorChangeList }">
					<c:forEach items="${majorChangeList }" var="majorChangeList" varStatus="status">
						<c:url value="/student/counsel/majorChangeDetail.do" var="detailURL">
							<c:param name="no" value="${majorChangeList.requestNo }"/>
						</c:url>
						<tr onclick="location.href='${detailURL}'" class="tableRowHover">
							<td class="tableTd">${status.index+1 }</td>
							<td class="tableTd">${majorChangeList.requestDate }</td>
							<td class="tableTd">${majorChangeList.reason }</td>
							<td class="tableTd">${majorChangeList.status }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3" class="tableTd">아직 신청 없음</td>
					</tr>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
</div>
<div class="pagination">
	<c:if test="${paging.currentPageNo > 10}">
		<a href="?page=${paging.firstPageNoOnPageList - paging.pageSize}" class="pageButton">이전</a>
	</c:if>

	<c:forEach var="i" begin="${paging.firstPageNoOnPageList}" end="${paging.lastPageNoOnPageList}">
		<c:choose>
			<c:when test="${i == paging.currentPageNo}">
				<strong class="pageButton active">${i}</strong>
			</c:when>
			<c:otherwise>
				<a href="?page=${i}" class="pageButton">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.currentPageNo < paging.totalPageCount}">
		<a href="?page=${paging.firstPageNoOnPageList + paging.pageSize}" class="pageButton">다음</a>
	</c:if>
</div>