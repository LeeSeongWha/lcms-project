<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- <link rel="stylesheet" href="/dist/assets/css/staff/requestCollection.css"> -->
<link rel="stylesheet" href="/dist/assets/css/staff/graduateApply2.css">
<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> -->
<title>졸업 요건 현황</title>

<c:if test="${not empty success}">
	<script>
		alert("${success}");
	</script>
</c:if>


<div class="graduateApply">
	<!-- =================== 헤더 영역 =================== -->
	<div class="sectionHeaderLine">
		<div>
			<div class="sectionHeaderTitle">졸업 신청 현황</div>
			<div class="sectionHeaderDescription">전체 ${count}명의 학생</div>
		</div>
	</div>
	
	<!-- =================== 검색 영역 =================== -->
	<div class="card">
	<!-- 검색 및 필터 -->
		<form method="get" action="/staff/applyGrd/graduateApply.do" style="margin-bottom: 1rem;">
			<!-- 졸업 가능 여부 -->
			<div class="form-row">
				<div class="form-group" style="display:flex;">
					<select class="selectBox" name="eligible"> 
						<option value="" ${empty eligible ? 'selected' : ''}>졸업 가능 여부</option>
						<option value="Y" ${eligible == 'Y' ? 'selected' : ''}>가능</option>
						<option value="N" ${eligible == 'N' ? 'selected' : ''}>불가</option>
					</select>
				</div>
				<div class="form-group">
					<select class="selectBox" name="searchType">
						<option value="all" ${searchType == 'all' ? 'selected' : ''}>검색 항목</option>
						<option value="userNo" ${searchType == 'userNo' ? 'selected' : ''}>학번</option>
						<option value="userName" ${searchType == 'userName' ? 'selected' : ''}>이름</option>
					</select>
				</div>
				<div class="form-group">
					<input type="text" class="inputField" name="keyword" value="${keyword}" placeholder="검색어 입력" />
				</div>
				<div class="form-group" >
					<button class="searchButton" type="submit">
<!-- 	                    <i class="fas fa-search"></i> 검색 -->
	                    검색
	                </button>
				</div>
			</div>
		</form>
	</div>
	
	
	<!-- =================== 테이블 영역 =================== -->
	
	<!-- 졸업 요건 목록 카드 -->
	<div class="card">
		<!-- 헤더 영역 -->
		<div class="sectionHeaderLine">
			<div>
				<h2 class="sectionHeaderTitle">
					<i class="fas fa-graduation-cap"></i> 졸업 요건 현황
				</h2>
				<p class="sectionHeaderDescription">학생들의 졸업 이수 현황을 확인할 수 있습니다.</p>
	
				<c:if test="${eligible eq 'Y'}">
					<form id="bulkApplyForm" method="post"
						action="/staff/applyGrd/bulkApply.do">
						<input type="hidden" name="searchType" value="${searchType}" /> <input
							type="hidden" name="keyword" value="${keyword}" /> <input
							type="hidden" name="eligible" value="${eligible}" />
						<button type="submit" class="submitButton">일괄처리</button>
					</form>
				</c:if>
			</div>
		</div>
	
	
		<!-- 테이블 영역 -->
		<div class="tableContainer" id="gradListArea">
			<table class="defaultTable">
				<thead class="tableHead">
					<tr>
						<th class="tableTh">번호</th>
						<th class="tableTh">학번</th>
						<th class="tableTh">이름</th>
						<th class="tableTh">학과</th>
						<th class="tableTh">총 이수 학점</th>
						<th class="tableTh">전공 이수</th>
						<th class="tableTh">교양 이수</th>
						<th class="tableTh">졸업 가능</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty grdList}">
							<c:forEach items="${grdList}" var="grd" varStatus="status">
								<tr>
									<td class="tableTd">${paging.firstRecordIndex + status.index}</td>
									<td class="tableTd">${grd.userNo}</td>
									<td class="tableTd">${grd.userName}</td>
									<td class="tableTd">${grd.departmentNo}</td>
									<td class="tableTd">${grd.totalCredit}</td>
									<td class="tableTd">${grd.majorCredit}</td>
									<td class="tableTd">${grd.generalCredit}</td>
									<td class="tableTd"><c:choose>
											<c:when test="${grd.graduationEligible eq 'Y'}">
												<span class="badge badgeGreen">가능</span>
											</c:when>
											<c:otherwise>
												<span class="badge badgeRed">불가</span>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="8" class="tableTd noticeInfo">조회된 졸업요건 정보가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- =================== 페이징 영역 =================== -->
	<div class="pagination">
		<!-- 이전 블록: 현재 시작 페이지가 1보다 클 때만 출력 -->
		<c:if test="${paging.firstPageNoOnPageList > 1}">
			<a
				href="?page=${paging.firstPageNoOnPageList - paging.pageSize}&searchType=${searchType}&keyword=${keyword}"
				class="pageButton">이전</a>
		</c:if>
	
		<!-- 숫자 버튼: 최대 총 페이지 수를 넘지 않도록 제한 -->
		<c:forEach var="i" begin="${paging.firstPageNoOnPageList}"
			end="${paging.totalPageCount < paging.lastPageNoOnPageList ? paging.totalPageCount : paging.lastPageNoOnPageList}">
			<c:choose>
				<c:when test="${i == paging.currentPageNo}">
					<strong class="pageButton active">${i}</strong>
				</c:when>
				<c:otherwise>
					<a href="?page=${i}&searchType=${searchType}&keyword=${keyword}"
						class="pageButton">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<!-- 다음 블록: 현재 마지막 페이지가 총 페이지보다 작을 때만 출력 -->
		<c:if test="${paging.lastPageNoOnPageList < paging.totalPageCount}">
			<a
				href="?page=${paging.firstPageNoOnPageList + paging.pageSize}&searchType=${searchType}&keyword=${keyword}"
				class="pageButton">다음</a>
		</c:if>
	</div>
</div>	
	
