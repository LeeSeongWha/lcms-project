<%--  
	파일명 : collegeList.jsp  
	프로그램명 : 단과 대학 목록 조회
	설명 : 
	작성자 : 김규민
	작성일 : 2025. 07. 02
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<title>단과 대학 목록</title>
<%-- 기존 external CSS 링크 유지 --%>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/attendclass.css">
<div class="sectionHeaderLine">
  	<!-- 왼쪽 제목 및 설명 -->
	<div>
		<div class="sectionHeaderTitle">단과대학</div>
	</div>

	<!-- 오른쪽 등록 버튼 -->
	<a href="/staff/college/collegeInsert.do" class="submitButton" style="float:right">+ 등록</a>
</div>

<div class="section">
	<div class="lecture-list-container">
		<c:set var="displayedCount" value="0" />
		<c:choose>
			<c:when test="${not empty college }">
				<c:forEach items="${college }" var="college" varStatus="status">
						<c:url value="/professor/exam/examDetail.do" var="detailURL">
							<c:param name="examNo" value="${college.collegeNo }"/>
						</c:url>
						<a href="/staff/college/departmentList.do?collegeNo=${college.collegeNo}" class="lecture-item-link">
							<div class="lecture-item-content">
								<div class="lecture-info-group">
									<div class="lecture-icon-wrapper">
										<svg xmlns="http://www.w3.org/2000/svg" class="lecture-icon"
											fill="none" viewBox="0 0 24 24" stroke="currentColor">
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2" d="M9 5l7 7-7 7" />
										</svg>
									</div>
									<div>
										<span class="lecture-name">${college.collegeName}</span>
										<p class="lecture-details">
											・ 코드: ${college.collegeNo } <br>
											・ 학과 수: ${college.department.dcount} <br>
											
											
										</p>
									</div>
								</div>
							</div>
						</a>
						<c:set var="displayedCount" value="${displayedCount + 1}" />
				</c:forEach>
			</c:when>
		</c:choose>
		
		<c:if test="${displayedCount == 0}">
			<div class="no-lecture-message">
				등록된 단과 대학이 존재하지 않습니다.
			</div>
		</c:if>
	</div>
</div>
    
    <script>
    function confirmDeleteNotice(button) { 
        // 클릭한 버튼에서 data-collegeno 추출
        const collegeNo = button.closest('tr').getAttribute('data-collegeno');
        
        // 확인창 띄우기
        const isConfirmed = confirm("정말로 이 단과대학을 삭제하시겠습니까?");
        if (isConfirmed) {
            // 삭제 처리
            window.location.href = "/staff/college/collegeDelete.do?collegeNo=" + collegeNo;
        }
    }
    
	</script>
</body>



