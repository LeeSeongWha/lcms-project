package kr.or.ddit.pfcp.student.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.BoardVO;
import kr.or.ddit.pfcp.staff.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;

/**
 * @author YSM
 * @since 2025. 6. 30.
 *
 * << 개정이력(Modification Information) >>
 * 수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 21.	|	이성화	|	최초 생성
 */
@Service
@RequiredArgsConstructor
public class StudentNoticeServiceImpl implements StudentNoticeService{
	
	private final NoticeMapper mapper;
	
	@Override
	public List<BoardVO> readBoardList(Map<String, Object> paramMap) {
	   
		return mapper.selectBoardList(paramMap);
	}

	@Override
	public BoardVO readBoard(String what) {
		return mapper.selectBoard(what);
	}

	@Override
	public void modifyBoard(BoardVO board) {
		mapper.updateBoard(board);
	}

	@Override
	public void createBoard(BoardVO board) {
		mapper.insertBoard(board);
		
	}

	@Override
	public BoardVO readBoardByScheduleNo(String ScheduleNo) {
		return mapper.selectByScheduleNo(ScheduleNo);
	}

	@Override
	public void modifyBoardDeleted(String what) {
		mapper.updateBoardDeleted(what);
	}

	@Override
	public int readTotalCount(Map<String, Object> paramMap) {
		return mapper.selectTotalCount(paramMap);
	}

  @Override
  public List<BoardVO> readNoticeList() {
    return mapper.selectNoticeList();
  }
	
	

}
























