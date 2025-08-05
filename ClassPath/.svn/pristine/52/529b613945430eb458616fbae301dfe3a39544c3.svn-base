package kr.or.ddit.pfcp.staff.thesis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.pfcp.common.vo.ThesisVO;
import kr.or.ddit.pfcp.staff.thesis.mapper.StaffThesisMapper;
import lombok.RequiredArgsConstructor;

/**
 * @author 김태수
 * @since 2025. 7. 22.
 *
 * << 개정이력(Modification Information) >>
 * 	수정일		|	수정자	|	수정 내용
 * -----------------------------------------------
 * 2025. 7. 22.	|	김태수	|	최초 생성
 */
@Service
@RequiredArgsConstructor
public class StaffThesisServiceImpl implements StaffThesisService {

	private final StaffThesisMapper staffThesisMapper;
	
	@Override
	public List<ThesisVO> waitThesisList() {
		Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("status", "대기");
		return staffThesisMapper.selectThesisList(null);
	}

	@Override
	public List<ThesisVO> thesisList(String status) {
		Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("status", status);
		return staffThesisMapper.selectThesisList(null);
	}
	
	@Override
    @Transactional
    public int approveThesis(String thesisNo) {
        ThesisVO thesisVO = new ThesisVO();
        thesisVO.setThesisNo(thesisNo);
        thesisVO.setStatus("승인"); 
        thesisVO.setRejReason(null); 
        return staffThesisMapper.appThesisStatus(thesisNo);
    }

    @Override
    @Transactional
    public int rejectThesis(String thesisNo, String rejReason) {
        ThesisVO thesisVO = new ThesisVO();
        thesisVO.setThesisNo(thesisNo);
        thesisVO.setStatus("반려"); 
        thesisVO.setRejReason(rejReason); 
        return staffThesisMapper.rejThesisStatus(thesisNo);
    }

}
