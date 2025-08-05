<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>비교과 프로그램 등록/수정</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<style type="text/css">
.error-text {
	color: red;
}
</style>
</head>
<body>

	<div class="container">
		<h2 class="pageTitle">
			<c:choose>
				<c:when test="${empty program.programNo}">비교과 프로그램 등록</c:when>
				<c:otherwise>비교과 프로그램 수정</c:otherwise>
			</c:choose>
		</h2>

		<form:form modelAttribute="program" method="post"
			action="${pageContext.request.contextPath}/staff/program/save"
			style="display:contents">

			<form:hidden path="programNo" />
			<form:hidden path="userNo" />

			<div class="form-row">
				<div class="form-group">
					<label class="inputLabel">프로그램명</label>
					<form:input path="programTitle" cssClass="inputField" />
					<form:errors path="programTitle" cssClass="error-text" />

				</div>
				<div class="form-group">
					<label class="inputLabel">유형</label>
					<form:select path="typeCode" cssClass="selectBox">
						<form:option value="">-- 선택 --</form:option>
						<form:options items="${typeList}" itemValue="typeCode"
							itemLabel="typeName" />
					</form:select>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group">
					<label class="inputLabel">정원</label>
					<form:input path="programCapacity" type="number"
						cssClass="inputField" />
					<form:errors path="programCapacity" cssClass="error-text" />
				</div>
				<div class="form-group">
					<label class="inputLabel">장소</label>
					<form:select path="place" cssClass="selectBox">
						<form:option value="">-- 선택 --</form:option>
						<form:options items="${facilityList}" itemValue="facilityNo"
							itemLabel="facilityName" />
					</form:select>
					<form:errors path="place" cssClass="error-text" />
				</div>

			</div>

			<div class="form-row">
				<div class="form-group">
					<label class="inputLabel">운영 시작일</label>
					<form:input path="startDate" type="date" cssClass="inputField" />
				</div>
				<div class="form-group">
					<label class="inputLabel">운영 종료일</label>
					<form:input path="endDate" type="date" cssClass="inputField" />
				</div>
			</div>

			<div class="form-row">
				<div class="form-group">
					<label class="inputLabel">사용 여부</label>
					<form:select path="programActive" cssClass="selectBox">
						<form:option value="Y">진행중</form:option>
						<form:option value="N">모집중</form:option>
						<form:option value="C">완료</form:option>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label class="inputLabel">프로그램 설명</label>
				<form:textarea path="programDesp" rows="5" cssClass="textareaField" />
				<form:errors path="programDesp" cssClass="error-text" />
			</div>

			<div class="button-group">
				
				<button class="cancelButton" type="button"
					onclick="location.href='${pageContext.request.contextPath}/staff/program/programList.do'">
					목록으로</button>
				<button type="submit" class="submitButton">저장</button>
    <button type="button" onclick="fillDummyData()" class="button">더미 데이터 자동 입력</button>
    <script>
    function fillDummyData() {
        // 프로그램명
        document.querySelector('[name="programTitle"]').value = "리더십 향상 워크숍";

        // 유형 (select)
        document.querySelector('[name="typeCode"]').value = document.querySelector('[name="typeCode"] option[value]').value || "";

        // 정원
        document.querySelector('[name="programCapacity"]').value = 30;

        // 장소 (select)
        document.querySelector('[name="place"]').value = document.querySelector('[name="place"] option[value]').value || "";

        // 운영 시작일 & 종료일
        document.querySelector('[name="startDate"]').value = "2025-09-10";
        document.querySelector('[name="endDate"]').value = "2025-09-12";

        // 사용 여부
        document.querySelector('[name="programActive"]').value = "Y";

        // 설명
        document.querySelector('[name="programDesp"]').value =
            "이 워크숍은 학생들의 리더십 역량 강화를 위한 2박 3일 집중 교육입니다.\n팀 프로젝트, 리더십 강의, 야외활동이 포함됩니다.";
    }
</script>
			</div>

		</form:form>
	</div>
	<c:if test="${not empty errorMessage}">
		<script>
			alert("${errorMessage}");
		</script>
	</c:if>
	<c:choose>
		<c:when test="${empty program.programNo}">
			<c:set var="formMode" value="insert" />
		</c:when>
		<c:otherwise>
			<c:set var="formMode" value="update" />
		</c:otherwise>
	</c:choose>
	<c:if test="${param.success eq '1'}">
		<script>
			alert("프로그램이 성공적으로 수정되었습니다.");
			if (window.history.replaceState) {
				const cleanUrl = window.location.protocol + "//"
						+ window.location.host + window.location.pathname;
				window.history.replaceState({}, document.title, cleanUrl);
			}
		</script>
	</c:if>
</body>
</html>
