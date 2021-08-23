package org.zerock.service;

import java.util.ArrayList;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	//	게시판 글쓰기(register)
	public void register(BoardVO board);
	//	게시판 상세 페이지(get)
	public BoardVO get(int bno);
	//	게시판 글수정(modify)
	public boolean modify(BoardVO board);
	//	게시판 글삭제(remove)
	public boolean remove(int bno);
	//	게시판 글목록 리스트(getList)
	public ArrayList<BoardVO> getList();	
	// 	게시판 글목록 리스트+페이징
	public ArrayList<BoardVO> getListWithPaging(Criteria cri);
	// 	게시판 글목록 리스트+페이징 처리 전체 데이타
	public int getTotalCount(Criteria cri);
	//	게시판 상세페이지의 파일 업로드한 이미지 처리
	public ArrayList<BoardAttachVO> getAttachList(int bno);
}
