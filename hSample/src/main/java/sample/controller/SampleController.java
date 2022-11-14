package sample.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.service.SampleService;
import sample.vo.EmpVO;

@Controller
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping("sample.do")
	public String sample(Model model) {
		model.addAttribute("time", sampleService.getTime());
		return "sample";
	}
	
	@RequestMapping("empSelect.do")
	public String empSelect(Model m) {
		List<EmpVO> list = sampleService.empselect();
		m.addAttribute("result", list);
		return "empSelect";
	}
	
	@RequestMapping("empDept.do")
	public void empDept(Model m) {
		List<HashMap> result = sampleService.empDept();
		m.addAttribute("result",result);
		for(HashMap map : result) {
			System.out.println(map);
		}
	}
	
}

/*
 * 뷰페이지지정 방식
 * 1. ModealANdView 리턴
 * 2. String 리턴
 * 3. void 인 경우 자동으로 요청명과 동일페이지
 */
