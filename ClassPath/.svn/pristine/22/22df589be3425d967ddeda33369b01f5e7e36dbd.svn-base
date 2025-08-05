package kr.or.ddit.pfcp.staff.college.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.pfcp.common.vo.DGRRequestVO;
import kr.or.ddit.pfcp.common.vo.DepartmentVO;
import kr.or.ddit.pfcp.staff.college.mapper.DGRRequestMapper;
import kr.or.ddit.pfcp.staff.college.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	private final DepartmentMapper mapper;
	private final DGRRequestMapper dgrReqMapper;
	
	private static final Map<String, String> departmentDetailUrls = new HashMap<>();
    static {
        // 여기에 각 학과 번호와 연결될 컨트롤러 URL을 정확히 지정
        // 각 URL은 해당 JSP 파일을 렌더링하는 컨트롤러 엔드포인트
        // departmentNo를 파라미터로 전달하여 해당 JSP 내부에서 학과 정보를 조회
        departmentDetailUrls.put("DP001", "/staff/college/computerPage.do?departmentNo=DP001");
        departmentDetailUrls.put("DP002", "/staff/college/departmentDetail.do?departmentNo=DP002");
        // departmentDetailUrls.put("DP003", "/staff/college/mathPage.do?departmentNo=DP003");
        // ...
    }

    @Override
    public List<DepartmentVO> readDepartmentListByCollegeNo(String collegeNo) {
        return mapper.selectDepartmentListByCollegeNo(collegeNo);
    }
	
	@Override
	public DepartmentVO readDepartment(String departmentNo) {
		return mapper.selectDepartment(departmentNo);
	}
	
	@Override
	public List<DepartmentVO> readDepartmentList() {
		List<DepartmentVO> departmentList = mapper.selectAllDepartmentList();
		
		return departmentList;
	}
	
	@Override
	@Transactional
	public int createDepartment(DepartmentVO department) {
		
	    DGRRequestVO dgrReq = department.getDgrReqVO();

	    if (dgrReq == null) {
	        throw new IllegalArgumentException("졸업요건 정보(dgrReqVO)가 DepartmentVO 내에 존재하지 않습니다.");
	    }
	    
	    int dgrReqResult = dgrReqMapper.insertDGRRequest(dgrReq);
	    
	    if (dgrReqResult == 0) {
	        throw new RuntimeException("졸업요건 데이터 삽입 실패");
	    }

	    department.setDgrNo(dgrReq.getDgrNo());
	    
	    return mapper.insertDepartment(department); // departmentMapper 사용
	}


	@Override
	public void modifyDepartment(DepartmentVO department) {
		mapper.updateDepartment(department);
	}

	@Override
	public void disableDepartment(String departmentNo) {
		mapper.updateDepartmentDelYN(departmentNo);
	}
	
	@Override
	public List<DepartmentVO> selectAllDepartmentList(String collegeNo) {
		return mapper.selectAllDepartmentList();
	}

}
