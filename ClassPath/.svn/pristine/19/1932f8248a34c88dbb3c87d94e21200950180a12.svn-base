<%--  
	파일명 : curriculumInsert.jsp  
	프로그램명 : 커리큘럼 등록
	설명 : 
	작성자 : 김규민
	작성일 : 2025. 07. 11
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/dist/assets/css/staff/collegeInsert.css">

    <main class="main-content">
        <section class="section career-section">
        <div class="card">
			<div class="card-header">
				<h1>커리큘럼 등록</h1>
			</div>
			
			<div class="card-content">
			<form id="" action="/staff/college/insertCurriculum.do" method="post">
			<input type="hidden" name="departmentNo" value="${departmentNo}">

			<!-- select ajax -->
			<!-- 
			<div>
            	<label for="collegeSelect">단과 대학 :</label>
            	<select id="collegeSelect" name="collegeNo" required></select>
        	</div> 
        	-->

			<div class="form-group">
				<label for="subjectCode">과목명 :</label> 
				<select id="subjectCode" name="subjectName" class="form-control" required>
					<option value="">선택하세요</option>
				</select>
			</div>

			<div class="form-group">
				<label for="reqCode">필수여부 :</label> 
				<select id="reqCode" name="reqCode" class="form-control" required>
					<option value="REQ_MANDATORY">필수</option>
					<option value="REQ_SELECTIVE">선택</option>
				</select>
			</div>

					<div class="button-group">
						<button type="submit" class="btn btn-primary">등록</button>
						<button type="button" class="btn btn-secondary" onclick="history.back()">
							돌아가기
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</section>
</main>

<script type="text/javascript">
	$(function() {
		let subjectCode = $("#subjectCode");

		$.ajax({
			url : "/staff/college/selectSubject",
			type : "get",
			success : function(res) {
				let html = ``;
				if (res != null) {
					res.map(function(v, i) {
						html += `<option value="\${v.subjectCode}">\${v.subjectName}</option>`;
					});
					subjectCode.html(html);
				}
			},
			error : function() {

			}
		});
	});
</script>