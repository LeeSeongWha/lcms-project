package kr.or.ddit.login;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestAuthVO implements Serializable{
  
  @NotBlank(message = "아이디를 입력해주세요.")
  @Size(min = 3, max = 20, message = "아이디는 3자 이상 20자 이하로 입력해주세요.")
  private String username;
  
  @NotBlank(message = "비밀번호를 입력해주세요.")
  @Size(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하로 입력해주세요.")
  private String password;
}
