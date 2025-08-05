package kr.or.ddit.pfcp.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.component.NotificationUtils;
import kr.or.ddit.pfcp.common.mapper.NotificationMapper;
import kr.or.ddit.pfcp.common.vo.NotificationVO;
import lombok.RequiredArgsConstructor;

/**
 * @author seokyungdeok
 * @since 2025. 7. 17.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 17.	|	서경덕	|	최초 생성
 */
@Service(value = "notificationService")
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private NotificationMapper notificationMapper;
	
	private final SimpMessagingTemplate messagingTemplate;
	
	public void notifyUser(String userNo, NotificationVO notification) {
		messagingTemplate.convertAndSend("/meeting/notify/" + userNo, notification);
	}

	@Override
	public List<NotificationVO> readUnreadByUser(String userNo) {
		
		return notificationMapper.selectUnreadByUser(userNo);
	}

	@Override
	public void createNotification(NotificationVO notification) {
		// TODO Auto-generated method stub
		notificationMapper.insertNotification(notification);
	}

	@Override
	public List<NotificationVO> readUnreadNotifications(String userNo) {
		// TODO Auto-generated method stub
		return notificationMapper.selectUnreadByUser(userNo);
	}

	@Override
	public void markAsRead(String notiNo) {
		// TODO Auto-generated method stub
		notificationMapper.markAsRead(notiNo);
	}
	
	@Override
	public void sendNotification(List<String> roles, String message, String linkUrl) {
        for (String role : roles) {
            switch (role) {
                case "student":
                    NotificationUtils.sendToStudent(message, linkUrl);
                    break;
                case "professor":
                    NotificationUtils.sendToProfessor(message, linkUrl);
                    break;
                case "staff":
                    NotificationUtils.sendToStaff(message, linkUrl);
                    break;
            }
        }
    }
}
