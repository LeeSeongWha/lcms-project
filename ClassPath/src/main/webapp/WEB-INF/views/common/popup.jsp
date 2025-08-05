<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 팝업 스타일 -->
<style>
.popup-container {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.6);
    z-index: 9999;
    opacity: 0;
    visibility: hidden;
    transition: all 0.3s ease;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 30px;
    box-sizing: border-box;
    gap: 40px;
}

.popup-container.active {
    opacity: 1;
    visibility: visible;
}

.popup-content {
    position: relative;
    background: white;
    border-radius: 15px;
    overflow: hidden;
    box-shadow: 0 15px 50px rgba(0, 0, 0, 0.4);
    transform: scale(0.8);
    transition: transform 0.3s ease;
    max-width: 500px;
    max-height: 85vh;
    width: 100%;
    display: flex;
    flex-direction: column;
}

.popup-image-container {
    flex: 1;
    overflow-y: auto;
    max-height: calc(85vh - 60px); /* 버튼 높이만큼 빼기 */
}

.popup-image-container::-webkit-scrollbar {
    width: 8px;
}

.popup-image-container::-webkit-scrollbar-track {
    background: #f1f1f1;
}

.popup-image-container::-webkit-scrollbar-thumb {
    background: #c1c1c1;
    border-radius: 4px;
}

.popup-image-container::-webkit-scrollbar-thumb:hover {
    background: #a8a8a8;
}

.popup-container.active .popup-content {
    transform: scale(1);
}

.popup-left {
    animation-delay: 0.1s;
}

.popup-right {
    animation-delay: 0.3s;
}

.popup-image {
    width: 100%;
    height: auto;
    display: block;
}

.popup-close {
    position: absolute;
    top: 10px;
    right: 15px;
    background: rgba(0, 0, 0, 0.7);
    color: white;
    border: none;
    width: 35px;
    height: 35px;
    border-radius: 50%;
    cursor: pointer;
    font-size: 20px;
    line-height: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 10001;
    transition: background-color 0.2s ease;
}

.popup-close:hover {
    background: rgba(0, 0, 0, 0.9);
}

.popup-buttons {
    position: relative;
    bottom: 0;
    left: 0;
    right: 0;
    display: flex;
    background: rgba(255, 255, 255, 0.95);
    backdrop-filter: blur(10px);
    border-top: 1px solid #dee2e6;
    flex-shrink: 0;
}

.popup-btn {
    flex: 1;
    padding: 15px 20px;
    border: none;
    cursor: pointer;
    font-size: 14px;
    font-weight: 500;
    transition: all 0.2s ease;
    text-align: center;
}

.popup-btn-week {
    background: #007bff;
    color: white;
    border-right: 1px solid #0056b3;
}

.popup-btn-week:hover {
    background: #0056b3;
}

.popup-btn-close {
    background: #f8f9fa;
    color: #6c757d;
}

.popup-btn-close:hover {
    background: #e9ecef;
    color: #495057;
}

/* 모바일 대응 */
@media (max-width: 768px) {
    .popup-container {
        flex-direction: column;
        justify-content: center;
        padding: 20px;
        gap: 30px;
    }
    
    .popup-content {
        max-width: 95%;
        max-height: 45vh;
        width: 100%;
    }
    
    .popup-image-container {
        max-height: calc(45vh - 70px); /* 모바일에서 버튼 높이 고려 */
    }
    
    .popup-close {
        top: 8px;
        right: 12px;
        width: 40px;
        height: 40px;
        font-size: 22px;
    }
    
    .popup-btn {
        padding: 18px 15px;
        font-size: 15px;
    }
}

@media (max-width: 480px) {
    .popup-container {
        padding: 15px;
        gap: 20px;
    }
    
    .popup-content {
        max-width: 98%;
        max-height: 42vh;
    }
    
    .popup-image-container {
        max-height: calc(42vh - 65px); /* 작은 모바일에서 버튼 높이 고려 */
    }
    
    .popup-btn {
        padding: 16px 12px;
        font-size: 13px;
    }
}

/* 데스크톱에서 더 큰 크기 */
@media (min-width: 1200px) {
    .popup-content {
        max-width: 600px;
    }
    
    .popup-container {
        gap: 60px;
    }
}
</style>

