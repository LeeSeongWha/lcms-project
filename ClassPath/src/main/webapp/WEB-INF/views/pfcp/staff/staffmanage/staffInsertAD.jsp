<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<link rel="stylesheet" href="/dist/assets/css/test/staffInsert2.css">

<title>교직원 등록</title>

<c:if test="${not empty success}">
  <script>
    alert("${success}");
  </script>
</c:if>

<script src="<c:url value='/js/app/pfcp/staff/staffInsertForm.js'/>"></script>

<div class="staffInsert">
	<form action="/staff/staffmanage/staffInsertProcess.do" method="post" style="display:contents;"> 
	
		<h1>교직원 등록</h1>
		<hr class="h1-hr">
		<input type="hidden" name="no" value="${staff.user.userNo}" />
	
		<div class="tableContainer">
			<table class="defaultTable">
				<tbody>
					<tr class="tableRowHover">
						<th class="tableTh">사번</th>
						<td class="tableTd">
							<input class="inputField" type="text" name="user.userNo" value="자동으로 부여됩니다" readonly />
						</td>
						<th class="tableTh">이름</th>
						<td class="tableTd">
							<input class="inputField" type="text" name="user.userName" required/>
						</td>
					</tr>
	
					<tr class="tableRowHover">
						<th class="tableTh">부서</th>
						<td class="tableTd" style="display: flex; justify-content: space-between; align-items: center;">
	<!-- 						<input class="inputField" type="text" name="staffDepartment" style="width: 60%; text-align: left;" /> -->
							 <select id="staffDepartment" name="staffDepartment" class="selectBox" required>
						            <option disabled selected>- 선택 -</option>
						            <option>기획처</option>
						            <option>교무처</option>
						            <option>총장실</option>
						            <option>재무과</option>
						            <option>전산정보팀</option>
						            <option>입학처</option>
						            <option>사무처</option>
						    </select>
						</td>
	
	
						<th class="tableTh">직위</th>
						<td class="tableTd">
	<%-- 						<input class="inputField" type="text" name="staffPosition" value="${staff.staffPosition}" /> --%>
							<select id="staffPosition" name="staffPosition" class="selectBox" required>
						            <option disabled selected>- 선택 -</option>
						            <option>주임</option>
						            <option>사원</option>
						            <option>팀장</option>
						            <option>대장</option>
						            <option>계장</option>
						            <option>선임</option>
						            <option>부팀장</option>
						    </select>
						</td>
					</tr>
	
					<tr class="tableRowHover">
						<th class="tableTh">이메일</th>
						<td class="tableTd">
							<input class="inputField" type="email" name="user.userEmail" id="userEmail"/>
						</td>
						<th class="tableTh">전화번호</th>
						<td class="tableTd">
							<input class="inputField" type="text" name="user.userTel" id="userTel"/>
						</td>
					</tr>
	
					<tr class="tableRowHover">
						<th class="tableTh">생년월일</th>
						<td class="tableTd">
							<input class="inputField" type="text" name="user.userRegno1" id="userRegno1" />
						</td>
						<th class="tableTh">성별</th>
						<td class="tableTd">
							<input class="inputField" type="text" name="user.gender" id="gender"/>
						</td>
					</tr>
	
					<tr class="tableRowHover">
					    <th class="tableTh">은행</th>
					    <td class="tableTd">
						    <select id="bankCd" name="user.bankCd" class="selectBox" data-init-bank="${professor.type.typeCode }">
			                	<option value="">선택하세요</option>
			                </select>
					    </td>
					    <th class="tableTh">계좌번호</th>
					    <td class="tableTd">
					        <input class="inputField" type="text" name="user.userBankno" id="bankNo"/>
					    </td>
					</tr>
	
	
					<tr class="tableRowHover">
						<th class="tableTh">우편번호</th>
						<td class="tableTd">
							<div class="input-with-icon">
								<input type="text" name="user.userZip" id="sample4_postcode" class="inputField" readonly/>
								<i class="fas fa-search search-icon" onclick="sample4_execDaumPostcode()"></i>
							</div>
						</td>
					</tr>
	
					<tr class="tableRowHover">
						<th class="tableTh">기본주소</th>
						<td class="tableTd">
							<input class="inputField" type="text" id="sample4_roadAddress" name="user.userAdd1" placeholder="도로명주소" />
						</td>
						<th class="tableTh">상세주소</th>
						<td class="tableTd">
							<input class="inputField" type="text" id="sample4_detailAddress" name="user.userAdd2" placeholder="상세주소" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<div style="margin-top:20px;" style="display:flex; justify-content:space-between;">
			<button type="submit" class="submitButton" style="float: right;">저장</button>
			<button type="button" class="cancelButton" onclick="moveToList()">목록으로</button>
		</div>
	</form>
</div>


<script>
	function moveToList() {
		window.location.href = "/staff/staffmanage/staffmanageList.do";
	}

</script>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 도로명 주소 변수
            var roadAddr = data.roadAddress;

            // 우편번호와 도로명 주소만 필드에 넣기
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById('sample4_roadAddress').value = roadAddr;

            // 상세주소는 사용자가 직접 입력하는 필드이므로 초기화하지 않음
        }
    }).open();
}
</script>

