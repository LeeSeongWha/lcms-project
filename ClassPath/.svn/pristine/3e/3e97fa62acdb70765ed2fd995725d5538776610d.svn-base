<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>수강신청</title>
<!-- LCMS 스타일 가이드 적용 -->
<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css" /> -->
<!-- <link rel="stylesheet" href="/dist/assets/css/original/enrollMain.css" /> -->
<link rel="stylesheet" href="/dist/assets/css/test/enrollMain2.css" />

<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function () {
	document.querySelectorAll('[data-tab]').forEach(tab => {
	  tab.addEventListener('click', function () {
	    const selected = this.dataset.tab;
	
	    // 탭 활성화 처리
	    document.querySelectorAll('.tab').forEach(btn => btn.classList.remove('active'));
	    this.classList.add('active');
	
	    // 콘텐츠 보이기 처리
	    document.querySelectorAll('[data-tab-content]').forEach(div => {
	      div.style.display = div.dataset.tabContent === selected ? 'block' : 'none';
	    });
	    
	  });
	  
	});
});

	

</script>
</head>
<body>
	<c:if test="${not empty scheduleNotice}">
		<div class="notice-banner">
			<strong>📢 수강신청 안내:</strong> ${scheduleNotice}
		</div>
	</c:if>
	
	<div class="enroll-body">
		<div class="container">
	<!-- 		<h1>수강신청 페이지</h1> -->
			<div class="tab-menu">
				<button data-tab="enroll" class="tab active">수강신청</button>
				<!-- <button data-tab="enrollEdit" class="tab">수강신청 내역</button> -->
				<button data-tab="timetable" class="tab">시간표</button>
				<button data-tab="cart" class="tab">예비신청</button>
			</div>
	
			<div class="tab-content" data-tab-content="enroll">
				<%-- ${lectureList } --%>
			
					<h3>신청 가능한 교과목</h3>
					<span>총 ${fn:length(lectureList)}개의 강의가 검색되었습니다.</span>
	
	
					<!-- 필터 토글 버튼 -->
					<div class="form-group" style="margin-bottom: 1rem;" >
						<button type="button" class="searchButton" onclick="toggleFilter()"
							id="toggleFilter">필터 열기</button>
					</div>
	
					<!-- 필터 적용 부분 -->
					<div id="filterSection" style="display: none;" class="card">
						<form method="get" action="/student/lecture/enroll.do"
							class="form-group mb-2">
							<div class="form-row">
								  <div class="form-group form-col">
								    <label for="keyword">강의명</label>
								    <input type="text" name="lecName" id="lecName" class="form-control"
								           placeholder="검색어를 입력하세요" value="${param.lecName}"/>
								  </div>
							</div>
							<div class="form-row">
								<div class="form-group form-col">
									<label for="departmentNo">학과</label> <select name="departmentNo"
										id="departmentNo" class="form-control">
										<option value="">전체</option>
										<c:forEach var="dept" items="${departmentList}">
											<option value="${dept.departmentNo}"
												${param.departmentNo == dept.departmentNo ? 'selected' : ''}>${dept.departmentName}</option>
										</c:forEach>
									</select>
								</div>
	
								<div class="form-group form-col">
									<label for="day">요일</label> <select name="day" id="day"
										class="form-control">
										<option value="">전체</option>
										<c:forEach var="day" items="${dayList}">
											<option value="${day}" ${param.day == day ? 'selected' : ''}>${day}</option>
										</c:forEach>
									</select>
								</div>
							</div>
	
							<div class="form-row">
								<div class="form-group form-col">
									<label for="period">교시</label> <select name="period" id="period"
										class="form-control">
										<option value="">전체</option>
										<c:forEach var="period" items="${periodList}">
											<option value="${period}"
												${param.period == period ? 'selected' : ''}>${period}</option>
										</c:forEach>
									</select>
								</div>
	
								<div class="form-group form-col">
									<label for="credit">학점</label> <select name="credit" id="credit"
										class="form-control">
										<option value="">전체</option>
										<c:forEach var="cr" items="${creditList}">
											<option value="${cr}" ${param.credit == cr ? 'selected' : ''}>${cr}</option>
										</c:forEach>
									</select>
								</div>
							</div>
	
							<!-- 버튼 그룹 -->
							<div class="form-group form-col">
								<div class="button-group">
									<a href="/student/lecture/enroll.do" class="cancelButton">초기화</a>
									<button type="submit" class="searchButton">검색</button>
								</div>
							</div>
						</form>
					</div>
					<!-- 수강목록 -->
	<!-- 			<div style="max-height: 450px; overflow-y: auto; border: 1px solid #ccc;"> -->
					<div>
	  					<table style="width: 100%; border-collapse: collapse;">
	   						 <thead style="position: sticky; top: 0; background: #f9f9f9; z-index: 1;">
								<tr style="text-align:center;">
									<th>번호</th>
									<th>과목명</th>
									<th>강의명</th>
									<th>교수명</th>
									<th>학점</th>
									<th>구분</th>
									<th>시간</th>
									<th>정원</th>
									<th>예비신청</th>
									<th>신청</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${lectureList != null }">
									<c:forEach var="lecture" items="${lectureList}" varStatus="status">
										<tr>
											<td>${status.index + 1}</td>
											<td>${lecture.subject.subjectName}</td>
											<td>${lecture.lectureReq.lecName }</td>
											<td>${lecture.user.userName}</td>
											<td>${lecture.subject.credit}</td>
											<td>${lecture.lectureReq.lecCategory } </td>
											<td>${lecture.lectureReq.preDay}-${lecture.lectureReq.preTime}</td>
											<td>${lecture.currentEnrollment}/${lecture.lectureReq.maxCapacity}</td>
											<td>
												<button type="submit" class="saveButton"
													onclick="applyPreLecture('${lecture.lecNo}')">
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus" viewBox="0 0 16 16">
  <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9z"/>
  <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1zm3.915 10L3.102 4h10.796l-1.313 7zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0m7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
