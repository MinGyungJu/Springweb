package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("getBoardList.do")
	public void getBoardList(String searchCondition, String searchKeyword, Model m) {
		System.out.println("searchContion : "+ searchCondition);
		System.out.println("searchKeyword : "+ searchKeyword);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<BoardVO> list = boardService.getBoardList(map);
		m.addAttribute("boardList", list);
	}

	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO boardVO) {
//		System.out.println(boardVO.getTitle());//confirmation
		boardService.insertBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
//		System.out.println(boardVO.getTitle());//confirmation
		boardService.updateBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO boardVO) {
//		System.out.println(boardVO.getTitle());//confirmation
		boardService.deleteBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO vo, Model m) {
		m.addAttribute("board",boardService.getBoard(vo));
	}
}
