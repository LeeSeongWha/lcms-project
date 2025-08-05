package kr.or.ddit.pfcp.common.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class StaffVO extends UserVO {
    private Integer rnum;

    @NotBlank(groups = UpdateGroup.class)
    private String userNo;

    private String staffDepartment;
    private String staffPosition;
    private String staffHiredate;
    private String staffRdate;

    private String keyword;
    private String searchType;

    // transient 필드들
    private transient TypeVO type;

    // 연관 객체 (필요 시 추가)
    private transient DepartmentVO department;
    private transient CollegeVO college;

    public StaffVO(
        String userNo, String userPass, String userName, String gender,
        String userRegno1, String userRegno2, String userTel, String userZip,
        String userAdd1, String userAdd2, String userEmail, String bankCd,
        String userRole, String userBankno, String fileRefNo,
        MultipartFile uploadFile, AtchFileVO atchFile,
        DepartmentVO department, ProfessorVO professor,
        StaffVO staff, StudentVO student,
        String staffDepartment, String staffPosition, String staffHiredate
    ) {
        super(userNo, userPass, userName, gender, userRegno1, userRegno2,
              userTel, userZip, userAdd1, userAdd2, userEmail,
              bankCd, userRole, userBankno, fileRefNo, uploadFile,
              atchFile, department, professor, staff, student);
        this.staffDepartment = staffDepartment;
        this.staffPosition = staffPosition;
        this.staffHiredate = staffHiredate;
    }

    public UserVO getUser() {
        return this; // 본인이 UserVO임
    }
}
