<%--
 * == 개정이력(Modification Information) ==
 * 수정일			수정자	수정내용
 * ========================================
 * 2025-07-17  	양수민	최초 생성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<title>단과 대학 목록</title>
<%-- 기존 external CSS 링크 유지 --%>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<!-- <link rel="stylesheet" href="/dist/assets/css/staff/tuitionList.css"> -->
<link rel="stylesheet" href="/dist/assets/css/test/tuitionList2.css">


<div class="tuitionList">
	<!-- ======================================== -->
	<div class="sectionHeaderLine">
		<!-- 왼쪽 제목 및 설명 -->
		<div>
			<div class="sectionHeaderTitle">단과대학 목록</div>
			<div class="sectionHeaderDescription">전체 ${totalCount}개의 단과대학</div>
		</div>

		<!-- 오른쪽 등록 버튼 -->
<!-- 		<button type="button" class="submitButton">+ 등록</button> -->
	</div>
	<!-- ======================================== -->

	<div class="lecture-list-container-flex">
		<!-- 왼쪽: 카드 리스트 -->
		<div class="lecture-list-left">
			<c:set var="displayedCount" value="0" />
			<c:choose>
				<c:when test="${not empty collegeList}">
					<c:forEach items="${collegeList}" var="college" varStatus="status">
						<div class="college-item-card lecture-item-link" data-college-no="${college.collegeNo}">
							<div class="lecture-info-group">
								<div class="lecture-icon-wrapper">
									<svg xmlns="http://www.w3.org/2000/svg" class="lecture-icon"
										fill="none" viewBox="0 0 24 24" stroke="currentColor">
									<path stroke-linecap="round" stroke-linejoin="round"
											stroke-width="2" d="M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16m14 0h2m-2 0h-5m-9 0H3m2 0h5M9 7h1m-1 4h1m4-4h1m-1 4h1m-5 8h1m-1-4h1m4 4h1m-1-4h1" />
								</svg>
								</div>
								<div>
									<span class="lecture-name">${college.collegeName}</span>
									<p class="lecture-details">・ 단과대학 번호: ${college.collegeNo}</p>
									<p class="lecture-details">・ 운영 학과 수: ${college.department.dcount}</p>
								</div>
							</div>
						</div>
						<c:set var="displayedCount" value="${displayedCount + 1}" />
					</c:forEach>
				</c:when>
			</c:choose>

<!-- 단과대학 추가 시작 -->
<!--     <div class="college-item-card add-college-card" data-college-no="add-new"> -->
<!--         <div class="lecture-info-group"> -->
<!--             <div class="lecture-icon-wrapper"> -->
<!--                 <svg xmlns="http://www.w3.org/2000/svg" class="lecture-icon" -->
<!--                      fill="none" viewBox="0 0 24 24" stroke="currentColor"> -->
<!--                     <path stroke-linecap="round" stroke-linejoin="round" -->
<!--                           stroke-width="2.5" d="M12 6v6m0 0v6m0-6h6m-6 0H6" /> -->
<!--                 </svg> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
<!-- 단과대학 추가 끗 -->

			<c:if test="${displayedCount == 0}">
				<div class="no-lecture-message">단과대학 목록이 존재하지 않습니다.</div>
			</c:if>
		</div>
		

		<!-- 오른쪽: 세부 정보 출력 영역 -->
		<div  class="lecture-details-right card" >
			<div id="collegeDetailArea" >
				<div class="detail-placeholder">단과대학을 선택하면 학과와 등록금 정보가 여기에 표시됩니다.</div>
			</div>
			<div id="dgrReqArea"></div>
		</div>
	</div>
</div>




