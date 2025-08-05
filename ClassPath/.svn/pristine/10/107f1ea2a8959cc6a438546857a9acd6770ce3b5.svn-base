package kr.or.ddit.pfcp.staff.thesis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.pfcp.common.vo.ThesisVO;

/**
 * @author 김태수
 * @since 2025. 7. 22.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 22.	|	김태수	|	최초 생성
 */
@Mapper
public interface StaffThesisMapper {

	public List<ThesisVO> selectThesisList(Map<String, Object> searchMap);
	public int appThesisStatus(String thesisNo);
	public int rejThesisStatus(String thesisNo);
	
}
