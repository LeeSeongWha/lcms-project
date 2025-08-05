<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>시설 예약 가능 시간 설정</title>
<!-- ✅ Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ 사용자 정의 CSS -->
<!-- <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> -->
<link rel="stylesheet" href="/dist/assets/css/staff/facilitySchedule2.css">
</head>

<style>
	.studentDetail .searchButton {
    background: #4a5568;
    color: #ffffff;
    border: none;
    padding: 10px 16px;
    font-size: 0.875rem;
    font-weight: 600;
    border-radius: 4px;
    cursor: pointer;
    transition: all 0.2s ease;
    white-space: nowrap;
    min-width: 120px;
}

.studentDetail .searchButton:hover {
    background: #2d3748;
    transform: translateY(-1px);
    box-shadow: 0 2px 8px rgba(74, 85, 104, 0.3);
}

/* ==========================================================================
   버튼 스타일링
   ========================================================================== */

/* 저장 버튼 */
.submitButton {
    background: #2b6cb0;
    color: #ffffff;
    border: none;
    padding: 12px 24px;
    font-size: 0.9rem;
    font-weight: 600;
    border-radius: 4px;
    cursor: pointer;
    transition: all 0.2s ease;
    min-width: 100px;
}

.submitButton:hover {
    background: #2a5298;
    transform: translateY(-1px);
    box-shadow: 0 2px 8px rgba(43, 108, 176, 0.3);
}

/* 취소/목록 버튼 */
.cancelButton {
    background: #718096;
    color: #ffffff;
    border: none;
    padding: 12px 24px;
    font-size: 0.9rem;
    font-weight: 600;
    border-radius: 4px;
    cursor: pointer;
    transition: all 0.2s ease;
    min-width: 100px;
}

.cancelButton:hover {
    background: #4a5568;
    transform: translateY(-1px);
    box-shadow: 0 2px 8px rgba(113, 128, 150, 0.3);
}
	
</style>

<c:set var="days" value="${fn:split('MON,TUE,WED,THU,FRI', ',')}" />
<c:set var="dayNames" value="${fn:split('월요일,화요일,수요일,목요일,금요일', ',')}" />

<body class="facility-schedule-page">

<div class="facility-schedule-container">

  <div class="facility-info-card">
    <h3 id="facilityName" class="facility-name">
      ${facility.facilityName } <span class="facility-location"> - ${facility.location }</span>
    </h3>
    <p id="facilityInfo" class="facility-details">
      ${facility.facilityType } / ${facility.facilityMp }인 사용 가능
    </p>
  </div>

  <!-- 수정 모드 안내 -->
  <c:if test="${mode == 'edit'}">
    <div class="notice-box notice-warning">
      📝 수정 모드: 시간표의 셀을 클릭하여 예약 가능 시간을 설정하세요.
    </div>
  </c:if>

  <div class="schedule-section">
    <div class="table-container">
      <table class="schedule-table">
        <thead class="schedule-table-head">
          <tr>
            <th class="schedule-table-th time-header">시간</th>
            <c:forEach var="dayName" items="${dayNames}">
              <th class="schedule-table-th day-header">${dayName}</th>
            </c:forEach>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="hour" begin="9" end="17">
            <tr>
              <td class="schedule-table-td time-cell">${hour}:00 - ${hour+1}:00</td>
              <c:forEach var="day" items="${days}">
                <c:set var="found" value="false" />
                <c:forEach var="item" items="${facilityRT}">
                  <c:if test="${item.reservationDay eq day && item.startHour eq hour}">
                    <c:set var="found" value="true" />
                  </c:if>
                </c:forEach>
                <c:choose>
                  <c:when test="${found}">
                    <td class="schedule-table-td slot-cell available-slot"
                        onclick="toggleTimeSlot(this, '${day}', ${hour})"
                        data-day="${day}" data-hour="${hour}">
                      <span>예약가능</span>
                    </td>
                  </c:when>
                  <c:otherwise>
                    <td class="schedule-table-td slot-cell unavailable-slot <c:if test='${mode == "edit"}'> editable-slot </c:if>"
                        <c:if test="${mode == 'edit'}"> onclick="toggleTimeSlot(this, '${day}', ${hour})" </c:if>
                        data-day="${day}" data-hour="${hour}">
                      <span>-</span>
                    </td>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <div class="legend-container">
      <div class="legend-item">
        <div class="legend-color available-legend"></div>
        <span class="legend-text">예약 가능 시간</span>
      </div>
      <div class="legend-item">
        <div class="legend-color unavailable-legend"></div>
        <span class="legend-text">예약 불가능 시간</span>
      </div>
      <c:if test="${mode == 'edit'}">
        <div class="legend-item">
          <div class="legend-color new-slot-legend"></div>
          <span class="legend-text">새로 추가된 시간</span>
        </div>
      </c:if>
    </div>
  </div>

  <!-- 버튼 영역 -->
  <div class="button-container">
    <c:choose>
      <c:when test="${mode == 'edit'}">
        <button onclick="saveSchedule()" class="submitButton">저장</button>
        <button onclick="resetSchedule()" class="editButton">초기화</button>
        <button onclick="cancelSchedule()" class="cancelButton">취소</button>
      </c:when>
      <c:otherwise>
        <button onclick="goBack()" class="cancelButton">목록으로</button>
        <button onclick="insertSchedule()" class="editButton">수정</button>
      </c:otherwise>
    </c:choose>
  </div>