<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).on("click", ".lecture-item-link", function() {
    // 이전 선택 제거
    $(".college-item-card").removeClass("active");
    // 현재 선택 추가
    $(this).addClass("active");
    
    const collegeNo = $(this).data("college-no");

    $.ajax({
        type: "GET",
        url: "/staff/tuition/departmentList.do",
        data: { no: collegeNo },
        success: function(data) {
            console.log("서버에서 받은 데이터:", data);
            
            var html = '<div class="department-table-header">';
            html += '<h3 class="college-detail-header">학과별 등록금</h3>';
            html += '<button type="button" class="save-button" onclick="saveTuitionChanges()">저장</button>';
            html += '</div>';
            
            html += '<table class="department-table">';
            html += '<thead><tr><th>학과명</th><th>등록금</th></tr></thead><tbody>';
            
            $.each(data, function(index, dept) {
                console.log(index + "번째 항목:", dept);
                
                var dgrNo = dept.dgrNo || '졸업요건 번호 없음';
                var departmentName = dept.departmentName || '학과명 없음';
                var tuition = dept.tuition || '0';
                
                var dgrNo = dept.dgrNo;
                console.log("dgrNo : " , dgrNo);
                if (!dgrNo) {
                  console.warn("❗ dept 객체에 dgrNo 없음", dept);
                  return; // skip this row
                }
                
                console.log("추출된 값:", departmentName, tuition);
                
                html += "<tr style='cursor:pointer;' onclick='serveDepartmentDetail(\"" + dgrNo + "\")'>";
                html += '<td>' + departmentName + '</td>';
                html += '<td><input type="number" class="tuition-input" value="' + tuition + '" data-dgr-no="' + dgrNo + '" onclick="event.stopPropagation()"></td>';
                html += '</tr>';
            });
            
            html += '</tbody></table>';
            console.log("생성된 HTML:", html);
            $("#collegeDetailArea").html(html);
        },
        error: function() {
            $("#collegeDetailArea").html('<div class="error-message">정보를 불러오는 데 실패했습니다.</div>');
        }
    });
});


//현재 선택된 학과를 추적하는 변수
let currentSelectedDepartment = null;

$(document).on("click", ".lecture-item-link", function() {
    // 이전 선택 제거
    $(".college-item-card").removeClass("active");
    // 현재 선택 추가
    $(this).addClass("active");
    
    // 졸업 요건 영역 초기화 (다른 단과대학 클릭 시)
    $("#dgrReqArea").html("");
    currentSelectedDepartment = null;
    
    const collegeNo = $(this).data("college-no");

    $.ajax({
        type: "GET",
        url: "/staff/tuition/departmentList.do",
        data: { no: collegeNo },
        success: function(data) {
            console.log("서버에서 받은 데이터:", data);
            
            var html = '<div class="department-table-header">';
            html += '<h3 class="college-detail-header">학과별 등록금</h3>';
            html += '<button type="button" class="save-button" onclick="saveTuitionChanges()">저장</button>';
            html += '</div>';
            
            html += '<table class="department-table">';
            html += '<thead><tr><th>학과 코드</th><th>학과명</th><th>등록금</th></tr></thead><tbody>';
            
            $.each(data, function(index, dept) {
                console.log(index + "번째 항목:", dept);
                
                var departmentNo = dept.departmentNo || '졸업요건 번호 없음';
                var dgrNo = dept.dgrNo || '졸업요건 번호 없음';
                var departmentName = dept.departmentName || '학과명 없음';
                var tuition = dept.tuition || '0';
                
                var dgrNo = dept.dgrNo;
                console.log("dgrNo : " , dgrNo);
                if (!dgrNo) {
                  console.warn("❗ dept 객체에 dgrNo 없음", dept);
                  return; // skip this row
                }
                
                console.log("추출된 값:", departmentName, tuition);
                
                html += "<tr style='cursor:pointer;' >";
                html += '<td>' + departmentNo + '</td>';
                html += '<td>' + departmentName + '</td>';
                html += '<td><input type="number" class="tuition-input" value="' + tuition + '" data-dgr-no="' + dgrNo + '" onclick="event.stopPropagation()"></td>';
                html += '</tr>';
            });
            
            html += '</tbody></table>';
            console.log("생성된 HTML:", html);
            $("#collegeDetailArea").html(html);
        },
        error: function() {
            $("#collegeDetailArea").html('<div class="error-message">정보를 불러오는 데 실패했습니다.</div>');
        }
    });
});

