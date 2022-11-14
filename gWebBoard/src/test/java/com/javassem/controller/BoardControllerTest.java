//package com.javassem.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.web.context.WebApplicationContext;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration({
//	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
//	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class BoardControllerTest {
//	
//	private WebApplicationContext context;
//	
//	private MockMvc mockMvc; // Mock : 모조품(테스트를 하기 위한 모조품 구조)
//	
//	@Autowired
//	BoardController boardController;
//
//	@before
//	public void initMockMvc() {
//		mockMvc = MockMvcBuilder.standaloneSetup(boardController).build();
//	}
//	
//	@Test
//	public void test() {
////		System.out.println("테스트확인");
//		mockMvc.perform(get("/test.do"))
//		 		.andDo(print())
//		 		.andExpect(status().isOk());
//	}
//}
