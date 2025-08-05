<%--  
	파일명 : departmentInsert.jsp
	프로그램명 : 학과 등록
	설명 : 
	작성자 : 김규민
	작성일 : 2025. 07. 09
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="/dist/assets/css/staff/collegeInsert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<main class="main-content">
	<section class="section career-section">
		<div class="card">
			<div class="card-header">
				<h1>학과 등록</h1>
			</div>
			
			<div class="card-content">
			<form action="<c:url value="${empty department.departmentNo ? '/staff/college/insertDepartment.do' : '/staff/college/departmentModify.do'}" />" method="post">

				<div class="form-group">
					<label for="departmentName">학과 :</label> 
					<input type="text"
						id="departmentName" name="departmentName" class="form-control" required
						value="${department.departmentName }">
				</div>

				<div class="form-group">
					<label for="departmentTuition">등록금 :</label> 
					<input type="text"
						id="departmentTuition" name="departmentTuition" class="form-control" required
						value="${department.departmentTuition}">
				</div>

				<div class="form-group">
					<label for="collegeSelect">단과 대학 :</label> 
					<select
						id="collegeSelect" name="collegeNo" class="form-control" required></select>
				</div>

				<div class="form-group">
					<label for="departmentDesc">학과 정보 :</label> 
					<input type="text"
						id="departmentDesc" name="departmentDesc" class="form-control" required
						value="${department.departmentDesc}">
				</div>
			</div>
		
			
				<div class="card-header">
					<h1>졸업 요건</h1>
				</div>
				
			<div class="card-content">
				<div class="form-group">
					<label for="dgrGrade">졸업 요구 학점 :</label> 
					<input type="text"
						id="dgrGrade" name="dgrReqVO.dgrGrade" class="form-control" required
						value="${department.dgrGrade}">
				</div>

				<div class="form-group">
					<label for="dgrMc">전공 학점 :</label> 
					<input type="text" id="dgrMc"
						name="dgrReqVO.dgrMc" class="form-control" required value="${department.dgrMc}">
				</div>

				<div class="form-group">
					<label for="dgrLac">교양 학점 :</label> 
					<input type="text" id="dgrLac"
						name="dgrReqVO.dgrLac" class="form-control" required value="${department.dgrLac}">
				</div>

				<div class="form-group">
					<label for="dgrFcc">자유이수 학점 :</label> 
					<input type="text"
						id="dgrFcc" name="dgrReqVO.dgrFcc" class="form-control" required
						value="${department.dgrFcc}">
				</div>

				<div class="form-group">
					<label for="dgrVolunteerHour">봉사 시간 :</label> 
					<input type="text"
						id="dgrVolunteerHour" name="dgrReqVO.dgrVolunteerHour" class="form-control" required
						value="${department.dgrVolunteerHour}">
				</div>
				<div class="button-group">
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="button" class="btn btn-secondary" onclick="location.href='/staff/college/collegeList.do'">
						단과목록
					</button>
				</div>
			</div>
		</div>
			

			</form>
			</div>
		</div>
	</section>
</main>

<script type="text/javascript">
$(function(){
	let collegeSelect = $("#collegeSelect");
	
	$.ajax({
		url : "/staff/college/selectCollege",
		type : "get",
		success : function(res){
			let html = ``;
			if(res != null){
				res.map(function(v,i){
					html += `
						<option value="\${v.collegeNo}">\${v.collegeName}</option>
					`; 
				});
				collegeSelect.html(html);
			}
		},
		error : function(){
			
		}
	});
});
</script>










