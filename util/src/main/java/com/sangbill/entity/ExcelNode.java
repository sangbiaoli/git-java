package com.sangbill.entity;

import java.lang.reflect.Field;

public class ExcelNode {
	private String chName;//中文名
	private String enName;//英文名
	private Field field;
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	
	
}
