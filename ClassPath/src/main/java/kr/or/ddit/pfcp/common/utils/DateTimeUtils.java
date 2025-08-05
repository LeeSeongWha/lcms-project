package kr.or.ddit.pfcp.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtils {
    public static String extractDayOfWeek(String dateTimeString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = sdf.parse(dateTimeString);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            
            // ReservationTimestamp 테이블의 요일 형식에 맞게 변환
            String[] days = {"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
            return days[dayOfWeek];
        } catch (Exception e) {
            return null;
        }
    }
    
    // "2024-07-17 14:00" 형식에서 시간 추출
    public static Integer extractHour(String dateTimeString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = sdf.parse(dateTimeString);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.HOUR_OF_DAY);
        } catch (Exception e) {
            return null;
        }
    }
}
