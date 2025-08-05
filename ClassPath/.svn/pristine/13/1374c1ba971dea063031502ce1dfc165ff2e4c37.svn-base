<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<%--  
	파일명 : collegeInsert.jsp  
	프로그램명 : 단과 대학 목록 등록
	설명 : 
	작성자 : 김규민
	작성일 : 2025. 07. 02
--%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>단과 대학 등록</title>
<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> -->
<link rel="stylesheet" href="/dist/assets/css/staff/collegeInsert.css">

</head>

<body>
	<main class="main-content">
        <section class="section career-section">
        <div class="card">
				<div class="card-header">
					<h1>단과 대학 등록</h1>
				</div>
    <div class="card-content">
    <form action="/staff/college/insertCollege.do" method="post">
        
        <div class="form-group">
            <label for="collegeName">단과 대학 이름 :</label>
            <input type="text" id="collegeName" name="collegeName" class="form-control" required>
        </div>
        
        <div class="button-group">
            <button type="submit" class="btn btn-primary">등록</button>
            <button type="button" class="btn btn-secondary" onclick="location.href='/staff/college/collegeList.do'">돌아가기</button>
        </div>
    </form>
    </div>
    	</div>
    	</section>
    </main>
</body>

</html>