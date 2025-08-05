<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.card {
	max-width: 80%; /* 카드 최대 너비 제한 (원하는 대로 조절) */
	margin: 0 auto; /* 가운데 정렬 */
	height: 85vh; /* 뷰포트 기준 높이 제한 */
	overflow: hidden; /* 스크롤 안 생기게 */
	display: flex;
	flex-direction: column;
	border: 1px solid #ddd;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	background-color: #fff;
}

.card-body {
	overflow-y: auto; /* 필요한 경우 내부 스크롤 (카드 밖은 스크롤 안 생김) */
	flex: 1; /* 남은 공간 다 차지 */
	padding-right: 10px; /* 스크롤 안 보이게 여유 */
}

.custom-btn-wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 10px; /* 버튼 사이 간격 */
	margin-top: 20px;
}

.custom-btn {
	padding: 10px 24px;
	font-size: 16px;
	font-weight: bold;
	border: none;
	border-radius: 6px;
	cursor: pointer;
}

.btn-save {
	background-color: #0d6efd; /* Bootstrap 기본 파랑 */
	color: white;
}

.btn-cancel {
	background-color: #6c757d; /* Bootstrap 기본 회색 */
	color: white;
}

.btn-save:hover {
	background-color: #0b5ed7;
}

.btn-cancel:hover {
	background-color: #5c636a;
}

.mypage-form-label {
	font-weight: 600;
}
#sample6_postcode {
    background-color: #f8f9fa !important;
    cursor: pointer !important; /* not-allowed에서 pointer로 변경 */
    position: relative;
}

#sample6_postcode:hover {
    background-color: #e9ecef !important;
    border-color: #86b7fe !important;
}

#sample6_postcode:focus {
    background-color: #f8f9fa !important;
    box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25) !important;
    border-color: #86b7fe !important;
}
</style>

</head>
<body>
	<div class="card">
		<div class="card-header">
			<h5>개인정보 수정</h5>
		</div>
		<div class="card-body">
			<form:form modelAttribute="user" method="post"
				action="/mypage/updateProcess.do">
				<form:hidden path="userNo" />
				<div class="row">
					<!-- 왼쪽 열 -->
					<div class="col-md-6">
						<!-- 이름 -->
						<div class="form-group mb-3">
							<form:label path="userName" cssClass="mypage-form-label">이름</form:label>
							<form:input path="userName" cssClass="form-control"
								placeholder="이름" />
							<form:errors path="userName" cssClass="text-danger" />
						</div>

						<!-- 성별 -->
						<div class="form-group mb-3">
							<form:label path="gender" cssClass="mypage-form-label">성별</form:label>
							<form:select path="gender" cssClass="form-control">
								<form:option value="">선택</form:option>
								<form:option value="M">남성</form:option>
								<form:option value="F">여성</form:option>
							</form:select>
							<form:errors path="gender" cssClass="text-danger" />
						</div>

						<!-- 연락처 -->
						<div class="form-group mb-3">
							<form:label path="userTel" cssClass="mypage-form-label">연락처</form:label>
							<form:input path="userTel" cssClass="form-control"
								placeholder="연락처" />
							<form:errors path="userTel" cssClass="text-danger" />
						</div>

						<!-- 주소 -->
						<div class="form-group mb-3">
							<form:label path="userZip" cssClass="mypage-form-label">우편번호</form:label>
							<div style="display: flex; gap: 10px;">
								<form:input path="userZip" id="sample6_postcode"
									cssClass="form-control" placeholder="우편번호" readonly="true"  />
							</div>
							<form:errors path="userZip" cssClass="text-danger" />
						</div>

						<div class="form-group mb-3">
							<form:label path="userAdd1" cssClass="mypage-form-label">기본주소</form:label>
							<form:input path="userAdd1" id="sample6_address"
								cssClass="form-control" placeholder="기본주소" readonly="true" />
							<form:errors path="userAdd1" cssClass="text-danger" />
						</div>

						<div class="form-group mb-3">
							<form:label path="userAdd2" cssClass="mypage-form-label">상세주소</form:label>
							<form:input path="userAdd2" id="sample6_detailAddress"
								cssClass="form-control" placeholder="상세주소" />
							<form:errors path="userAdd2" cssClass="text-danger" />
						</div>
					</div>

					<!-- 오른쪽 열 -->
					<div class="col-md-6">
						<!-- 이메일 -->
						<div class="form-group mb-3">
							<form:label path="userEmail" cssClass="mypage-form-label">이메일</form:label>
							<form:input path="userEmail" cssClass="form-control" type="email"
								placeholder="이메일" />
							<form:errors path="userEmail" cssClass="text-danger" />
						</div>

						<!-- 은행코드 -->
						<div class="form-group mb-3">
							<form:label path="bankCd" cssClass="mypage-form-label">은행명</form:label>
							<form:select path="bankCd" cssClass="form-control" id="bankCd">
								<form:option value="">선택</form:option>
							</form:select>
							<form:errors path="bankCd" cssClass="text-danger" />
						</div>

						<!-- 계좌번호 -->
						<div class="form-group mb-3">
							<form:label path="userBankno" cssClass="mypage-form-label">계좌번호</form:label>
							<form:input path="userBankno" cssClass="form-control"
								placeholder="계좌번호" />
							<form:errors path="userBankno" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<!-- 버튼 -->
				<div class="form-group mb-3">
					<div class="custom-btn-wrapper">
						<button type="submit" class="custom-btn btn-save">저장</button>
						<button type="button" class="custom-btn btn-cancel"
							onclick="history.back()">취소</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<script>
	const initBank = '${user.bankCd}';

	document.addEventListener("DOMContentLoaded", () => {
	    
		// 우편번호 입력 필드 클릭 시에도 API 열기
	    document.getElementById("sample6_postcode").addEventListener("click", sample6_execDaumPostcode);
	    
	 // 폼 제출 시 readonly 해제
	    document.querySelector('form').addEventListener('submit', function(e) {
	        document.getElementById('sample6_postcode').removeAttribute('readonly');
	        document.getElementById('sample6_address').removeAttribute('readonly');
	    });

	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                var addr = data.userSelectedType === 'R' ? data.roadAddress : data.jibunAddress;
	                
	                const postcodeInput = document.getElementById('sample6_postcode');
	                const addressInput = document.getElementById('sample6_address');
	                
	                // readonly 잠시 해제하고 값 설정 후 다시 readonly
	                postcodeInput.removeAttribute('readonly');
	                addressInput.removeAttribute('readonly');
	                
	                postcodeInput.value = data.zonecode;
	                addressInput.value = addr;
	                
	                postcodeInput.setAttribute('readonly', 'true');
	                addressInput.setAttribute('readonly', 'true');
	                
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	    
	    const bankCdSelect = document.getElementById("bankCd");

	    axios.get("/staff/professorManagement/bankCodeList.do")
	      .then(resp => {
	        const bankCodeList = resp.data;

	        if (Array.isArray(bankCodeList)) {
	          bankCodeList.forEach(item => {
	            const option = document.createElement("option");
	            option.value = item.typeCode;
	            option.textContent = item.typeName;
	            bankCdSelect.appendChild(option);
	          });

	          if (initBank) {
	            bankCdSelect.value = initBank;
	          }
	        }
	      })
	      .catch(err => console.error("은행 코드 로딩 오류:", err));
	});
	</script>
</body>
</html>