</div>

<!-- ✅ 기존 JavaScript는 그대로 유지 -->
<script>
  let changedSlots = {};
  
  function resetSchedule() {
    // changedSlots 초기화
    changedSlots = {};

    // 예약 시간표 td 중 data-day, data-hour 속성 있는 셀 모두 찾기
    document.querySelectorAll('td[data-day][data-hour]').forEach(cell => {
      const span = cell.querySelector('span');
      // 텍스트를 '-'로 변경
      span.textContent = '-';
      
      // 클래스 변경
      cell.className = 'schedule-table-td slot-cell unavailable-slot editable-slot';
    });
  }

  function cancelSchedule() {
    history.back();
  }
  
  function insertSchedule() {
    const urlParams = new URLSearchParams(window.location.search);
    const what = urlParams.get('what');
    window.location.href = "/staff/reservationTimestamp/facility/facilityInsert.do?what=" + what;
  }

  function goBack() {
    window.location.href = "/staff/facility/facilityList.do";
  }

  function toggleTimeSlot(cell, day, hour) {
    const key = day + '_' + hour;
    const span = cell.querySelector('span');

    if (span.textContent === '예약가능') {
      span.textContent = '-';
      cell.className = 'schedule-table-td slot-cell unavailable-slot editable-slot';
      changedSlots[key] = 'delete';
    } else {
      span.textContent = '예약가능';
      cell.className = 'schedule-table-td slot-cell new-slot';
      changedSlots[key] = 'add';
    }
  }

  function saveSchedule() {
    const activeSlots = [];

    document.querySelectorAll("td[data-day][data-hour]").forEach(cell => {
      const day = cell.dataset.day;
      const hour = parseInt(cell.dataset.hour);

      if (!cell.classList.contains('unavailable-slot')) {
        activeSlots.push({ day, hour });
      }
    });

    const urlParams = new URLSearchParams(window.location.search);
    const what = urlParams.get('what');

    const formData = new FormData();
    formData.append('what', what);
    formData.append('timeSlots', JSON.stringify(activeSlots));

    fetch('/staff/reservationTimestamp/facility/facilityUpdateProcess.do', {
      method: 'POST',
      body: formData
    })
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          alert('예약 시간 설정이 저장되었습니다!');
          window.location.href = "/staff/reservationTimestamp/facility/facility.do?what=" + what;
        } else {
          alert('저장 중 오류가 발생했습니다.');
        }
      })
      .catch(error => {
        console.error('Error:', error);
        alert('저장 중 오류가 발생했습니다.');
      });
  }
</script>
</body>
</html>