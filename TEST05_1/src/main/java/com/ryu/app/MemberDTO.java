package com.ryu.app;

import lombok.Data;

@Data
public class MemberDTO {
	private String mid;	//pk
	private String mpw;
	
	private String searchCondition;
	
}
