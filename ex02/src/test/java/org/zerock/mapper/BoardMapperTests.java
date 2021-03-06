package org.zerock.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	private static final Logger logger = LoggerFactory.getLogger(BoardMapperTests.class);
	@Autowired
	private BoardMapper mapper;
	
	@Test 
	public void testGetList() {
		mapper.getList().forEach(board->logger.info(""+board));
	}
	
	@Test 
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
//		mapper.insert(board);
		mapper.insertSelectKey(board);
		
		logger.info(""+board);
	}
	
	@Test 
	public void testRead() {
		BoardVO board = mapper.read(3);
		
		logger.info(""+board);
	}
	
	@Test 
	public void testDelete() {		
	//	mapper.delete(3);
	}
	
	@Test 
	public void testUpdate() {		
		BoardVO board = new BoardVO();
		board.setTitle("수정 제목입니다.");
		board.setContent("수정 내용입니다.");
		board.setBno(4);
		mapper.update(board);
	}
}
