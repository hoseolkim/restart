package kr.or.ddit.vo;

import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.validate.grouphint.DeleteGroup;
import kr.or.ddit.validate.grouphint.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "lecCd")
public class LectureVO {
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	@Size(max = 30,groups = {Default.class,DeleteGroup.class})
	private String lecCd;
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	@Size(min = 5, max = 5,groups = {Default.class,DeleteGroup.class})
	private String proCd;
	@NotBlank(groups = InsertGroup.class)
	@Size(min = 8, max = 8,groups = InsertGroup.class)
	private String subCd;
	@NotBlank
	@Pattern(regexp = "\\d{4}-\\d{4}")
	private String lecTime;
	@NotBlank
	@Size(max = 10)
	private String lecRoom;
	@NotBlank
	@Min(10)
	@Max(100)
	private Integer lecPerson;
	@Size(max = 1)
	private String lecWeek;
	
	private String weeks;
	
	// 현재 수강인원 표시용
	private int currPerson;
	
	private Set<ClassVO> classVOSet;
	
	// 1:1 관계
	private ProfessorVO professorVO;
	private SubjectVO subjectVO;
}
