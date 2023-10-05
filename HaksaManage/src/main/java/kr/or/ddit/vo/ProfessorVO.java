package kr.or.ddit.vo;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.validate.grouphint.DeleteGroup;
import kr.or.ddit.validate.grouphint.InsertGroup;
import kr.or.ddit.validate.grouphint.LoginGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "proCd")
public class ProfessorVO {
	private int rnum;
	
	@NotBlank(groups = {Default.class,DeleteGroup.class,LoginGroup.class})
	@Size(min = 5 , max = 5,groups = {Default.class,DeleteGroup.class,LoginGroup.class})
	@Pattern(regexp = "\\d{2}[A-Z]\\d{2}",groups = {Default.class,DeleteGroup.class,LoginGroup.class},message = "코드 형식이 맞지 않습니다!")
	private String proCd;
	@NotBlank(groups = InsertGroup.class)
	@Size(max = 10,groups = InsertGroup.class)
	private String proName;
	@NotBlank(groups = InsertGroup.class)
	@Size(max = 30,groups = InsertGroup.class)
	private String proMajor;
	@Size(max = 3)
	private String proDeptno;
	@NotBlank
	@Pattern(regexp = "010-\\d{3,4}-\\d{4}")
	private String proTelno;
	
	// 1:N 관계
	// 해당 교수가 강의하는 강좌 정보가 담긴 LectureVO Set
	private Set<LectureVO> lectureSet;
	// 담당교수로 맡고있는 학생 목록
	private Set<StudentVO> studentSet;
	
	
}
