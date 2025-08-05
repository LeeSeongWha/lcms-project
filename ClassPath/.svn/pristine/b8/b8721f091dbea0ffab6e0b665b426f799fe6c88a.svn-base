<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%--  
	파일명 : studentList.jsp  
	프로그램명 : 학생 전체 조회 화면  
	설명 : 학과별로 학생을 조회할 수 있음. (검색 가능)  
	작성자 : 양 수 민  
	작성일 : 2025. 07. 01  
--%>

<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> -->
<link rel="stylesheet" href="/dist/assets/css/test/studentList2.css">

<title>학생 목록 조회</title>

<c:if test="${not empty success}">
  <script>
    alert("${success}");
  </script>
</c:if>
<!-- ======================================== -->
<div class="studentList">
	<div>
	<!-- ======================================== -->
		<div class="sectionHeaderLine">
		  <!-- 왼쪽 제목 및 설명 -->
		  <div>
		    <div class="sectionHeaderTitle">학생 관리</div>
		    <div class="sectionHeaderDescription">전체 ${count}명의 학생</div>
		  </div>
		
		  <!-- 오른쪽 등록 버튼 -->
		  <button type="button" onclick="moveToRegisterPg()" class="submitButton">+ 등록</button>
		</div>
		<!-- ======================================== -->
		
		<form method="get" action="/staff/studentmanage/studentList.do" style="margin-bottom: 1rem;">
			<select name="searchType">
				<option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
				<option value="userNo" ${searchType == 'userNo' ? 'selected' : ''}>학번</option>
				<option value="userName" ${searchType == 'userName' ? 'selected' : ''}>학생명</option>
				<option value="departmentName" ${searchType == 'departmentName' ? 'selected' : ''}>학과</option>
				<option value="studentGrade" ${searchType == 'studentGrade' ? 'selected' : ''}>학년</option>
				<option value="stuStatus" ${searchType == 'stuStatus' ? 'selected' : ''}>재학 상태</option>
			</select>
			<input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="검색어 입력" />
			<button type="submit" class="submitButton">검색</button>
		</form>
		
		
		<div class="tableContainer">
		  <table class="defaultTable">
		    <thead class="tableHead">
		      <tr>
		        <th class="tableTh">번호</th>
		        <th class="tableTh">학번</th>
		        <th class="tableTh">이름</th>
		        <th class="tableTh">학과</th>
		        <th class="tableTh">학년</th>
		        <th class="tableTh">재학 상태</th>
		        <th class="tableTh">전화번호</th>
		        <th class="tableTh">메일</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:choose>
		        <c:when test="${not empty student }">
		          <c:forEach items="${student }" var="student" varStatus="status">
							<tr class="tableRowHover" onclick="moveToDetail(this)" data-user-no="${student.userNo }">
								<td class="tableTd">${status.index+1}</td>
								<td class="tableTd">${student.userNo }</td>
								<td class="tableTd">${student.user.userName }</td>
								<td class="tableTd">${student.department.departmentName }</td>
								<td class="tableTd">${student.studentGrade }</td>
								<td class="tableTd">${student.stuStatus }</td>
								<td class="tableTd">${student.user.userTel }</td>
								<td class="tableTd" style="text-align:left; width:20%;">${student.user.userEmail }</td>
							 </tr>
		          </c:forEach>
		        </c:when>
		
		        <c:otherwise>
		          <tr>
		            <td colspan="7" class="tableTd noticeInfo">아직 학생 없음.</td>
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
</div>	


<script>
	function moveToDetail(row) {
		const userNo = row.getAttribute("data-user-no");
		window.location.href = "/staff/studentmanage/studentDetail.do?what=" + userNo;
	}

	function moveToRegisterPg(){
		window.location.href="/staff/studentmanage/studentInsert.do";
	}
</script>