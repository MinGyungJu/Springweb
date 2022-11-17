package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javassem.domain.BoardVO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;
import com.javassem.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// ----------------------------------manager
	// ---manager product
	
	
	@RequestMapping(value = "addProduct.do")
	public String addProduct(ProductVO vo) {
		System.out.println("=>UserController.java::addProduct.do");
		userService.insertProduct(vo);
		return "redirect:shop_m.do";
	}

	@RequestMapping(value = "addProduct2.do")
	public String addProduct2(ProductVO vo) {
		System.out.println("=>UserController.java::addProduct2.do");
		userService.insertProduct2(vo);
		return "redirect:shop2_m.do";
	}

	@RequestMapping(value = "modifyProduct.do")
	public String modifyProduct(ProductVO vo) {
		System.out.println("=>UserController.java::modifyProduct.do");
		userService.modifyProduct(vo); 
		return "redirect:shop_m.do";
	}
	// ---manager product end

	// ---manager login
	@RequestMapping(value = "insertManager.do", method = RequestMethod.POST)
	public String insertManager(ManagerVO vo) {
		System.out.println("=>UserController.java::insertManager.do");
		if (userService.checkMId(vo) != null) {
			// id exists in DB. Make customer input different id
			return "redirect:registration_m.do";
		}
		int insertResult = userService.insertManager(vo);
		System.out.println("  MANAGER INSERTED::" + insertResult);
		return "redirect:login_m.do";
	}

	@RequestMapping(value = "loginManager.do")
	public String loginManager(ManagerVO vo, HttpSession session) {
		System.out.println("=>UserController.java::loginManager.do");
		ManagerVO loginResult = userService.loginManager(vo);
		if (loginResult != null) { // login success!
			session.setAttribute("loginId", vo.getId());
			session.setAttribute("loginAddr", vo.getAddr());
			return "redirect:index_m.do";
		}
		return "redirect:login_m.do";
	}

	@RequestMapping(value = "logout_m.do")
	public String logout_m(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:index_m.do";
	}

	// ---manager login end
	@RequestMapping("contact_m.do")
	public void contact_m() {

	}

	@RequestMapping("login_m")
	public void login_m() {

	}

	@RequestMapping("index_m.do")
	public void index_m() {

	}

	@RequestMapping("registration_m.do")
	public void registration_m() {

	}

	@RequestMapping("shop_m.do")
	public void shop_m(Model m) {
		List<ProductVO> list = userService.getProductList();
		m.addAttribute("productList", list);
	}

	@RequestMapping("shop2_m.do")
	public void shop2_m() {

	}

	@RequestMapping("single_product_m.do")
	public void singleProduct_m() {

	}

	@RequestMapping("single_product_add_m.do")
	public void single_product_add_m() {

	}

	@RequestMapping("single_product_add2_m.do")
	public void single_product_add2_m() {

	}

	@RequestMapping("single_product_modify_m.do")
	public void single_product_modify_m() {

	}
	
	@RequestMapping("delete.do")
	public String delete(ProductVO vo, Model m) {
		userService.delete(vo);
		return "redirect:index_m.do";
		
	}

	// ----------------------------------manager end

	// ----------------------------------user

	// ---user login
	@RequestMapping(value = "insertCustomer.do", method = RequestMethod.POST)
	public String insertCustomer(CustomerVO vo) {
		System.out.println("=>UserController.java::insertCustomer.do");
		if (userService.checkId(vo) != null) {
			// id exists in DB. Make customer input different id
			return "redirect:registration.do";
		}
		int insertResult = userService.insertCustomer(vo);
		System.out.println("  USER INSERTED::" + insertResult);
		return "redirect:login.do";
	}

	@RequestMapping(value = "loginCustomer.do")
	public String loginCustomer(CustomerVO vo, HttpSession session) {
		System.out.println("=>UserController.java::loginCustomer.do");
		CustomerVO loginResult = userService.loginCustomer(vo);
		if (loginResult != null) { // login success!
			session.setAttribute("loginId", vo.getId());
			session.setAttribute("loginAddr", vo.getAddr());
			return "redirect:index.do";
		}
		return "redirect:login.do";
	}

	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:index.do";
	}
	// ---user login end

	@RequestMapping("404.do")
	public void notfound() {

	}

	@RequestMapping("cart.do")
	public void cart() {

	}

	@RequestMapping("checkout.do")
	public void checkout() {

	}

	@RequestMapping("contact.do")
	public void contact() {

	}

	@RequestMapping("index.do")
	public void index() {

	}

	@RequestMapping("login.do")
	public void login() {

	}

	@RequestMapping("mypage.do")
	public void mypage() {

	}

	@RequestMapping("registration")
	public void registration() {

	}

	@RequestMapping("shop.do")
	public void shop() {

	}

	@RequestMapping("shop2.do")
	public void shop2() {

	}

	@RequestMapping("single_product.do")
	public void single_product() {

	}
	// ----------------------------------user end

}
