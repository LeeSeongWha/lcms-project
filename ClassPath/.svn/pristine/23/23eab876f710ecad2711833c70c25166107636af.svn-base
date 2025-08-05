<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<title>Insert title here</title>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/attendclass.css">


<style>
.section {
  max-width: 1080px;
  margin: 40px auto;
  padding: 24px;
  background-color: #fefefe;
  border: 1px solid #e0e0e0;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  font-family: 'Noto Sans KR', 'Malgun Gothic', -apple-system, BlinkMacSystemFont, sans-serif;
  line-height: 1.6;
}

.section h5 {
  font-size: 1.8rem;
  font-weight: 700;
  margin-bottom: 24px;
  color: #2b6cb0;
  text-align: center;
}

/* 컨테이너 그리드 */
.lecture-list-container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  gap: 1.5rem;
}

/* 링크 카드 스타일 */
.lecture-item-link {
  display: block;
  background-color: #fff;
  border: 1px solid #e2e8f0;
  border-radius: 16px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.05);
  padding: 1.5rem 1.8rem;
  text-decoration: none;
  color: #4a5568;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
  min-height: 140px;
  display: flex;
  align-items: center;
}

.lecture-item-link:hover {
  transform: translateY(-4px);
  box-shadow: 0 1px 6px rgba(0,0,0,0.15);
  color: #2b6cb0;
}

/* 아이콘 + 텍스트 그룹 */
.lecture-item-content {
  display: flex;
  align-items: center;
  gap: 1rem;
  width: 100%;
}

/* 아이콘 감싸는 영역 */
.lecture-icon-wrapper {
  flex-shrink: 0;
  width: 36px;
  height: 36px;
  color: #2b6cb0;
}

/* SVG 아이콘 크기 */
.lecture-icon {
  width: 100%;
  height: 100%;
}

/* 텍스트 영역 */
.lecture-name {
  display: block;
  font-size: 1.3rem;
  font-weight: 700;
  margin-bottom: 6px;
  color: #2a5298;
}

.lecture-details {
  font-size: 1rem;
  color: #555;
  margin: 0;
  line-height: 1.3;
}
</style>



	<h4 class="pageTitle">내 비교과 프로그램</h4>
	<div class="lecture-list-container">
		<c:forEach items="${programList }" var="program">
			<c:url value="/student/program/myParticipationDetail.do" var="detailURL">
				<c:param name="no" value="${program.programNo }"/>
			</c:url>
			<a href="${detailURL}" class="lecture-item-link">
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
							<span class="lecture-name">${program.programTitle}</span>
							<p class="lecture-details">
								・ 설명: ${program.programDesp } <br>
							</p>
						</div>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
