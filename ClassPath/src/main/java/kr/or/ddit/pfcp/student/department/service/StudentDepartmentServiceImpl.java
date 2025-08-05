package kr.or.ddit.pfcp.student.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.or.ddit.pfcp.student.department.mapper.StudentDepartmentMapper;

@Service
public class StudentDepartmentServiceImpl implements StudentDepartmentService {
  
  @Autowired
  StudentDepartmentMapper studentDepartmentMapper;

  @Override
  public String readStudentDepartmentName(String userNo) {
    return studentDepartmentMapper.departmentName(userNo);
  }
}
