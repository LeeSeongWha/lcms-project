<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<title>비교과 프로그램</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css" />
<link rel="stylesheet" href="/dist/assets/css/attendclass.css">
<!-- <link rel="stylesheet" href="/dist/assets/css/staff/tuition.css"> -->

<style>
.myUl {
  list-style: none;
  padding: 0;
  margin: 0;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  gap: 1.25rem; /* 20px */
  font-family: var(--font-family);
  font-size: 1.25rem; /* 기본 글씨 크기 키움 */
  color: var(--secondary-color);
  background: var(--bg-tertiary);
}

/* 개별 카드 스타일 */
.myLi {
  background-color: var(--bg-primary);
  border: 1px solid var(--border-color);
  border-radius: 16px;
  box-shadow: var(--shadow-sm);
  padding: 1.25rem 1.5rem;
  cursor: pointer;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  min-height: 160px;
  font-size: 1.15rem; /* 카드 내 기본 텍스트 크기 */
}

.myLi:hover {
  transform: translateY(-4px);
  box-shadow: var(--shadow-md);
}

/* 제목 스타일 */
.myLi h3 {
  font-size: 1.6rem; /* 제목 글씨 크게 */
  margin: 0 0 1rem 0;
  color: var(--primary-color);
  font-weight: 700;
}

/* 날짜 및 정보 섹션 */
.myLi dl {
  display: flex;
  justify-content: space-between;
  margin: 0.25rem 0;
  font-size: 1rem; /* 날짜/정보 텍스트 크기 키움 */
  color: var(--gray-600);
}

.myLi dt {
  font-weight: 600;
  color: var(--gray-700);
}

.myLi dd {
  margin: 0;
  text-align: right;
}

/* 신청현황 강조 */
.myLi dd strong {
  color: var(--warning-color);
  font-weight: 700;
}
</style>


<h4 class="pageTitle">비교과 프로그램 관리</h4>

<div class="tab-content" data-tab-content="program" style="display: block;">
	<ul class="myUl">
		<c:forEach var="p" items="${programList}">
			<c:url value="/student/program/programApplDetail.do" var="detailURL">
				<c:param name="no" value="${p.programNo }" />
			</c:url>
			<li class="myLi" onclick="location.href='${detailURL }'">
				<div>
					<a href="#">
					</a>
				</div>
				<div>
					<h3>${p.programTitle}</h3>
				</div>
				<div>
					<dl>
						<dt>모집일자</dt>
						<dd>${p.applyStartDate } ~ ${p.applyEndDate }</dd>
					</dl>
					<dl>
						<dt>운영일자</dt>
						<dd>${p.startDate} ~ ${p.endDate}</dd>
					</dl>
					<dl>
						<dt>신청현황</dt>
						<dd>
							<strong>${p.enrollCount}</strong> / ${p.programCapacity }
						</dd>
					</dl>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>