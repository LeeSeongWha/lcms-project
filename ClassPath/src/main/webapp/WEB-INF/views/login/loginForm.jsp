<%@ page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/dist/assets/css/loginForm.css" rel="stylesheet" />
</head>
<body>

<div class="login-form-container">
<!-- 브랜드 헤더 -->
        <div class="brand-header">
            <h1 class="brand-title">Learning Hub</h1>
            <p class="brand-subtitle">스마트한 학습 관리 시스템</p>
        </div>
    <form:form method="post" id="loginForm">
        <div class="card my-5">
            <div class="card-body">
                <!-- 로그인 헤더 -->
                <div class="login-header">
                    <p class="login-subtitle">계정 정보를 입력해주세요</p>
                </div>
                
                <!-- 아이디 입력 -->
                <div class="form-group">
                    <label class="form-label">아이디</label>
                    <input type="text" class="form-control" placeholder="학번(교번)을 입력해주세요" 
                           name="username" id="username">
                    <div id="username-error" class="field-error" style="display: none;"></div>
                </div>
                
                <!-- 비밀번호 입력 -->
                <div class="form-group">
                    <label class="form-label">비밀번호</label>
                    <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" 
                           name="password" id="password">
                    <div id="password-error" class="field-error" style="display: none;"></div>
                </div>
                
                <!-- 로그인 버튼 -->
                <div class="d-grid mt-4">
                    <button type="submit" class="btn btn-primary" id="loginBtn">
                        <span class="btn-text">로그인</span>
                        <div class="spinner"></div>
                    </button>
                </div>

                <!-- 아이디/비밀번호 찾기 -->
                <div class="find-links">
                    <div class="d-flex justify-content-center gap-4">
                        <p class="find-link mb-0" id="findIdBtn" 
                           data-bs-toggle="modal" data-bs-target="#findIdModal" style="cursor: pointer">
                           아이디 찾기
                        </p>
                        <p class="find-link mb-0"
                           data-bs-toggle="modal" data-bs-target="#findPasswordModal" style="cursor: pointer">
                           비밀번호 찾기
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </form:form>

    <!-- 임시 로그인 섹션 -->
    <!-- <div class="temp-login-section">
        <p class="temp-login-title">개발용 빠른 로그인</p>
        <div class="temp-login-options">
            <label class="temp-login-btn" for="studentLogin">
                <input type="radio" id="studentLogin" name="quickLogin">
                <span>학생</span>
            </label>
            <label class="temp-login-btn" for="professorLogin">
                <input type="radio" id="professorLogin" name="quickLogin">
                <span>교수</span>
            </label>
            <label class="temp-login-btn" for="staffLogin">
                <input type="radio" id="staffLogin" name="quickLogin">
                <span>교직원</span>
            </label>
        </div>
    </div> -->
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/js/app/pfcp/common/loginForm.js"></script>
</body>
</html>