package org.zerock.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;


@Controller
@RequestMapping(value="board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	// 글쓰기 화면
	@GetMapping(value="register")
	public void register() {
		logger.info("board/register");		
	}
	
	// 글쓰기 버튼 클릭
	@PostMapping(value="register")
	public String registerPost(BoardVO board) {
		logger.info("board/registerPost : "+board);
		
		if(board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> logger.info(""+attach));
		}
		
		service.register(board);
		return "redirect:/board/list";
	}
	
	// 리스트 화면
	@GetMapping(value="list")
	public void list(Criteria cri, Model model) {
		logger.info("board/list");
		int count = service.getTotalCount(cri);
	//	model.addAttribute("list",service.getList());		
		model.addAttribute("list",service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, count));
	}
	
	// 상세 화면
	@GetMapping(value="get")
	public void get(@RequestParam("bno") int bno, Model model) {
		logger.info("board/get");
		model.addAttribute("board",service.get(bno));		
	}
	
	// 글 수정
	@PostMapping(value="modify")
	public String modify(BoardVO board,RedirectAttributes rttr) {
		logger.info("board/modify");
		
		if(service.modify(board)) {
			rttr.addAttribute("result", "success");
			rttr.addAttribute("bno", board.getBno());
		}		
		return "redirect:/board/get";
	}
	
	// 글 삭제
	@PostMapping(value="remove")
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		logger.info("board/remove");		
		if(service.remove(bno)) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping(value="getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseBody
	public ResponseEntity<ArrayList<BoardAttachVO>> getAttachList(int bno){
		logger.info("getAttachList : "+bno);
		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}
}
