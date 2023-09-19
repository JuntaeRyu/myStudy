package com.ryu.app;

import lombok.Data;

@Data
public class BoardDTO {
	private int bid;	//pk
	private String mid;	//fk
	private String content;
}
