package kr.or.ddit.pfcp.student.facility.reservation.service;

import java.util.List;
import kr.or.ddit.pfcp.common.vo.FacilityReservationVO;

/**
 * @author LSH
 * 시설 예약 서비스 인터페이스
 * 
 */
public interface FacilityReservationService {
  public boolean reserveFacility(FacilityReservationVO reservation);
  public List<String> getReservedTimesByFacility(String facilityNo);
  public boolean cancelReservation(String reservationNo, String userId);
  public List<FacilityReservationVO> readFacilityReservationByUserNo(String userNo);
}
