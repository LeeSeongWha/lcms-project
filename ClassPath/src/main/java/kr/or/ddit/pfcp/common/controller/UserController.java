package kr.or.ddit.pfcp.common.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kr.or.ddit.pfcp.common.service.UserService;
import kr.or.ddit.pfcp.common.vo.UserDataVO;
import kr.or.ddit.pfcp.common.vo.UserVO;
import kr.or.ddit.pfcp.student.department.service.StudentDepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ajax/user")
public class UserController {
  
  private final UserService service;
  
  private final PasswordEncoder passwordEncoder;
  
  private final StudentDepartmentService studentDepartmentService;
  
  @PostMapping("/findUserNo")
  public ResponseEntity<?> findUserNo(
        @RequestBody UserDataVO userdata
      ){
    
      Map<String, Object> response = new HashMap<String, Object>();
     try {
      if(userdata.getUsername() == null || userdata.getUsername().trim().isEmpty()) {
         response.put("success", false);
         response.put("message", "이름을 입력해주세요.");
         return ResponseEntity.badRequest().body(response);
       }
       
       if(userdata.getBirthDate() == null) {
         response.put("success", false);
         response.put("message", "생년월일을 입력해주세요.");
         return ResponseEntity.badRequest().body(response);
       }
       
       String userNo = service.findUserName(userdata);
       
       if(userNo != null) {
         response.put("success", true);
         response.put("userNo", userNo);
         response.put("message", "사용자를 찾았습니다.");
         return ResponseEntity.ok(response);
       } else {
         response.put("success", false);
         response.put("message", "일치하는 사용자를 찾을 수 없습니다.");
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
       }
    } catch (Exception e) {
      response.put("success", false);
      response.put("message", "조회 중 오류가 발생하였습니다 : " + e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
     
  }
  
  
  @PostMapping("/replaceUserPassword")
  public ResponseEntity<?> findUserPassword(
        @RequestParam String userNo,
        @RequestParam String userEmail
      ){
    log.info("userNo {}", userNo);
    log.info("userEmail {}", userEmail);
    Map<String, Object> response = new HashMap<String, Object>();
    try {
     if(userEmail == null || userEmail.trim().isEmpty()) {
        response.put("success", false);
        response.put("message", "이메일을 입력해주세요.");
        return ResponseEntity.badRequest().body(response);
      }
     
     if(userNo == null || userNo.trim().isEmpty()) {
       response.put("success", false);
       response.put("message", "학번(교번)을 입력해주세요.");
       return ResponseEntity.badRequest().body(response);
     }
      
      boolean isValid = service.modifyUserPassword(userEmail);
      
      if(isValid) {
        response.put("success", true);
        response.put("message", "이메일 전송이 완료되었습니다.");
        return ResponseEntity.ok(response);
      } else {
        response.put("success", false);
        response.put("message", "일치하는 사용자를 찾을 수 없습니다.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
      }
   } catch (Exception e) {
     response.put("success", false);
     response.put("message", "조회 중 오류가 발생하였습니다 : " + e.getMessage());
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
   }
  }
  
  @PostMapping("/verifyPassword")
  public ResponseEntity<?> verifyPassword(
        @RequestParam String currentPassword,
        Authentication authentication
      ){
    String userNo = authentication.getName();
    UserVO user = service.readMember(userNo);
    
    Map<String, Object> response = new HashMap<String, Object>();
    
    if(user == null) {
      response.put("success", false);
      response.put("message", "사용자를 찾을 수 없습니다.");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    if(passwordEncoder.matches(currentPassword, user.getUserPass())) {
      response.put("success", true);
      response.put("message", "비밀번호가 확인되었습니다.");
      return ResponseEntity.ok(response);
    } else {
      response.put("success", false);  // ← 수정: false로 변경
      response.put("message", "비밀번호가 틀렸습니다.");  // ← 수정: 메시지 변경
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
  }

  @PutMapping("/changeUserPassword")
  public ResponseEntity<?> changeUserPassword(
        @RequestParam String userPass,
        Authentication authentication) {

      Map<String, Object> response = new HashMap<>();

      if (userPass == null || userPass.isEmpty()) {
          response.put("success", false);
          response.put("message", "패스워드를 입력해주세요.");
          return ResponseEntity.badRequest().body(response);
      }

      if (userPass.length() < 8) {
          response.put("success", false);
          response.put("message", "비밀번호는 8자 이상이어야 합니다.");
          return ResponseEntity.badRequest().body(response);
      }

      UserVO user = new UserVO();
      user.setUserNo(authentication.getName());
      user.setUserPass(userPass); // 평문으로 전달 (서비스에서 암호화)

      if (service.changeUserPassword(user)) {
          response.put("success", true);
          response.put("message", "비밀번호가 수정되었습니다.");
          return ResponseEntity.ok(response);
      } else {
          response.put("success", false);
          response.put("message", "비밀번호 수정에 실패하였습니다.");
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
      }
  }
  
  @GetMapping("/departmentName")
  public ResponseEntity<Map<String, String>> getUserDepartmentName(
        Authentication authentication
      ){
    String departmentName = studentDepartmentService.readStudentDepartmentName(authentication.getName());
    Map<String, String> response = new HashMap<String, String>();
    response.put("departmentName", departmentName);
    return ResponseEntity.ok(response);
  }
  
}
