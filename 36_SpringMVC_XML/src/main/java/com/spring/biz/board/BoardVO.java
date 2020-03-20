package com.spring.biz.board;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

@XmlAccessorType(XmlAccessType.FIELD)
public class BoardVO {
	@XmlAttribute //엘리먼트가 아닌 속성으로 만들기
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate; //sql패키지에 있는 Date 타입은 기본생성자 없어 객체 생성이 안됨, util 패키지로 바꿔줄것 
	private int cnt;
	
	//검색 조건용 필드 추가
	@XmlTransient //XML 변환 제외 처리(@JsonIgnore처럼!!! 대신 필드에다가!!)
	private String searchCondition;
	@XmlTransient//XML 변환 제외 처리
	private String searchKeyword;
	
	//파일 업로드용 필드 추가
	@XmlTransient//XML 변환 제외 처리
	private MultipartFile uploadFile;
	
	
	public BoardVO() {
		super();
	}
	
	

	public BoardVO(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}



	public BoardVO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}



	public BoardVO(int seq, String title, String writer, String content, Date regdate, int cnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
	}



	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}


	
	//검색 조건용===============================
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
	
	//파일업로드용===============================
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
	
}
