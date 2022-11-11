package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 모델 (데이타)를 뷰페이지로 전송
 * 
 *  1. ModelAndView
 *  	-addObject()
 *  2. Model ( 호출함수의 인자에 선언만 하기) 	
 *  	-setAttribute()
 *  
 */
@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@RequestMapping("/modelandview0")
	public ModelAndView test() {
		System.out.println("1");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/void");
		mv.addObject("greeting","오늘행복");
		mv.addObject("test","22");
		return mv;
	}
	
	@RequestMapping("/string.do")
	public String test2(Model m) {
		m.addAttribute("greeting", "오늘행복");
		m.addAttribute("test", "테스트임");
		return "review/void";
	}
	
	@RequestMapping("/void.do")	
	public void test3() {
		System.out.println("3");
	}

}
