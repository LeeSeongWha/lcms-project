package kr.or.ddit.validate.utils;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Component
public class ErrorsUtils {
    
    // 기존 validation 에러 처리
    public MultiValueMap<String, String> errorsToMap(BindingResult errors) {
        MultiValueMap<String, String> customErrors = new LinkedMultiValueMap<String, String>();
        List<ObjectError> allErrors = errors.getAllErrors();
        for (ObjectError single : allErrors) {
            if (single instanceof FieldError) {
                FieldError fe = (FieldError) single;
                String fieldName = fe.getField();
                String message = fe.getDefaultMessage();
                customErrors.add(fieldName, message);
            }
        }
        return customErrors;
    }
    
    // 인증 에러 처리를 위한 새로운 메서드
    public Map<String, Object> createAuthErrorResponse(AuthenticationException e) {
        Map<String, Object> errorResponse = new HashMap<>();
        
        String errorMessage;
        String errorCode;
        
        if (e instanceof org.springframework.security.authentication.BadCredentialsException) {
            errorMessage = "아이디 또는 비밀번호가 올바르지 않습니다.";
            errorCode = "INVALID_CREDENTIALS";
        } else if (e instanceof org.springframework.security.core.userdetails.UsernameNotFoundException) {
            errorMessage = "존재하지 않는 아이디입니다.";
            errorCode = "USER_NOT_FOUND";
        } else if (e instanceof org.springframework.security.authentication.DisabledException) {
            errorMessage = "비활성화된 계정입니다.";
            errorCode = "ACCOUNT_DISABLED";
        } else if (e instanceof org.springframework.security.authentication.AccountExpiredException) {
            errorMessage = "만료된 계정입니다.";
            errorCode = "ACCOUNT_EXPIRED";
        } else if (e instanceof org.springframework.security.authentication.CredentialsExpiredException) {
            errorMessage = "비밀번호가 만료되었습니다.";
            errorCode = "CREDENTIALS_EXPIRED";
        } else if (e instanceof org.springframework.security.authentication.LockedException) {
            errorMessage = "잠긴 계정입니다.";
            errorCode = "ACCOUNT_LOCKED";
        } else {
            errorMessage = "로그인에 실패했습니다. 다시 시도해주세요.";
            errorCode = "AUTHENTICATION_FAILED";
        }
        
        errorResponse.put("success", false);
        errorResponse.put("error", 401);
        errorResponse.put("code", errorCode);
        errorResponse.put("message", errorMessage);
        errorResponse.put("timestamp", System.currentTimeMillis());
        
        return errorResponse;
    }
    
    // 일반적인 에러 응답 생성
    public Map<String, Object> createErrorResponse(int statusCode, String message, String code) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("success", false);
        errorResponse.put("error", statusCode);
        errorResponse.put("code", code);
        errorResponse.put("message", message);
        errorResponse.put("timestamp", System.currentTimeMillis());
        return errorResponse;
    }
    
    // 성공 응답 생성
    public Map<String, Object> createSuccessResponse(Object data) {
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("success", true);
        successResponse.put("data", data);
        successResponse.put("timestamp", System.currentTimeMillis());
        return successResponse;
    }
    
    // validation 에러와 기타 에러를 통합한 응답 생성
    public Map<String, Object> createValidationErrorResponse(BindingResult errors) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("success", false);
        errorResponse.put("error", 400);
        errorResponse.put("code", "VALIDATION_FAILED");
        errorResponse.put("message", "입력값 검증에 실패했습니다.");
        errorResponse.put("fieldErrors", errorsToMap(errors));
        errorResponse.put("timestamp", System.currentTimeMillis());
        return errorResponse;
    }
}