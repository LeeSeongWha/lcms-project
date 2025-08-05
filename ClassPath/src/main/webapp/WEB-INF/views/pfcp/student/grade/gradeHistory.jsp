<%--
 * == 개정이력(Modification Information) ==
 * 수정일	수정자	수정내용
 * ========================================
 * 250705	서경덕	최초 생성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<title>성적 조회</title>
<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> -->
<link rel="stylesheet" href="/dist/assets/css/test/gradeHistory2.css">

<script src="/js/app/pfcp/student/studentGrade.js"></script>

<div>
	<div class="form-row" style="display: flex; gap: 1.25rem;">
    	<div class="form-group" style="flex: 1;">
			<label for="pHaknyeondo" class="inputLabel">년도</label> 
			<input type="number" id="pHaknyeondo" class="inputField" value="2025">
		</div>

    	<div class="form-group" style="flex: 1;">
			<label for="pHakgi" class="inputLabel">학기</label>
			<select id="pHakgi" name="pHakgi" class="selectBox" data-init-val="2학기">
			</select>
		</div>
		<div class="form-group" style="display:flex; flex: 1;">
			<label class="inputLabel">전체 조회</label>
			<input type="checkbox" class="checkbox" name="allTimeYn" id="allTimeYn" true-value="Y" false-value="N" style="margin-top:10px;"> 
<!-- 		<label>전체 성적</label> -->
		</div>
<!-- 	<div class="form-group" style="width:200px;"> -->
		<div style="width:200px; display: flex; justify-content: flex-end; height:65px; margin-top:30px;">
			<button class="submitButton" id="submitButton">검색</button>
		</div>
	</div>
</div>

<br>

<!-- <div class="tableContainer"> -->
	<div id="pointAvg">
	</div>
	
	<table class="defaultTable">
		<thead class="tableHead">
			<tr>
				<th class="tableTh">학기</th>
				<th class="tableTh">강의</th>
				<th class="tableTh">이수구분</th>				
				<th class="tableTh">학점</th>
				<th class="tableTh">등급</th>
				<th class="tableTh">평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lectureEnrList }" var="lectureEnr">
				<tr>
					<td class="tableTd">${lectureEnr.semesterName }</td>
					<td class="tableTd">${lectureEnr.lectureReq.lecName }</td>
					<td class="tableTd">${lectureEnr.lectureReq.lecCategory }</td>
					<td class="tableTd">${lectureEnr.credit }</td>
					<td class="tableTd">${lectureEnr.grade }</td>
					<td class="tableTd">${lectureEnr.gradePoint }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<!-- </div> -->