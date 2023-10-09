package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.validate.grouphint.DeleteGroup;
import kr.or.ddit.validate.grouphint.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"cnsDate","stdNo","proCd"})
public class CounselVO implements Serializable{
	@NotBlank(groups = {Default.class,DeleteGroup.class})
	private LocalDate cnsDate;
	@NotBlank(groups = InsertGroup.class)
	@Size(min = 10, max = 10,groups = InsertGroup.class)
	private String stdNo;
	@NotBlank(groups = InsertGroup.class)
	@Size(min = 5, max = 5,groups = InsertGroup.class)
	private String proCd;
	@NotBlank
	@Size(max = 1000)
	private String cnsRemark;
}