<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%--
    파일명 : facilityDetail.jsp
    프로그렘명 : 시설 상세 조회 화면
    설 명 : 등록된 시설물의 상세 정보를 조회하고 수정할 수 있음
    작성자 : 양 수 민
    작성일 : 2025. 07. 01
--%>

<title>시설 상세 정보</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/test/studentInsert2.css">

<c:if test="${not empty success}">
  <script>
    alert("${success}");
  </script>
</c:if>

<div class="studentInsert">
	<form method="post" action="/staff/facility/facilityUpdateProcess.do" style="display:contents;">
	<h1>시설 상세 정보</h1>
    <hr class="h1-hr">
	
		<!-- 숨겨진 필드로 시설번호 전달 -->
		<input type="hidden" name="facilityNo" value="${facility.facilityNo}" />
	
		<div class="tableContainer">	
	
			<table class="defaultTable">
				<tbody>
					<tr class="tableRowHover">
						<th class="tableTh">시설번호</th>
						<td class="tableTd">
							<input class="inputField" type="text" value="${facility.facilityNo}" readonly style="background-color: #f8f9fa;" />
						</td>
						<th class="tableTh">시설명</th>
						<td class="tableTd">
							<input class="inputField" type="text" id="facilityName" name="facilityName" value="${facility.facilityName}" required />
						</td>
					</tr>
					<tr class="tableRowHover">
						<th class="tableTh">시설 유형</th>
						<td class="tableTd">
							<select id="facilityType" name="facilityType" class="selectBox" required>
								<option value="">시설 유형 선택</option>
								<option value="강의실" <c:if test="${facility.facilityType == '강의실'}">selected</c:if>>강의실</option>
								<option value="실습실" <c:if test="${facility.facilityType == '실습실'}">selected</c:if>>실습실</option>
								<option value="체육관" <c:if test="${facility.facilityType == '체육관'}">selected</c:if>>체육관</option>
								<option value="회의실" <c:if test="${facility.facilityType == '회의실'}">selected</c:if>>회의실</option>
								<option value="세미나실" <c:if test="${facility.facilityType == '세미나실'}">selected</c:if>>세미나실</option>
								<option value="도서관" <c:if test="${facility.facilityType == '도서관'}">selected</c:if>>도서관</option>
								<option value="식당" <c:if test="${facility.facilityType == '식당'}">selected</c:if>>식당</option>
								<option value="기타" <c:if test="${facility.facilityType == '기타'}">selected</c:if>>기타</option>
							</select>
						</td>
						<th class="tableTh">위치</th>
						<td class="tableTd">
							<input type="text" id="location" name="location" class="inputField" value="${facility.location}" required />
						</td>
					</tr>
					<tr class="tableRowHover">
						<th class="tableTh">수용 인원</th>
						<td class="tableTd">
							<input type="number" id="facilityMp" name="facilityMp" class="inputField" value="${facility.facilityMp}" min="0" required />
						</td>
						<th class="tableTh">시설 상태</th>
						<td class="tableTd">
							<select id="facilityStatus" name="facilityStatus" class="selectBox" required>
								<option value="">상태 선택</option>
								<option value="AVAILABLE" <c:if test="${facility.facilityStatus == 'AVAILABLE'}">selected</c:if>>사용가능</option>
								<option value="MAINTENANCE" <c:if test="${facility.facilityStatus == 'MAINTENANCE'}">selected</c:if>>점검중</option>
								<option value="UNAVAILABLE" <c:if test="${facility.facilityStatus == 'UNAVAILABLE'}">selected</c:if>>예약불가</option>
							</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div style="margin-top:20px;" style="display:flex; justify-content:space-between">
			<button type="submit" class="submitButton" style="float: right;">저장</button>
			<button type="button" class="cancelButton" onclick="moveToList()">목록으로</button>
		</div>
		
	</form>
</div>

<script>
function moveToList(){
    window.location.href='/staff/facility/facilityList.do';
}
</script>