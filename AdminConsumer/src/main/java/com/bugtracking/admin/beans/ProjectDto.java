package com.bugtracking.admin.beans;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Project Entity")
public class ProjectDto {
	@Min(value = 1, message = "minimum value must be 1")
	private long projId;
	@NotEmpty
	@ApiModelProperty("Project Name should not be empty")
	private String projname;
	private List<EmployeeDto> members;
	@NotEmpty
	@ApiModelProperty("Project status should not be empty")
	private String projstatus;

	public long getProjId() {
		return projId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}

	public List<EmployeeDto> getMembers() {
		return members;
	}

	public void setMembers(List<EmployeeDto> members) {
		this.members = members;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public String getProjstatus() {
		return projstatus;
	}

	public void setProjstatus(String projstatus) {
		this.projstatus = projstatus;
	}

	public ProjectDto() {

	}

	public ProjectDto(long projId, String projname, List<EmployeeDto> members, String projstatus) {
		super();
		this.projId = projId;
		this.projname = projname;
		this.members = members;
		this.projstatus = projstatus;
	}

}
