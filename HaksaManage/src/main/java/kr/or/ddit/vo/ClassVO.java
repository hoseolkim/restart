package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.validate.grouphint.DeleteGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"stdNo","lecCd"})
public class ClassVO implements Serializable{
	private Integer rnum;
	
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	@Size(min = 10, max = 10,groups = {Default.class,DeleteGroup.class})
	private String stdNo;
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	@Size(max = 30,groups = {Default.class,DeleteGroup.class})
	private String lecCd;
	@Min(0)
	@Max(100)
	private Integer clsScore;
	
	// 점수에 알맞는 학점을 표현하기 위한 필드
	private String scoreGrade;
	
	private StudentVO studentVO;
	
	// 1:1 관계
	private LectureVO lectureVO;
}
