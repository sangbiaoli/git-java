package com.sangbill.advanced.claw;

public class SysArea {
	private String name;
	private String areaCode;
	private int level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public SysArea(String name, String areaCode, int level) {
		this.name = name;
		this.areaCode = areaCode;
		this.level = level;
	}
	@Override
	public String toString() {
		if(level == 0){
			return String.format("%s(%s)", name,areaCode);			
		}else if(level == 1){
			return String.format("\t%s(%s)", name,areaCode);			
		}else if(level == 2){
			return String.format("\t\t%s(%s)", name,areaCode);			
		}else if(level == 3){
			return String.format("\t\t\t%s(%s)", name,areaCode);			
		}else{
			return String.format("\t\t\t\t%s(%s)", name,areaCode);			
		}
	}
	public String getSql() {
		return String.format("('%s', %s, '%s'),", name,level,areaCode);
	}
	
	
}
