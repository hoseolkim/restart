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
@EqualsAndHashCode(of = "subCd")
public class SubjectVO implements Serializable{
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	@Size(min = 8,max = 8,groups = {Default.class,DeleteGroup.class})
	private String subCd;
	@NotBlank
	@Size(max = 15)
	private String subName;
	@NotBlank
	@Min(10)
	@Max(1)
	private Integer subGrade;
}
