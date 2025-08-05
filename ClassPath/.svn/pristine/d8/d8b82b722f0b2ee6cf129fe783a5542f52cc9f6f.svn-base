package kr.or.ddit.pfcp.professor.attendclass.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.pfcp.common.vo.LectureEnrVO;
import kr.or.ddit.pfcp.professor.attendclass.mapper.ProfessorAttendClassMapper;
import lombok.RequiredArgsConstructor;

/**
 * @author 김태수
 * @since 2025. 7. 14.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 14.	|	김태수	|	최초 생성
 */
@Service(value = "attendClassService")
@RequiredArgsConstructor
public class ProfessorAttendClassServiceImpl implements ProfessorAttendClassService {
	
	@Autowired
	private ProfessorAttendClassMapper attenClassMapper;
	
	

	@Override
	public int cntEnrKeyword(Map<String, Object> paramMap) {
		return attenClassMapper.selectCntEnrKeyword(paramMap);
	}

	@Override
	public List<LectureEnrVO> EnrPagingKeyword(Map<String, Object> paramMap) {
		return attenClassMapper.selectEnrPagingKeyword(paramMap);
	}

}
