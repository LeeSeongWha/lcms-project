<%--
 * == 개정이력(Modification Information) ==
 * 수정일	수정자	수정내용
 * ========================================
 * 250701	서경덕	최초 생성
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<title>교수 상세 조회</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
<link rel="stylesheet" href="/dist/assets/css/test/studentDetail2.css"> 
<script src="/js/app/pfcp/staff/professorDetail.js"></script>

<div class="studentDetail">
<form method="post" action="/staff/professorManagement/professorUpdateProcess.do" style="background:transparent; border:none; box-shadow:none; padding:0;">
	<h1>교수 상세 조회</h1>
	<hr class="h1-hr">
	
		<div class="tableContainer">
			<table class="defaultTable">
				<tr class="tableRowHover">
					<th class="tableTh">
						교번
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userNo" name="user.userNo" value="${professor.user.userNo }" readonly>
					</td>
					<th class="tableTh">
						교수명
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userName" name="user.userName"
					 		value="${professor.user.userName }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						교수 직책
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="proPosition" name="proPosition" 
							value="${professor.proPosition }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
					<th class="tableTh">
						학과
					</th>
					<td class="tableTd">
						<select id="departmentNo" name="departmentNo" class="selectBox" 
							data-init-val="${professor.department.departmentNo }" ${professor.proStatus eq '퇴직' ? 'disabled' : ''}>
							<option value="${professor.department.departmentNo }">${professor.department.departmentName }</option>
						</select>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						입사 일자
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="proHiredate" name="proHiredate" value="${professor.proHiredate }" readonly>
					</td>
					<th class="tableTh">
						퇴직 일자
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="proRdate" name="proRdate" value="${professor.proRdate }" readonly>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						교수 상태
					</th>
					<td class="tableTd">
						<select id="proStatus" name="proStatus" class="selectBox" ${professor.proStatus eq '퇴직' ? 'disabled' : ''}>
							<option value="재직" ${professor.proStatus eq '재직' ? 'selected' : ''}>재직</option>
							<option value="휴직" ${professor.proStatus eq '휴직' ? 'selected' : ''}>휴직</option>
							<option value="퇴직" ${professor.proStatus eq '퇴직' ? 'selected' : ''}>퇴직</option>
						</select>
					</td>
					<th class="tableTh">
						성별
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="gender" name="user.gender" value="${professor.user.gender }" readonly>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						주민등록번호 앞자리
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userRegno1" name="user.userRegno1" value="${professor.user.userRegno1 }" readonly>
					</td>
					<th class="tableTh">
						주민등록번호 뒷자리
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userRegno2" name="user.userRegno2" value="${professor.user.userRegno2 }" readonly>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						전화번호
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userTel" name="user.userTel" 
							value="${professor.user.userTel }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
					<th class="tableTh">
						우편번호
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userZip" name="user.userZip" 
							value="${professor.user.userZip }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						기본 주소
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userAdd1" name="user.userAdd1" 
							value="${professor.user.userAdd1 }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
					<th class="tableTh">
						상세 주소
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userAdd2" name="user.userAdd2" 
							value="${professor.user.userAdd2 }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						이메일
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userEmail" name="user.userEmail" 
							value="${professor.user.userEmail }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
					</td>
					<th class="tableTh">
						은행
					</th>
					<td class="tableTd">
						<select id="bankCd" name="user.bankCd" class="selectBox" data-init-bank="${professor.type.typeCode }" class="selectBox" ${professor.proStatus eq '퇴직' ? 'disabled' : ''}>
		                	<option value="${professor.type.typeCode }">${professor.type.typeName }</option>
		                </select>
					</td>
				</tr>
				<tr class="tableRowHover">
					<th class="tableTh">
						계좌번호
					</th>
					<td class="tableTd">
						<input class="inputField" type="text" id="userBankno" name="user.userBankno" 
							value="${professor.user.userBankno }" ${professor.proStatus eq '퇴직' ? 'readonly' : ''}>
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
