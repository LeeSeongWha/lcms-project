<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<title>Insert title here</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">

<div class="container">
	<form method="post" action="/student/program/completeEvaluation.do">
		<input type="hidden" name="programNo" value="${programNo}">
		<input type="hidden" name="no" value="${enrollNo }">
			<div class="form-section">
				<h2>프로그램 만족도 조사</h2>
				<div class="card">
					<c:forEach items="${evalList}" var="eval" varStatus="status">
					    <div class="form-group" style="flex: 1;">
							<div id="questionList">
								<div class="question-item">
									<label class="inputLabel">강의평가 ${status.count}.</label>
									<input class="inputField" type="hidden" name="criteriaNo_${status.count}" value="${eval.criteriaNo}"> 
									<input class="inputField" style="width:70%;" type="text" value="${eval.criteriaDesc}" readonly>
									<input type="radio" name="score_${status.count}" value="1">매우 불만족&nbsp&nbsp
									<input type="radio" name="score_${status.count}" value="2">불만족&nbsp&nbsp
									<input type="radio" name="score_${status.count}" value="3">보통&nbsp&nbsp
									<input type="radio" name="score_${status.count}" value="4">만족&nbsp&nbsp
									<input type="radio" name="score_${status.count}" value="5">매우 만족
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<label class="inputLabel">자유 의견</label>
				<textarea class="textareaField" name="comment" rows="" cols=""></textarea>
				<button type="submit" class="submitButton">등록</button>
			</div>
	</form>
</div>