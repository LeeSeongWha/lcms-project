
// moveToList 함수
function moveToList() {
    window.location.href = "/staff/staffmanage/staffmanageList.do";
}

// 다음 우편번호 찾기 함수
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress;
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById('sample4_roadAddress').value = roadAddr;
        }
    }).open();
}

// checkStu 함수 (사번으로 이름 확인 및 입력)
function checkStu() {
    const userNoInput = document.querySelector('input[name="user.userNo"]');
    const userNameInput = document.querySelector('input[name="user.userName"]');
    const userNo = userNoInput.value;

    if (!userNo) {
        alert("사번을 입력해주세요.");
        return;
    }

    // --- ST로 시작하는지 검사하는 로직 추가 ---
    if (!userNo.startsWith('ST')) {
        alert("본교 학생만 조교로 등록 가능합니다.");
        userNameInput.value = ""; // 이름 필드 초기화
        return; // 함수 실행 중단
    }
    // ----------------------------------------

    const checkUserUrl = `/staff/staffmanage/checkUserByNo.do?userNo=${userNo}`;

    fetch(checkUserUrl)
        .then(response => {
            if (!response.ok) {
                if (response.status === 404) {
                    throw new Error("사용자를 찾을 수 없습니다.");
                }
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            if (data && data.userName) {
                const confirmMessage = `${data.userName} 님이 맞습니까?`;
                if (confirm(confirmMessage)) {
                    userNameInput.value = data.userName;
                } else {
                    userNameInput.value = "";
                }
            } else {
                alert("해당 사번에 해당하는 사용자를 찾을 수 없습니다.");
                userNameInput.value = "";
            }
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
            alert("사용자 정보를 가져오는 중 오류가 발생했습니다: " + error.message);
            userNameInput.value = "";
        });
}