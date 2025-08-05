<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%--
    파일명 : facilityList.jsp
    프로그렴명 : 시설 전체 조회 화면
    설 명 : 등록된 시설물 전체를 조회할 수 있음.
    작성자 : 양 수 민
    작성일 : 2025. 07. 01
--%>


<title>시설 관리</title>
<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> -->
<link rel="stylesheet" href="/dist/assets/css/test/facilityList2.css">

<div class="facilityList">

	<!-- ======================================== -->
	<div class="sectionHeaderLine">
		<!-- 왼쪽 제목 및 설명 -->
		<div>
			<div class="sectionHeaderTitle">시설 관리</div>
			<div class="sectionHeaderDescription">전체 ${count}개의 시설</div>
		</div>

		<!-- 오른쪽 등록 버튼 -->
		<button type="button" onclick="showAddFacilityPage()"
			class="submitButton">+ 등록</button>
	</div>
	<!-- ======================================== -->

	<!-- 시설 검색 -->
	<form method="get" action="/staff/facility/facilityList.do" style="margin-bottom: 1rem;">
		<select class="selectBox" id="statusFilter" name="facilityStatus" style="width:5%;">
            <option value="" ${empty facilityStatus ? 'selected' : ''}>처리상태</option>
            <option value="AVAILABLE" ${facilityStatus == 'AVAILABLE' ? 'selected' : ''}>사용가능</option>
            <option value="MAINTENANCE" ${facilityStatus == 'MAINTENANCE' ? 'selected' : ''}>점검중</option>
            <option value="UNAVAILABLE" ${facilityStatus == 'UNAVAILABLE' ? 'selected' : ''}>예약불가</option>
        </select>
		<select name="searchType">
			<option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
			<option value="facilityNo" ${searchType == 'facilityNo' ? 'selected' : ''}>시설번호</option>
			<option value="facilityName" ${searchType == 'facilityName' ? 'selected' : ''}>시설명</option>
			<option value="facilityType" ${searchType == 'facilityType' ? 'selected' : ''}>시설유형</option>
			<option value="location" ${searchType == 'location' ? 'selected' : ''}>위치</option>
		</select>
		<input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="검색어 입력" />
		<button type="submit" class="submitButton">검색</button>
	</form>




	<!-- 시설 목록 -->
	<div class="tableContainer overflow-x-auto">
		<table class="defaultTable">
			<thead class="tableHead">
				<tr>
					<!-- <th class="tableTh">시설 코드</th> -->
					<th class="tableTh text-left">번호</th>
					<th class="tableTh text-left">시설번호</th>
					<th class="tableTh text-left">시설명</th>
					<th class="tableTh text-left">시설 유형</th>
					<th class="tableTh text-left">위치</th>
					<th class="tableTh text-left">수용 인원</th>
					<th class="tableTh text-left">상태</th>
					<th class="tableTh text-left">시간표</th>
				</tr>
			</thead>
			<tbody id="facilityTableBody"
				class="bg-white divide-y divide-gray-100">
				<c:choose>
					<c:when test="${not empty facility }">
						<c:forEach items="${facility }" var="facility" varStatus="status">
							<c:url value="/staff/facility/facilityDetail.do" var="detailURL">
								<c:param name="what" value="${facility.facilityNo }" />
							</c:url>
							<tr class="tableRowHover tableRowStripe" style="cursor: pointer;"
								onclick="location.href='${detailURL}'">
								<!-- <td class="tableTd">${facility.facilityNo}</td> -->
								<td class="tableTd">${status.index+1 }</a></td>
								<td class="tableTd">${facility.facilityNo}</td>
								<td class="tableTd">${facility.facilityName}</td>
								<td class="tableTd">${facility.facilityType}</td>
								<td class="tableTd">${facility.location}</td>
								<td class="tableTd">${facility.facilityMp}</td>
								<td class="tableTd">
									<c:choose>
										<c:when test="${facility.facilityStatus eq 'AVAILABLE' }">
											사용가능
										</c:when>
										<c:when test="${facility.facilityStatus eq 'MAINTENANCE' }">
											점검중
										</c:when>
										<c:when test="${facility.facilityStatus eq 'UNAVAILABLE' }">
											예약불가
										</c:when>
										<c:otherwise>
											예약불가
										</c:otherwise>
									</c:choose>
								</td>
								<c:url value="/staff/reservationTimestamp/facility/facility.do"
									var="detailURL2">
									<c:param name="what" value="${facility.facilityNo }" />
								</c:url>
								<td class="tableTd"><a href="${detailURL2 }">🕰️</a></td>
							</tr>
						</c:forEach>
					</c:when>

					<c:otherwise>
						<tr>
							<td colspan="7" class="tableTd noticeInfo text-center">아직 시설
								없음.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
	<div class="pagination">
		<c:if test="${paging.currentPageNo > 10}">
			<a href="?page=${paging.firstPageNoOnPageList - paging.pageSize}&keyword=${keyword}" class="pageButton">이전</a>
		</c:if>
	
		<c:forEach var="i" begin="${paging.firstPageNoOnPageList}" end="${paging.lastPageNoOnPageList}">
			<c:choose>
				<c:when test="${i == paging.currentPageNo}">
					<strong class="pageButton active">${i}</strong>
				</c:when>
				<c:otherwise>
					<a href="?page=${i}&keyword=${keyword}" class="pageButton">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<c:if test="${paging.currentPageNo < paging.totalPageCount}">
			<a href="?page=${paging.firstPageNoOnPageList + paging.pageSize}&keyword=${keyword}" class="pageButton">다음</a>
		</c:if>
	</div>
</div>


<script>
	function searchFacilities() {
		const searchInput = document.getElementById('facilitySearchInput').value
				.toLowerCase();
		const tableRows = document.getElementById('facilityTableBody')
				.getElementsByTagName('tr');

		for (let i = 0; i < tableRows.length; i++) {
			const row = tableRows[i];
			const facilityName = row.cells[0] ? row.cells[0].textContent
					.toLowerCase() : '';
			const facilityType = row.cells[1] ? row.cells[1].textContent
					.toLowerCase() : '';

			if (facilityName.includes(searchInput)
					|| facilityType.includes(searchInput)) {
				row.style.display = '';
			} else {
				row.style.display = 'none';
			}
		}
	}

	document.getElementById('facilitySearchInput').addEventListener('keyup',
			function(event) {
				if (event.key === 'Enter') {
					searchFacilities();
				}
			});

	function showAddFacilityPage() {
// 		alert('새 시설 등록 페이지로 이동합니다.');
		window.location.href = '/staff/facility/facilityInsert.do';
	}
</script>



