package kr.or.ddit.pfcp.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.pfcp.common.service.UserService;
import kr.or.ddit.pfcp.common.vo.UserVO;

@RestController
@RequestMapping("/rest/findUserName")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<String> getUserInfo(
				@RequestParam String userNo
			){
		UserVO user = userService.readMember(userNo);
		return ResponseEntity.ok(user.getUserName());
	}
}
