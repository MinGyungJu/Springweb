package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myclass.model.MemberVO;

@Controller
public class controller1 {
	
	@RequestMapping("param*.do")
	public String test(MemberVO vo) {
		System.out.println("가동");
		return "param";
	}
}
