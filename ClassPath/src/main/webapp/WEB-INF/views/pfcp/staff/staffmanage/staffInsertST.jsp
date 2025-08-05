<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">

<title>조교 등록</title>

<c:if test="${not empty success}">
  <script>
    alert("${success}");
  </script>
</c:if>

<c:if test="${not empty errorMessage}">
  <script>
    alert("${errorMessage}");
  </script>
</c:if>

<%-- 다음 우편번호 API 스크립트는 외부 라이브러리이므로 그대로 둡니다. --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<%-- 직접 작성한 스크립트는 이 파일로 관리합니다. --%>
<script src="<c:url value='/js/app/pfcp/staff/staffInsertForm.js'/>"></script>
<script src="<c:url value='/js/app/pfcp/staff/studentStaffInsertForm.js'/>"></script>

<form action="/staff/staffmanage/studentStaffInsertProcess.do" method="post" style="display:contents;"> 

	<h4 class="pageTitle">조교 등록</h4>
	<input type="hidden" name="no" value="${staff.user.userNo}" />

	<div class="tableContainer">
		<table class="defaultTable">
			<tbody>
				<tr class="tableRowHover">
					<th class="tableTh">사번</th>
					<td class="tableTd" style="display: flex; justify-content: space-between; align-items: center;">
					    <input class="inputField" type="text" name="user.userNo" required style="width: calc(100% - 70px); margin-right: 10px;"/>
					    <button type="button" class="editButton" onclick="checkStu()">확인</button>
					</td>
					<th class="tableTh">이름</th>
					<td class="tableTd">
						<input class="inputField" type="text" name="user.userName" readonly required/>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div style="margin-top:20px;">
		<button type="submit" class="submitButton" style="float: right;">저장</button>
		<button type="button" class="cancelButton" onclick="moveToList()" style="float: right; margin-right: 20px;">목록으로</button>
	</div>
</form>