</svg>
													담기
													</button>
											</td>
											<td>
												<%-- 신청 여부 확인 --%> <c:set var="isEnrolled" value="false" /> <c:forEach
													var="enr" items="${myEnrollments}">
													<c:if
														test="${enr.lecNo eq lecture.lecNo && enr.enrollStatus eq '수강중'}">
														<c:set var="isEnrolled" value="true" />
													</c:if>
												</c:forEach> <%-- 버튼 분기 처리 --%> <c:choose>
													<c:when test="${isEnrolled}">
														<button class="btn-disabled saveButton" disabled>신청됨</button>
													</c:when>
													<c:when
														test="${lecture.currentEnrollment >= lecture.lectureReq.maxCapacity}">
														<button class="btn-disabled deleteButton" disabled>마감</button>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${not isEnrollPeriod}">
																<button class="btn-disabled" disabled>신청불가</button>
															</c:when>
															<c:otherwise>
																<button class="btn-add"
																	onclick="applyLecture('${lecture.lecNo}')">신청</button>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
									</c:forEach>
								</c:if>
								
							</tbody>
						</table>
					</div>
					
					<br>
					<hr />
					<!--=========================================================  -->
					<h3>내 수강신청 목록</h3>
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>과목명</th>
								<th>강의명</th>
								<th>교수명</th>
								<th>요일</th>
								<th>시간</th>
								<th>신청일시</th>
								<th>취소</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${myEnrollList == null}">
								수강신청한 강의가 없습니다.
							</c:if>
							<c:forEach var="enroll" items="${myEnrollList}" varStatus="status">
								<tr class="${enroll.enrollStatus eq '취소' ? 'canceled' : ''}">
									<td>${status.index+1 }</td>
									<td>${enroll.subjectName }</td>
									<td>${enroll.lectureReq.lecName}</td>
									<td>${enroll.professorName}</td>
									<td>${enroll.preDay}</td>
									<td>${enroll.preTime}</td>
									<td>${enroll.enrollTime}</td>
									<td>
									  <c:choose>
									    <c:when test="${enroll.enrollStatus eq '수강중'}">
									      <c:choose>
									        <c:when test="${enroll.grade == null}">
									          <button onclick="cancelLecture('${enroll.lecNo}')" class="btn-add deleteButton">수강취소</button>
									        </c:when>
									        <c:otherwise>
									          <span style="color: gray;" class="canceled">취소불가</span>
									        </c:otherwise>
									      </c:choose>
									    </c:when>
									    <c:otherwise>
									      <span style="color: gray;" class="canceled">${enroll.enrollStatus}됨</span>
									    </c:otherwise>
									  </c:choose>
									</td>
	
								</tr>
							</c:forEach>
						</tbody>
					</table>
	
			
			</div>
	
			<%-- <div class="tab-content" data-tab-content="enrollEdit"
				style="display: none;">
				${myEnrollList}
				<table>
					<thead>
						<tr>
							<th>강의명</th>
							<th>교수명</th>
							<th>요일</th>
							<th>시간</th>
							<th>신청일시</th>
							<th>취소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="enroll" items="${myEnrollList}">
							<tr class="${enroll.enrollStatus eq '취소' ? 'canceled' : ''}">
								<td>${enroll.subjectName}</td>
								<td>${enroll.professorName}</td>
								<td>${enroll.preDay}</td>
								<td>${enroll.preTime}</td>
								<td>${enroll.enrollTime}</td>
								<td><c:choose>
										<c:when test="${enroll.enrollStatus eq '수강중'}">
											<button onclick="cancelLecture('${enroll.lecNo}')"
												class="btn-add deleteButton">수강취소</button>
										</c:when>
										<c:otherwise>
											<span style="color: gray;" class="canceled">${enroll.enrollStatus}됨</span>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div> --%>
	
	
			<div class="tab-content" data-tab-content="timetable"
				style="display: none;">
				<%-- ${myLectureEnrollments } --%>
	
				<c:set var="totalCredit" value="0" />
				<c:forEach var="lecture" items="${myLectureEnrollments}">
					<c:set var="totalCredit" value="${totalCredit + lecture.subject.credit}" />
				</c:forEach>
				<h3>시간표</h3>
				<div style="margin-bottom: 1rem; font-weight: bold;">🧮 총 학점:
					${totalCredit}학점
				</div>
				<table border="1" style="width: 100%; text-align: center;"
					class="timetable-table">
					<thead>
						<tr>
							<th>시간</th>
							<th>월</th>
							<th>화</th>
							<th>수</th>
							<th>목</th>
							<th>금</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="period" begin="1" end="9">
							<tr>
								<td>${period}교시</td>
								<c:forEach var="day" items="${['월','화','수','목','금']}">
									<td>
										<c:forEach var="lecture"
											items="${myLectureEnrollments}">
											<c:if test="${lecture.lectureReq != null}">
												<c:forEach var="d" items="${lecture.lectureReq.dayList}">
													<c:forEach var="p" items="${lecture.lectureReq.periodList}">
														<c:if test="${d eq day and p eq period}">
															<div style="font-weight: bold;">
																${lecture.lectureReq.lecName}<br /> <small>(${lecture.user.userName})</small>
															</div>
														</c:if>
													</c:forEach>
												</c:forEach>
											</c:if>
										</c:forEach>
									</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	
	
	
			<div class="tab-content" data-tab-content="cart"
				style="display: none;">
				<table class="tableFormat">
					<thead>
						<tr>
							<th>과목명</th>
							<th>교수명</th>
							<th>요일</th>
							<th>시간</th>
							<th>학점</th>
							<th>신청일</th>
							<th>관리</th>
	
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty cartList}">
								<c:forEach var="cart" items="${cartList}">
									<tr>
										<td>${cart.subjectName}</td>
										<td>${cart.professorName}</td>
										<td>${cart.preDay}</td>
										<td>${cart.preTime}</td>
										<td>${cart.credit}</td>
										<td>${cart.enrollTime}</td>
										<td>
											<button type="submit" class="deleteButton"
												onclick="cancelPreLecture('${cart.lecNo}')">삭제</button> <c:if
												test="${isEnrollPeriod}">
												<button type="submit" class="submitButton"
													onclick="applyLecture('${cart.lecNo}')">신청</button>
											</c:if>
	
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="8" class="centerText">예비 수강신청한 강의가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>	
		
	
	<script type="text/javascript">
	/*수강신청  */
	function applyLecture(lecNo) {
	    if (!confirm(lecNo + " 강의를 신청하시겠습니까?")) return;

	    fetch('/student/lecture/enroll.do/'+ encodeURIComponent(lecNo), {
	      method: 'POST',
	      credentials: 'include'
	    })
	    .then(res => {
	        if (res.status === 409) return res.text().then(msg => { throw new Error(msg); });
	        if (!res.ok) throw new Error('알 수 없는 오류');
	        return res.text();
	      })
	      .then(() => {
	        alert("신청 완료!");
	        location.reload();
	      })
	      .catch(err => {
	        alert(err.message); 
	      });
	    }
	
	/*수강취소 */
	function cancelLecture(lecNo) {
		  if (!confirm("이 강의를 수강취소 하시겠습니까?")) return;

		  fetch('/student/lecture/enroll.do/' + encodeURIComponent(lecNo), {
		    method: 'DELETE',
		    credentials: 'include'
		  })
		  .then(res => {
		    if (!res.ok) throw new Error("취소 실패");
		    return res.text();
		  })
		  .then(() => {
		    alert("수강취소 완료!");
		    location.reload();
		  })
		  .catch(err => {
		    alert("❗ " + err.message);
		  });
		}
	function applyPreLecture(lecNo) {
		  fetch(`/student/lecture/enroll.do/cart/\${lecNo}`, {
		    method: 'POST'
		  })
		  .then(res => {
		    if (res.ok) {
		      alert('장바구니에 추가되었습니다.');
		      location.reload();
		    } else if (res.status === 409) {
		      res.text().then(msg => alert('❗ ' + msg));
		    } else {
		      alert('알 수 없는 오류가 발생했습니다.');
		    }
		  })
		  .catch(error => {
		    console.error('Error:', error);
		    alert('서버 통신 오류 발생');
		  });
		}
	function cancelPreLecture(lecNo) {
		if (!confirm("이 강의를 수강취소 하시겠습니까?")) return;
		fetch("/student/lecture/enroll.do/cart/" + encodeURIComponent(lecNo), {
			  method: 'DELETE'
		})
		.then(res => {
		    if (!res.ok) throw new Error("취소 실패");
		    return res.text();
		 })
		 .then(() => {
			alert("수강취소 완료!");
		 	location.reload();
		 })
		 .catch(err => {
		    alert("❗ " + err.message);
		 });
	}
	function toggleFilter() {
	    const filter = document.getElementById('filterSection');
	    const toggleBtn = document.getElementById("toggleFilter");
	    if (filter.style.display === 'none' || filter.style.display === '') {
	      filter.style.display = 'block';
	      toggleBtn.textContent = "필터 닫기";
	    } else {
	      filter.style.display = 'none';
	      toggleBtn.textContent = "필터 열기";
	    }
	  }

