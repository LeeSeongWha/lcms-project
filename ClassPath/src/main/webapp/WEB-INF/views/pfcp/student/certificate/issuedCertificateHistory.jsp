<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<title>Insert title here</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/attendclass.css">

<div class="section">
	<h4>증명서 발급</h4>
	
	<div class="lecture-list-container">
		<c:forEach items="${certificateList }" var="certificate">
				<a href="/student/certificate/${certificate.certCode}.do" class="lecture-item-link">
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
								<span class="lecture-name">${certificate.certName }</span>
								<p class="lecture-details">
									・ ${certificate.certName } 신청하기 <br>
								</p>
							</div>
						</div>
					</div>
				</a>
		</c:forEach>
	</div>
	
<!-- 	<div class="lecture-list-container"> -->
<!-- 		<a href="/student/certificate/programList.do" class="lecture-item-link"> -->
<!-- 			<div class="lecture-item-content"> -->
<!-- 				<div class="lecture-info-group"> -->
<!-- 					<div class="lecture-icon-wrapper"> -->
<!-- 						<svg xmlns="http://www.w3.org/2000/svg" class="lecture-icon" -->
<!-- 							fill="none" viewBox="0 0 24 24" stroke="currentColor"> -->
<!-- 							<path stroke-linecap="round" stroke-linejoin="round" -->
<!-- 								stroke-width="2" d="M9 5l7 7-7 7" /> -->
<!-- 						</svg> -->
<!-- 					</div> -->
<!-- 					<div> -->
<!-- 						<span class="lecture-name">수료 증명서</span> -->
<!-- 						<p class="lecture-details"> -->
<!-- 							・ 수료 증명서 신청하기 <br> -->
<!-- 						</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</a> -->
		
<!-- 		<a href="" class="lecture-item-link"> -->
<!-- 			<div class="lecture-item-content"> -->
<!-- 				<div class="lecture-info-group"> -->
<!-- 					<div class="lecture-icon-wrapper"> -->
<!-- 						<svg xmlns="http://www.w3.org/2000/svg" class="lecture-icon" -->
<!-- 							fill="none" viewBox="0 0 24 24" stroke="currentColor"> -->
<!-- 							<path stroke-linecap="round" stroke-linejoin="round" -->
<!-- 								stroke-width="2" d="M9 5l7 7-7 7" /> -->
<!-- 						</svg> -->
<!-- 					</div> -->
<!-- 					<div> -->
<!-- 						<span class="lecture-name">재학 증명서</span> -->
<!-- 						<p class="lecture-details"> -->
<!-- 							・ 재학 증명서 신청하기 <br> -->
<!-- 						</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</a> -->
<!-- 	</div> -->
</div>