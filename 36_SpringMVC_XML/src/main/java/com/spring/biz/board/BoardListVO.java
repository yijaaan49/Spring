package com.spring.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/* @XmlRootElement(name="boardList")의 의미
<boardList>
	<board>
		<seq>1</seq>
		<title>제목</title>
		<writer>작성자</writer>
		...
	</board>
	<board>
		<seq>2</seq>
		<title>제목2</title>
		<writer>작성자2</writer>
		...
	</board>
</boardList>

*/
@XmlRootElement(name="boardList")
@XmlAccessorType(XmlAccessType.FIELD) //XML 변환 시 필드를 엘리먼트로 설정하여 사용
public class BoardListVO {
	
	@XmlElement(name="board") //엘리먼트(요소)의 태그명 지정
	private List<BoardVO> boardList;

	
	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
	
}