<!-- 팝업 컨테이너 -->
<div id="popupContainer" class="popup-container">
    <!-- 왼쪽 팝업 -->
    <div class="popup-content popup-left" id="popup1">
        <button class="popup-close" onclick="closePopup('popup1')">&times;</button>
        <div class="popup-image-container">
            <img src="/dist/assets/img/popUp/popUp1.png" alt="팝업 1" class="popup-image">
        </div>
        <div class="popup-buttons">
            <button class="popup-btn popup-btn-week" onclick="closePopupForWeek('popup1')">일주일 동안 안보기</button>
            <button class="popup-btn popup-btn-close" onclick="closePopup('popup1')">닫기</button>
        </div>
    </div>
    
    <!-- 오른쪽 팝업 -->
    <div class="popup-content popup-right" id="popup2">
        <button class="popup-close" onclick="closePopup('popup2')">&times;</button>
        <div class="popup-image-container">
            <img src="/dist/assets/img/popUp/popUp2.png" alt="팝업 2" class="popup-image">
        </div>
        <div class="popup-buttons">
            <button class="popup-btn popup-btn-week" onclick="closePopupForWeek('popup2')">일주일 동안 안보기</button>
            <button class="popup-btn popup-btn-close" onclick="closePopup('popup2')">닫기</button>
        </div>
    </div>
</div>

<script>
// 쿠키 관련 함수들
function setCookie(name, value, days) {
    const expires = new Date();
    expires.setTime(expires.getTime() + (days * 24 * 60 * 60 * 1000));
    document.cookie = name + '=' + value + ';expires=' + expires.toUTCString() + ';path=/';
}

function getCookie(name) {
    const nameEQ = name + "=";
    const ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

// 팝업 관련 함수들
function showPopups() {
    const container = document.getElementById('popupContainer');
    const popup1 = document.getElementById('popup1');
    const popup2 = document.getElementById('popup2');
    
    // 쿠키 확인하여 표시할 팝업 결정
    const hidePopup1 = getCookie('hidePopup1');
    const hidePopup2 = getCookie('hidePopup2');
    
    let hasVisiblePopup = false;
    
    if (hidePopup1) {
        popup1.style.display = 'none';
    } else {
        hasVisiblePopup = true;
    }
    
    if (hidePopup2) {
        popup2.style.display = 'none';
    } else {
        hasVisiblePopup = true;
    }
    
    // 표시할 팝업이 있을 때만 컨테이너 활성화
    if (hasVisiblePopup && container) {
        container.classList.add('active');
        document.body.style.overflow = 'hidden'; // 스크롤 방지
    }
}

function closePopup(popupId) {
    const popup = document.getElementById(popupId);
    if (popup) {
        popup.style.display = 'none';
        
        // 모든 팝업이 닫혔는지 확인
        const popup1 = document.getElementById('popup1');
        const popup2 = document.getElementById('popup2');
        
        if (popup1.style.display === 'none' && popup2.style.display === 'none') {
            closeAllPopups();
        }
    }
}

function closePopupForWeek(popupId) {
    // 일주일 동안 안보기 쿠키 설정
    setCookie('hide' + popupId.charAt(0).toUpperCase() + popupId.slice(1), 'true', 7);
    
    // 팝업 닫기
    closePopup(popupId);
}

function closeAllPopups() {
    const container = document.getElementById('popupContainer');
    if (container) {
        container.classList.remove('active');
        document.body.style.overflow = ''; // 스크롤 복원
        
        // 팝업들 다시 보이게 설정 (다음번을 위해, 쿠키 체크는 showPopups에서)
        setTimeout(() => {
            const popup1 = document.getElementById('popup1');
            const popup2 = document.getElementById('popup2');
            if (popup1) popup1.style.display = '';
            if (popup2) popup2.style.display = '';
        }, 300);
    }
}

// 팝업 외부 클릭시 닫기
document.addEventListener('DOMContentLoaded', function() {
    const container = document.getElementById('popupContainer');
    if (container) {
        container.addEventListener('click', function(e) {
            if (e.target === this) {
                closeAllPopups();
            }
        });
    }
});

// ESC 키로 팝업 닫기
document.addEventListener('keydown', function(e) {
    if (e.key === 'Escape') {
        const container = document.getElementById('popupContainer');
        if (container && container.classList.contains('active')) {
            closeAllPopups();
        }
    }
});

// 페이지 로드 후 팝업 표시
document.addEventListener('DOMContentLoaded', function() {
    setTimeout(() => {
        showPopups();
    }, 1000);
});
</script>