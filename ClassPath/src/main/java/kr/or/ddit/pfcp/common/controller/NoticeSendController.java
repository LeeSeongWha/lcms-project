package kr.or.ddit.pfcp.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.pfcp.common.service.NotificationService;

/**
 * @author seokyungdeok
 * @since 2025. 7. 19.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 19.	|	서경덕	|	최초 생성
 */
@Controller
public class NoticeSendController {
	@Autowired
	private NotificationService notificationService;
	
	/**
	 * 알림 보내기
	 * 
	 * @param body
	 * @return
	 */
	@PostMapping("/sendNotification.do")
	@ResponseBody
	public ResponseEntity<String> sendNotice(@RequestBody Map<String, Object> body) {
		List<String> roles = (List<String>) body.get("roles");
		
	    String message = (String) body.get("message");
	    String linkUrl = (String) body.get("linkUrl");
	    
	    notificationService.sendNotification(roles, message, linkUrl);
	    
	    return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("success");
	}
	
	/**
	 * 알림 읽었나 안읽었나 판별
	 * 
	 * @param body
	 * @return
	 */
	@PostMapping("/notif/notifications/read")
	@ResponseBody
	public ResponseEntity<Void> readNotification(@RequestBody Map<String, String> body) {
	    String notiNo = body.get("notiNo");
	    
	    notificationService.markAsRead(notiNo); // DB 업데이트
	    
	    return ResponseEntity.ok().build();
	}
}