</script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const timetableTable = document.querySelector('.timetable-table');
        if (!timetableTable) return;

        // 과목명과 색상을 매핑할 객체
        const lectureColors = {};
        // 파스텔 톤 색상 팔레트 (원하는 색상으로 더 추가/변경 가능)
        const pastelColors = [
        	'#FFF0F5', // Lavender Blush (매우 연한 핑크)
            '#E0F2F7', // Very Light Blue (연한 하늘색)
            '#EEFFEE', // Honeydew (매우 연한 녹색)
            '#FFF5EE', // Seashell (연한 살구색)
            '#F5EEF8', // Very Light Purple (연한 보라색)
            '#FFF8E1', // Cream (매우 연한 오렌지/베이지)
            '#E0F5F8', // Light Cyan Blue (매우 연한 청록색)
            '#F0FFFF', // Azure (매우 연한 파랑)
            '#FDFDED', // Ivory (매우 연한 노랑)
            '#FFFFF0', // Light Yellow (매우 연한 노랑)
            '#FEF8F0', // Linen (아주 연한 베이지)
            '#E8F8E8', // Light Mint Green (매우 연한 민트)
            '#EAEFFF', // Light Periwinkle (매우 연한 파랑 보라)
            '#F8F8FF'  // Ghost White (매우 연한 회색빛 흰색)
        ];

        let colorIndex = 0; // 색상 팔레트 인덱스

        // 테이블의 모든 셀을 순회하며 배경색 적용
        timetableTable.querySelectorAll('tbody td').forEach(td => {
            const lectureNameDiv = td.querySelector('div[style="font-weight: bold;"]');

            if (lectureNameDiv) {
                // 과목명 추출
                const lectureName = lectureNameDiv.firstChild.nodeValue.trim(); // <br /> 태그 전의 텍스트 추출

                // 해당 과목명에 할당된 색상이 없으면 새로 할당
                if (!lectureColors[lectureName]) {
                    // 색상 팔레트의 끝에 도달하면 처음부터 다시 사용
                    lectureColors[lectureName] = pastelColors[colorIndex % pastelColors.length];
                    colorIndex++;
                }

                // 셀에 배경색 적용
                td.style.backgroundColor = lectureColors[lectureName];
                td.style.borderRadius = '5px'; // 셀 모서리 둥글게 (선택 사항)
                td.style.border = '1px solid ' + lectureColors[lectureName]; // 테두리도 같은 색으로 (선택 사항)
            }
        });
    });
</script>
</body>
</html>