function serveDepartmentDetail(dgrNo){
    console.log("✅ dgrNo 값 확인:", dgrNo);
    
    // 같은 학과를 다시 클릭한 경우 졸업 요건 영역을 비우고 리턴
    if (currentSelectedDepartment === dgrNo) {
        $("#dgrReqArea").html("");
        currentSelectedDepartment = null;
        
        // 학과 테이블의 active 상태도 제거
        $(".department-table tr").removeClass("selected-department");
        return;
    }
    
    // 이전 선택된 학과의 스타일 제거
    $(".department-table tr").removeClass("selected-department");
    
    // 현재 클릭된 학과에 스타일 추가
    event.target.closest('tr').classList.add('selected-department');
    
    // 현재 선택된 학과 업데이트
    currentSelectedDepartment = dgrNo;
    
    $.ajax({
        type: "GET",
        url: "/staff/tuition/tuitionDgrReq.do",
        data: { dgrNoData: dgrNo },
        success: function(data){
            console.log("서버에서 받은 데이터:", data);
            
            var html = '<div class="college-detail-header" style="margin-top:30px; max-witdh:400px;">졸업 요건</div>';
            html += '<table class="department-detail-table">';
            html += `<thead>
                        <tr>
                            <th>졸업 요건 번호</th>
                            <th>졸업 요구 학점</th>
                            <th>전공 학점</th>
                            <th>교양 학점</th>
                            <th>자유 이수 학점</th>
                            <th>봉사 시간</th>
                            <th>적용 대상</th>
                        </tr>
                    </thead>
                <tbody>`;
            
            $.each(data, function(index, dgrReq) {
                console.log(index + "번째 항목:", dgrReq);
                
                var dgrNo = dgrReq.dgrNo || '졸업 요건 번호 없음';
                var dgrGrade = dgrReq.dgrGrade || '졸업 요구 학점 정보 없음';
                var dgrMc = dgrReq.dgrMc || '전공 학점 정보 없음';
                var dgrLac = dgrReq.dgrLac || '교양 학점 정보 없음';
                var dgrFcc = dgrReq.dgrFcc || '자유 이수 학점 정보 없음';
                var dgrVolunteerHour = dgrReq.dgrVolunteerHour || '봉사 시간 정보 없음';
                var dgrDate = dgrReq.dgrDate || '적용 날짜 정보 없음';
                
                console.log("졸업 요건 번호:", dgrNo);
                console.log("졸업 요구 학점:", dgrGrade);
                console.log("전공 학점:", dgrMc);
                console.log("교양 학점:", dgrLac);
                console.log("자유 이수 학점:", dgrFcc);
                console.log("봉사 시간:", dgrVolunteerHour);
                console.log("적용 대상:", dgrDate);
                
                html += '<tr>';
                html += '<td>' + dgrNo + '</td>';
                html += '<td>' + dgrGrade + '</td>';
                html += '<td>' + dgrMc + '</td>';
                html += '<td>' + dgrLac + '</td>';
                html += '<td>' + dgrFcc + '</td>';
                html += '<td>' + dgrVolunteerHour + '</td>';
                html += '<td>' + dgrDate + ' 이후 입학생 </td>';
                html += '</tr>';
            });
            
            html += '</tbody></table>';
            console.log("생성된 HTML:", html);
            $("#dgrReqArea").html(html);
        },
        error: function() {
            $("#dgrReqArea").html('<div class="error-message">정보를 불러오는 데 실패했습니다.</div>');
        }
    });
}

// 등록금 변경사항 저장 함수
function saveTuitionChanges() {
    const saveButton = $('.save-button');
    const tuitionInputs = $('.tuition-input');
    
    // 저장 버튼 비활성화
    saveButton.prop('disabled', true).text('저장 중...');
    
    // 변경된 등록금 데이터 수집
    const tuitionData = [];
    tuitionInputs.each(function() {
        const input = $(this);
        const dgrNo = input.data('dgr-no');
        const departmentTuition = input.val();
        
        tuitionData.push({
        	dgrNo: dgrNo,
        	departmentTuition: departmentTuition
        });
    });
    
    console.log("저장할 등록금 데이터:", tuitionData);
    
    // 서버로 데이터 전송
    $.ajax({
        type: "POST",
        url: "/staff/tuition/tuitionUpdate.do", // 백엔드에서 구현할 URL
        data: JSON.stringify(tuitionData),
        contentType: "application/json",
        success: function(response) {
            console.log("등록금 저장 성공:", response);
            alert("등록금이 성공적으로 저장되었습니다.");
            
            // 저장 버튼 다시 활성화
            saveButton.prop('disabled', false).text('저장');
        },
        error: function(xhr, status, error) {
            console.error("등록금 저장 실패:", error);
            alert("등록금 저장에 실패했습니다. 다시 시도해주세요.");
            
            // 저장 버튼 다시 활성화
            saveButton.prop('disabled', false).text('저장');
        }
    });
}
</script>