package com.javassem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("user")
public class MemberController {
	
	@Autowired	
	private MemberService memberService;

	@RequestMapping("{url}.do")
	public String userJoin(@PathVariable String url) {
		System.out.println("userJoin 확인");
		return "/user/"+url;
	}
	
	/*
	 *  요청 : /user/userInsert.do
	 *  뷰페이지 : user/userJoing_ok.jsp
	 */
	
	@RequestMapping("userInsert.do")
	public ModelAndView userInsert(MemberVO vo) {
		System.out.println(vo.getUserName());
		
		int result = memberService.userInsert(vo);
		String message = "가입되지 않았습니다";
		if(result==1) message = vo.getUserName() + "가입을 축하합니다";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin_ok");
		mv.addObject("message",message);
		return mv;
	}
	
	@RequestMapping("login.do")
	//***********************************
	// 세션 사용 -> 인자에 HttpSession 변수 선언
	public String login(MemberVO vo, HttpSession session) {
		MemberVO result = memberService.idCheck_Login(vo);
		if(result==null || result.getUserId()==null) {
			return "/user/userLogin";
		}else {
			//로그인 성공
			//세션에 저장
			session.setAttribute("login", vo.getUserId());
			return "/user/login_ok";
		}
	}
	@RequestMapping("idCheck.do")
	//******************************
	// 일반 요청함수에서 STring 리턴 : 뷰페이지 지정
	// 이 요청에 ajax 통신에 의해 값을 전송해야 함
	@ResponseBody
	public String checkId(MemberVO vo) {
		System.out.println("idCheck.do 요청 :"+ vo.getUserId());
		MemberVO result = memberService.idCheck_Login(vo);
		String message = "사용가능한 아이디입니다 ";
		if(result != null) message = "중복된 아이디가 있습니다.";
		
		return message;
	}
	
}
