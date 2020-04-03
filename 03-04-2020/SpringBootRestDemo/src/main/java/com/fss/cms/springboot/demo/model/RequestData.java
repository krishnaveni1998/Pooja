package com.fss.cms.springboot.demo.model;

import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;

@io.swagger.annotations.ApiModel
public class RequestData {
	@NotNull(message="id is mandate")
@ApiModelProperty("input is identity")
	String id;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}
}
