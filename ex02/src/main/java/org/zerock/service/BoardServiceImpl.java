package org.zerock.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Transactional
	@Override	
	public void register(BoardVO board) {
		// 게시판 글쓰기
		logger.info("register :  "+board);
		mapper.insertSelectKey(board);
		
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> { 
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});		
	}

	@Override
	public BoardVO get(int bno) {
		// 게시판 상세 페이지
		return mapper.read(bno);		
	}

	@Override
	public boolean modify(BoardVO board) {
		// 게시판 글수정
		return mapper.update(board);		
	}

	@Override
	public boolean remove(int bno) {
		// 게시판 글삭제
		return mapper.delete(bno);		
	}

	@Override
	public ArrayList<BoardVO> getList() {
		// 게시판 글 목록 리스트
		return mapper.getList();		
	}

	@Override
	public ArrayList<BoardVO> getListWithPaging(Criteria cri) {
		// 게시판 글 목록 리스트+페이징
		// return mapper.getList(cri);
		return mapper.getListWithPaging(cri);
	}	
	
	@Override
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public ArrayList<BoardAttachVO> getAttachList(int bno) {
		logger.info("getAttachList : "+bno);
		return attachMapper.findByBno(bno);
	}
	
}
