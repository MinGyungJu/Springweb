package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("getBoardList.do")
	public void getBoadrList(String searchCondition, String searchKeyword,Model m) {
		System.out.println("searchCondition : "+ searchCondition);
		System.out.println("searchKeyword : "+  searchKeyword);
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<BoardVO>list = boardService.getBoardList(map);
		m.addAttribute("boardList",list);
	}
	
	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}
	
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO boardvo) {
		System.out.println(boardvo.getContent());
		boardService.insertBoard(boardvo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO board, Model m) {
		m.addAttribute("board", boardService.getBoard(board));
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO board, Model m) {
		boardService.updateBoard(board);
		m.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	

}
