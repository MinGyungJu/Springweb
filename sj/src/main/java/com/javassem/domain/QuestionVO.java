package com.javassem.domain;

import lombok.Data;

@Data
public class QuestionVO {

	private int qno;
	private int number;
	private String qname;
	private String qmessage;
	private String regdate;
	private int cnt;

}
