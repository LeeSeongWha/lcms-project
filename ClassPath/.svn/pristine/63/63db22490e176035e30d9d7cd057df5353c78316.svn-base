package kr.or.ddit.pfcp.student.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.pfcp.common.vo.BoardVO;

/**
 * @author YSM
 * @since 2025. 6. 30.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 21.  |   이성화 |    최초 생성
 */
public interface StudentNoticeService {

	public List<BoardVO> readBoardList(Map<String, Object> paramMap);

	public BoardVO readBoard(String boardNo);

	public void modifyBoard(BoardVO board);

	public void createBoard(BoardVO board);
	
	public BoardVO readBoardByScheduleNo(String ScheduleNo);

	public void modifyBoardDeleted(String what);

	public int readTotalCount(Map<String, Object> paramMap);
	
	public List<BoardVO> readNoticeList();

}
