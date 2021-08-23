package org.zerock.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTests.class);
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		logger.info(""+service);
		assertNotNull(service);
	}
	
	@Test	
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("서비스를 통한 제목 추가");
		board.setContent("서비스를 통한 내용 추가");
		board.setWriter("서비스를 통한 작성자");
		service.register(board);
		
		logger.info("게시물 번호 : "+board.getBno());
	}
	
}
