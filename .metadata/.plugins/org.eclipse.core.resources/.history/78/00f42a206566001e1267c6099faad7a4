package kr.or.ddit.vo;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.validate.grouphint.DeleteGroup;
import kr.or.ddit.validate.grouphint.InsertGroup;
import kr.or.ddit.validate.grouphint.LoginGroup;
import kr.or.ddit.validate.grouphint.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "stdNo")
public class StudentVO {
	@NotBlank(groups = {UpdateGroup.class, DeleteGroup.class,LoginGroup.class})
	@Size(min = 10 , max = 10, groups = {UpdateGroup.class,DeleteGroup.class,LoginGroup.class})
	@Pattern(regexp = "\\d{2}[A-Z]{2}\\d{6}", groups = {UpdateGroup.class,DeleteGroup.class,LoginGroup.class},message = "학번 형식이 맞지 않습니다!")
	private String stdNo;
	@NotBlank(groups = InsertGroup.class)
	@Size(max = 10)
	private String stdName;
	@NotBlank(groups = InsertGroup.class)
	@Pattern(regexp = "\\d{6}-\\d{7}",groups = InsertGroup.class)
	private String stdId;
	@NotBlank
	@Pattern(regexp = "010-\\d{3,4}-\\d{4}")
	private String stdTelno;
	@NotBlank
	@Size(max = 25)
	private String stdAdd;
	@NotBlank
	@Size(min = 5 , max = 5)
	private String proCd;
	
	// 1:1 관계
	private ProfessorVO proVO;
	
	// 1:N 관계
	// 해당 학생이 수강하는 과목의 정보가 담긴 ClassVO Set
	private Set<ClassVO> classSet;
}
