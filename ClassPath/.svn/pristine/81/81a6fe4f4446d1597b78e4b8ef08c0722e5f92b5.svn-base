package kr.or.ddit.pfcp.staff.notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.BoardVO;


/**
 * 20250707 LSJ 수정함.
 */
@Mapper
public interface NoticeMapper {

	public int selectTotalCount(Map<String, Object> paramMap);
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap);
	
	public int selectTotalCountByKeyword(Map<String, Object> paramMap);
	
	public BoardVO selectBoard(String what);
	public void updateBoard(BoardVO board);
	public void insertBoard(BoardVO board);
	public BoardVO selectByScheduleNo(String scheduleNo);
	public void updateBoardDeleted(String what);
	public List<BoardVO> selectNoticeList();
}
