package com.javassem.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int b_id;		// 게시글번호
	private String b_name;	// 작성자
	private String b_email;	// 이메일
	private String b_title;	// 제목
	private String b_content;	// 내용	
	private String b_pwd;	// 비밀번호
	private String b_date;	// 등록일
	private int b_count;	// 조회수
	private String b_fname;		// 파일명
	private String b_realfname; // 저장된 파일이름
	private long b_fsize;		// 파일크기
	
	//*************************************************
	MultipartFile file;  //*********************************
						 // 화면에서 type='file' name ='file' 이라서 변수명이 file이여야함
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		
		//업로드 파일이 있는경우
		if( !file.isEmpty()) {
			
			this.b_fname = file.getOriginalFilename();
			this.b_fsize = file.getSize();
			
			UUID uuid = UUID.randomUUID();
			this.b_realfname = uuid.toString()+"_"+b_fname;
			
			
			File f = new File("D:\\springweb\\gWebBoard1\\src\\main\\webapp\\resources\\upload\\"+b_realfname);
			//파일저장위치를 추후에 서버경로를 얻어서 상대경로로 수정하기
			
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
	public int getB_id() {
		return b_id;
	}
	
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_count() {
		return b_count;
	}
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	public String getB_realfname() {
		return b_realfname;
	}
	public void setB_realfname(String b_realfname) {
		this.b_realfname = b_realfname;
	}
	public String getB_fname() {
		return b_fname;
	}
	public void setB_fname(String b_fname) {
		this.b_fname = b_fname;
	}
	public long getB_fsize() {
		return b_fsize;
	}
	public void setB_fsize(long b_fsize) {
		this.b_fsize = b_fsize;
	}

	

}