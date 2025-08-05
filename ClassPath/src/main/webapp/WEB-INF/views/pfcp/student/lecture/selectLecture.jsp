<%--
 * == 개정이력(Modification Information) ==
 * 수정일	수정자	수정내용
 * ========================================
 * 250705	서경덕	최초 생성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<title>Insert title here</title>

<style>
	ul {
		list-style: none;
	}
	
	.myUl {
		list-style: none;
		display: grid;
		grid-template-columns: repeat(4, 1fr); /* 한 줄에 2개씩 */
		gap: 20px;
		padding: 0;
		margin: 0;
	}
	
	.myLi {
		background: #fff;
		border: 1px solid #ccc;
		border-radius: 8px;
		padding: 1rem;
		box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
		cursor:pointer;
	}
</style>

<div>
	<h4>강의 평가</h4>
	
	<ul class="myUl">
		<c:forEach items="${lectureList }" var="lecture">
		<c:url value="/student/lectureEvaluation.do" var="detailURL">
			<c:param name="enrollNo" value="${lecture.enrollNo }" />
		</c:url>
		<li class="myLi" onclick="location.href='${detailURL }'">	
			${lecture.lectureReq.lecName }
			<c:if test="${lecture.evalYn eq 'Y' }">
				(평가 완료)
			</c:if>
		</li>	
		</c:forEach>	
	</ul>
</div>