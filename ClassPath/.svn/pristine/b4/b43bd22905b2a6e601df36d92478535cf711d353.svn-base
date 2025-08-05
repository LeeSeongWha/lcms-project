<%--
 * == 개정이력(Modification Information) ==
 * 수정일	수정자	수정내용
 * ========================================
 * 250701	서경덕	최초 생성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<title>교수 등록</title>
<script src="<c:url value='/js/app/pfcp/staff/professorInsertForm.js'/>">
	// 스크립트 코드
</script>

<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css"> 
<link rel="stylesheet" href="/dist/assets/css/test/studentDetail2.css"> 

<h1>교수 등록</h1>
<hr class="h1-hr">
<div class="studentDetail">
	<form method="post" action="/staff/professorManagement/professorInsertProcess.do" style="background:transparent; border:none; box-shadow:none; padding:0;">
		<div class="tableContainer">
			<table class="defaultTable">
				<tr class="tableRowHover">
					<th class="tableTh">
						교번
					</th>
					<td class="tableTd">
						<input type="text" id="userNo" name="user.userNo" value="${newUserNo }" class="inputField" readonly>
					</td>
					<th class="tableTh">
						비밀번호
					</th>
					<td class="tableTd">
						<input type="text" id="userPass" name="user.userPass" placeholder="비밀번호" class="inputField">
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						이름
					</th>
					<td class="tableTd">
						<input type="text" id="userName" name="user.userName" placeholder="이름" class="inputField">
					</td>
					<th class="tableTh">
						교수 직책
					</th>
					<td class="tableTd">
						<input type="text" id="proPosition" name="proPosition" placeholder="교수 직책" class="inputField">
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						학과
					</th>
					<td class="tableTd">
						<select id="departmentNo" name="departmentNo" class="selectBox" data-init-val="${professor.department.departmentNo }">
							<option value="">학과 선택</option>
						</select>
					</td>
					<th class="tableTh">
						성별
					</th>
					<td class="tableTd">
						<input type="radio" class="radioButton" name="user.gender" value="M">남자	    
			   	 		<input type="radio" class="radioButton" name="user.gender" value="W" style="margin-left:15px;">여자
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						주민등록번호 앞자리
					</th>
					<td class="tableTd">
						<input type="text" id="userRegno1" name="user.userRegno1" placeholder="주민등록번호 앞자리" class="inputField">
					</td>
					<th class="tableTh">
						주민등록번호 뒷자리
					</th>
					<td class="tableTd">
						<input type="text" id="userRegno2" name="user.userRegno2" placeholder="주민등록번호 뒷자리" class="inputField">
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						전화번호
					</th>
					<td class="tableTd">
						<input type="text" id="userTel" name="user.userTel" placeholder="전화번호" class="inputField">
					</td>
					<th class="tableTh">
						우편번호
					</th>
					<td class="tableTd">
						<input type="text" id="userZip" name="user.userZip" placeholder="우편번호" class="inputField">
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						기본주소
					</th>
					<td class="tableTd">
						<input type="text" id="userAdd1" name="user.userAdd1" placeholder="기본주소" class="inputField">
					</td>
					<th class="tableTh">
						상세주소
					</th>
					<td class="tableTd">
						<input type="text" id="userAdd2" name="user.userAdd2" placeholder="상세주소" class="inputField">
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						이메일
					</th>
					<td class="tableTd">
						<input type="text" id="userEmail" name="user.userEmail" placeholder="이메일" class="inputField">
					</td>
					<th class="tableTh">
						은행명
					</th>
					<td class="tableTd">
						<select id="bankCd" name="user.bankCd" class="selectBox" data-init-bank="${professor.type.typeCode }">
		                	<option value="">선택하세요</option>
		                </select>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						계좌번호
					</th>
					<td class="tableTd">
						<input type="text" id="userBankno" name="user.userBankno" placeholder="계좌번호" class="inputField">
					</td>
					<th class="tableTh">
						
					</th>
					<td class="tableTd">
						<select id="bankCd" name="user.bankCd" class="selectBox" data-init-bank="${professor.type.typeCode }">
		                	<option value="">선택하세요</option>
		                </select>
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-top:20px;" style="display:flex; justify-content:space-between;">
			<button type="submit" class="submitButton" style="float: right;">저장</button>
			<button type="button" class="cancelButton" onclick="history.back()" >목록으로</button>
		</div>
	</form>
</div>