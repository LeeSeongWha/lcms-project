package kr.or.ddit.common.controller;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.or.ddit.pfcp.common.mapper.SemesterMapper;
import kr.or.ddit.pfcp.common.vo.UserVO;
import kr.or.ddit.pfcp.staff.schedule.service.StaffScheduleService;
import kr.or.ddit.pfcp.student.eclass.assignement.service.AssignSubmissionService;
import kr.or.ddit.pfcp.student.lecture.enroll.service.LectureEnrService;
import kr.or.ddit.pfcp.student.lecture.grade.service.StudentGradeService;
import kr.or.ddit.pfcp.student.notice.service.StudentNoticeService;
import kr.or.ddit.security.auth.UserVOWrapper;

@Controller
public class IndexController {

  @Autowired
  AssignSubmissionService assignSubmissionService;

  @Autowired
  LectureEnrService lectureEnrService;

  @Autowired
  StaffScheduleService staffScheduleService;

  @Autowired
  StudentNoticeService studentNoticeService;
  
  @Autowired
  StudentGradeService studentGradeService;
  
  @Autowired
  SemesterMapper semesterMapper;

  @GetMapping("/")
  public String index(Model model, Authentication authentication) {
    UserVO user = null;
    if(authentication == null) {
      return "redirect:/login";
    }
    
    if (authentication != null && authentication.getPrincipal() instanceof UserVOWrapper wrapper
        && authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_STD"))) {
      user = wrapper.getRealUser(); // getUserVO는 UserVOWrapper에 구현된 메서드라고 가정
      model.addAttribute("student", user);

      model.addAttribute("currentSemester", semesterMapper.currentSemester());
      model.addAttribute("currentDate", new Date());
      model.addAttribute("assignmentCount",
          assignSubmissionService.readRequiredAssignmentCount(user.getUserNo()));
      model.addAttribute("academicStatus", studentGradeService.calculateAcademicStatus(user.getUserNo()));
      model.addAttribute("currentCourses", lectureEnrService.getMyEnrollList(user.getUserNo()));
      model.addAttribute("todaySchedule",
          staffScheduleService.getScheduleList(Map.of("userNo", user.getUserNo())));

      model.addAttribute("recentNotices", studentNoticeService.readNoticeList());
      return "index";
    } else {
      return "redirect:/schedule.do";
    }
    
  }
}
