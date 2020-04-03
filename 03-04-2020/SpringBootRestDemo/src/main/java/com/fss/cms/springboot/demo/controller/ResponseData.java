package com.fss.cms.springboot.demo.controller;

import com.wordnik.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;

@ApiModel("This is Response data ")
public class ResponseData {
	@ApiModelProperty("name of  person")
	String name;
	@ApiModelProperty("email of  person")
	String email;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
String mobile;
}
