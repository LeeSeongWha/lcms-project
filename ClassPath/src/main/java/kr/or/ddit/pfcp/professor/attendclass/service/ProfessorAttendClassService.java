package kr.or.ddit.pfcp.professor.attendclass.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.pfcp.common.vo.LectureEnrVO;

/**
 * @author 김태수
 * @since 2025. 7. 14.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 14.	|	김태수	|	최초 생성
 */
public interface ProfessorAttendClassService {
	
	
    
    public int cntEnrKeyword(Map<String, Object> paramMap);
    public List<LectureEnrVO> EnrPagingKeyword(Map<String, Object> paramMap);
    
	
}
