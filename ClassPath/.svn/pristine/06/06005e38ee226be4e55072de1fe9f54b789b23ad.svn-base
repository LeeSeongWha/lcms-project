<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/test/gradeList2.css">

<title>수업 목록 조회</title>


<div class="gradeList">
	<!-- ======================================== -->
	<div class="sectionHeaderLine">
	  <div>
	    <div class="sectionHeaderTitle">강의 목록</div>
	    <div class="sectionHeaderDescription">전체 ${count}개의 강의</div>
	  </div>
	</div>
	
	<form method="get" action="/staff/grademanage/gradeList.do" style="margin-bottom: 1rem;">
		<select name="searchType">
			<option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
			<option value="lecNo" ${searchType == 'lecNo' ? 'selected' : ''}>강의번호</option>
			<option value="lecName" ${searchType == 'lecName' ? 'selected' : ''}>강의명</option>
			<option value="userNo" ${searchType == 'userNo' ? 'selected' : ''}>교번</option>
			<option value="userName" ${searchType == '"userName"' ? 'selected' : ''}>교수명</option>
		</select>
		<input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="검색어 입력" />
		<button type="submit" class="submitButton">검색</button>
	</form>
	
	<div class="tableContainer">
	  <table class="defaultTable">
	    <thead class="tableHead">
	      <tr>
	        <th class="tableTh">번호</th>
	        <th class="tableTh">강의코드</th>
	        <th class="tableTh">강의명</th>
	        <th class="tableTh">강의분류</th>
	        <th class="tableTh">교수명</th>
	        <th class="tableTh">학년</th>
	        <th class="tableTh">요일</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:choose>
	        <c:when test="${not empty lecture }">
	          <c:forEach items="${lecture }" var="lecture">
						<tr class="tableRowHover" onclick="moveToDetail(this)" data-lecno="${lecture.lecNo}">
							<td class="tableTd">${lecture.rnum}</td>
							<td class="tableTd">${lecture.lecNo}</td>
							<td class="tableTd" style="text-align: left;">${lecture.lectureReq.lecName}</td>
	<%-- 						<td class="tableTd">${lecture.lectureReq.subjectCode}</td> --%>
	
							<c:choose>
								<c:when test="${lecture.lectureReq.lecCategory eq 'MJ_REQ'}">
									<td class="tableTd">전공필수</td>
								</c:when>
								<c:when test="${lecture.lectureReq.lecCategory eq 'MJ_SEL'}">
									<td class="tableTd">전공선택</td>
								</c:when>
								<c:when test="${lecture.lectureReq.lecCategory eq 'GE_REQ'}">
									<td class="tableTd">교양필수</td>
								</c:when>
								<c:when test="${lecture.lectureReq.lecCategory eq 'GE_SEL'}">
									<td class="tableTd">교양선택</td>
								</c:when>
								<c:otherwise>
									<td class="tableTd">기타</td>
								</c:otherwise>
							</c:choose>
	
	<%-- 						<td class="tableTd">${lecture.lectureReq.lecCategory }</td> --%>
							<td class="tableTd">${lecture.user.userName }</td>
							<td class="tableTd">${lecture.subject.gradeLevel }</td>
							<td class="tableTd">${lecture.lectureReq.preDay }</td>
	<%-- 						<td class="tableTd"><a href="${detailURL }">${student.user.userName }</a></td> --%>
	<%-- 						<td class="tableTd">${lecture.department.departmentName }</td> --%>
						 </tr>
	          </c:forEach>
	        </c:when>
	
	        <c:otherwise>
	          <tr>
	            <td colspan="7" class="tableTd noticeInfo">아직 개설된 강의 없음.</td>
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

<!-- <a href="/cert/student" target="_blank">재학 증명서 출력</a> -->

<script type="text/javascript">
	function moveToDetail(row) {
		const lecNo = row.getAttribute("data-lecno");
		window.location.href = "/staff/grademanage/gradeDetail.do?what=" + lecNo;
	}
</script>


