<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/test/gradeDetail2.css">
<title>수업 수강 학생 조회</title>

<c:if test="${not empty msg}">
	<script>
    alert("${msg}");
  </script>
</c:if>

<div class="gradeDetail">
	<!-- ======================================== -->
	<form method="post" action="/staff/grademanage/gradeUpdateProcess.do" style="display:contents;">
	
		<div class="sectionHeaderLine">
		  <div>
		    <input value="${lectureStudent[0].lecture.lecNo}" name="lecNo" style="display:none;">
		    <div class="sectionHeaderTitle">[ ${lectureStudent[0].lectureReq.lecName} ] 수강 학생 목록</div>
		    <div class="sectionHeaderDescription">전체 ${totalCount}명의 학생</div>
		  </div>
		  
		  <button type="submit" class="submitButton">저장</button>
		</div>
		
		<div class="tableContainer">
		  <table class="defaultTable">
		    <thead class="tableHead">
		      <tr>
		        <th class="tableTh">번호</th>
		        <th class="tableTh">학과</th>
		        <th class="tableTh">학번</th>
		        <th class="tableTh">학생명</th>
		        <th class="tableTh">중간고사</th>
		        <th class="tableTh">기말고사</th>
		        <th class="tableTh">과제</th>
		        <th class="tableTh">출석</th>
		        <th class="tableTh">총점</th>
		        <th class="tableTh">등급</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:choose>
		        <c:when test="${not empty lectureStudent }">
		          <c:forEach items="${lectureStudent }" var="lectureStudent" varStatus="status">
					<tr class="tableRowHover" data-user-no="${lectureStudent.user.userNo}" data-enr-no="${enrNo}" data-lec-no="${lectureStudent.lecNo}">
						<td class="tableTd">${status.index+1}<input style="display:none;" name="userNoList[${vs.index}]" value="${lectureStudent.user.userNo}"></td>
						<td class="tableTd">${lectureStudent.department.departmentName }</td>
						<td class="tableTd">${lectureStudent.user.userNo}</td>
						<td class="tableTd">${lectureStudent.user.userName}</td>
						
						<td class="tableTd" style="width:15%;">
							<input class="inputField" name="midtermScoreList[${vs.index}]" value="${lectureStudent.midtermScore}" placeholder="채점 전입니다" style="text-align:center;" readonly>
						</td>
						<td class="tableTd" style="width:15%;">
							<input class="inputField" name="finalScoreList[${vs.index}]" value="${lectureStudent.finalScore}" placeholder="채점 전입니다" style="text-align:center" readonly>
						</td>
						<td class="tableTd" style="width:15%;">
	<%-- 					<label class="inputLabel">${lectureStudent.assignmentScore}</label> --%>
							<input class="inputField" name="assignmentScoreList[${vs.index}]" value="${lectureStudent.assignmentScore}" placeholder="채점 전입니다" style="text-align:center" readonly>
						</td>
						<td class="tableTd" style="width:7%;">
							<label class="inputLabel">${lectureStudent.attendanceScore}</label>
	<%-- 						<input class="inputField" name="" value="${lectureStudent.attendanceScore}" placeholder="자동으로 산출됩니다" style="text-align:center" readonly> --%>
						</td>
						<td class="tableTd" style="width:7%;">
							<label class="inputLabel">${lectureStudent.finalGrade}</label>
	<%-- 						<input class="inputField" name="" value="${lectureStudent.finalGrade}" placeholder="자동으로 산출됩니다" style="text-align:center" readonly> --%>
						</td>
						<td class="tableTd" style="width:7%;">
							<label class="inputLabel">${lectureStudent.finalGradeAlpha}</label>
	<%-- 						<input class="inputField" name="" value="${lectureStudent.finalGradeAlpha}" placeholder="자동으로 산출됩니다" style="text-align:center" readonly> --%>
						</td>
						
					 </tr>
		          </c:forEach>
		        </c:when>
		        <c:otherwise>
		          <tr>
		            <td colspan="10" class="tableTd noticeInfo">해당 강의를 수강하는 학생이 없음.</td>
		          </tr>
		        </c:otherwise>
		      </c:choose>
		      
		    </tbody>
		  </table>
		</div>
	
	</form>
</div>

<!-- <div class="pagination"> -->
<%-- 	<c:if test="${paging.currentPageNo > 10}"> --%>
<%-- 		<a href="?page=${paging.firstPageNoOnPageList - paging.pageSize}&keyword=${keyword}" class="pageButton">이전</a> --%>
<%-- 	</c:if> --%>

<%-- 	<c:forEach var="i" begin="${paging.firstPageNoOnPageList}" end="${paging.lastPageNoOnPageList}"> --%>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${i == paging.currentPageNo}"> --%>
<%-- 				<strong class="pageButton active">${i}</strong> --%>
<%-- 			</c:when> --%>
<%-- 			<c:otherwise> --%>
<%-- 				<a href="?page=${i}&keyword=${keyword}" class="pageButton">${i}</a> --%>
<%-- 			</c:otherwise> --%>
<%-- 		</c:choose> --%>
<%-- 	</c:forEach> --%>

<%-- 	<c:if test="${paging.currentPageNo < paging.totalPageCount}"> --%>
<%-- 		<a href="?page=${paging.firstPageNoOnPageList + paging.pageSize}&keyword=${keyword}" class="pageButton">다음</a> --%>
<%-- 	</c:if> --%>
<!-- </div> -->




