package com.ryu.app;

import lombok.Data;

@Data
public class VO {
	private String id;
	private String name;
	// getter, setter, toString을 만들어야하지만 lombok이 대신 해줌
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
