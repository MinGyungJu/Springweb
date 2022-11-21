package com.javassem.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javassem.domain.AnswerVO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ListOrderVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;
import com.javassem.domain.QuestionVO;
import com.javassem.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// ----------------------------------manager
	// ---manager product

	// func: manager inserting beans
	@RequestMapping(value = "addProduct.do")
	public String addProduct(ProductVO vo) {
		System.out.println("=>UserController.java::addProduct.do");
		userService.insertProduct(vo);
		return "redirect:shop_m.do";
	}

	// func: manager inserting goods
	@RequestMapping(value = "addProduct2.do")
	public String addProduct2(ProductVO vo) {
		System.out.println("=>UserController.java::addProduct2.do");
		userService.insertProduct2(vo);
		return "redirect:shop2_m.do";
	}

	// func: manager modifying goods or beans
	@RequestMapping(value = "modifyProduct.do")
	public String modifyProduct(ProductVO vo) {
		System.out.println("=>UserController.java::modifyProduct.do");
		userService.modifyProduct(vo);
		return "redirect:shop_m.do";
	}

	// func: manager deleting goods or beans
	@RequestMapping(value = "deleteProduct.do")
	public String deleteProduct(ProductVO vo) {
		System.out.println("=>UserController.java::deleteProduct.do");
		userService.deleteProduct(vo);
		File file = new File(
				"D:\\springspace\\springweb\\sj\\src\\main\\webapp\\resources\\assets\\img\\products\\" + vo.getImg());
		if (file.exists()) {
			file.delete();
		}
		return "redirect:shop_m.do";
	}
	// ---manager product end

	// ---manager contact
	@RequestMapping(value = "insertAnswer.do")
	public String insertAnswer(AnswerVO vo) {
		System.out.println("=>UserController.java::insertAnswer.do");
		userService.insertAnswer(vo);
		return "redirect:contact_m.do";
	}
	// ---manager contact end
	// ---manager login

	// func: registering new manager to db
	@RequestMapping(value = "insertManager.do", method = RequestMethod.POST)
	public String insertManager(ManagerVO vo) {
		System.out.println("=>UserController.java::insertManager.do");
		if (userService.checkMId(vo) != null) {
			// id exists in DB. Make customer input different id
			return "redirect:registration_m_incomplete.do";
		}
		int insertResult = userService.insertManager(vo);
		System.out.println("  MANAGER INSERTED::" + insertResult);
		return "redirect:registration_m_complete.do";
	}

	// func: checking login for manager
	@RequestMapping(value = "loginManager.do")
	public String loginManager(ManagerVO vo, HttpSession session) {
		System.out.println("=>UserController.java::loginManager.do");
		ManagerVO loginResult = userService.loginManager(vo);
		if (loginResult != null) { // login success!
			session.setAttribute("loginMno", loginResult.getMno());
			session.setAttribute("loginName", loginResult.getName());
			session.setAttribute("loginGender", loginResult.getGender());
			session.setAttribute("loginId", loginResult.getId());
			session.setAttribute("loginPw", loginResult.getPw());
			session.setAttribute("loginTel", loginResult.getTel());
			session.setAttribute("loginEmail", loginResult.getEmail());
			session.setAttribute("loginAddr", loginResult.getAddr());
			return "redirect:index_m.do";
		}
		return "redirect:login_m.do";
	}

	// func: logging out for manager
	@RequestMapping(value = "logout_m.do")
	public String logout_m(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:index_m.do";
	}

	// ---manager login end
	@RequestMapping("contact_m.do")
	public void contact_m(Model m) {
		List<ListOrderVO> list = userService.getQuestionList();
		m.addAttribute("questionList", list);
	}

	@RequestMapping("login_m")
	public void login_m() {

	}

	@RequestMapping("index_m.do")
	public void index_m() {

	}

	@RequestMapping("registration_m_complete.do")
	public void registration_m_complete() {

	}

	@RequestMapping("registration_m_incomplete.do")
	public void registration_m_incomplete() {

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
	public void shop2_m(Model m) {
		List<ProductVO> list = userService.getProductList2();
		m.addAttribute("productList2", list);
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

	// ----------------------------------manager end

	// ----------------------------------user
	// ---user product
	@RequestMapping(value = "removeCart.do")
	public String removeCart(ListOrderVO vo) {
		userService.removeCart(vo);
		return "redirect:cart.do?cno="+vo.getCno();
		
	}
	
	@RequestMapping(value = "addCart.do")
	public String addCart(ListOrderVO vo , Model m) {
		System.out.println("=>UserController.java::addCart.do");
		ListOrderVO exists = userService.selectCart(vo); //if pno cno exists in the cart
		int req = 0;
		if(exists == null)
			req = userService.insertCart(vo);
		else
			req = userService.updateCart(vo);
		
		if (req == 1) {
			List<HashMap> list = userService.getCartList(vo);		// selectItemToCart
			 m.addAttribute("getCartList", list);		
			 System.out.println(list.size());
			 
			 return "cart";
		} else {
			return "404.do";
		}
	}
	// ---user product end

	// ---user contact
	@RequestMapping(value = "insertQustion.do")
	public String insertQustion(QuestionVO vo) {
		System.out.println("=>UserController.java::insertQustion.do");
		int result = userService.insertQustion(vo);
		if (result == 1)
			return "redirect:contact_complete.do";
		return "redirect:contact.do";
	}
	// ---user contact end

	// ---user login
	// func: registration for new customer
	@RequestMapping(value = "insertCustomer.do", method = RequestMethod.POST)
	public String insertCustomer(CustomerVO vo) {
		System.out.println("=>UserController.java::insertCustomer.do");
		if (userService.checkId(vo) != null) {
			// id exists in DB. Make customer input different id
			return "redirect:registration_incomplete.do";
		}
		int insertResult = userService.insertCustomer(vo);
		System.out.println("  USER INSERTED::" + insertResult);
		return "redirect:registration_complete.do";
	}

	// func: checking login for customer
	@RequestMapping(value = "loginCustomer.do")
	public String loginCustomer(CustomerVO vo, HttpSession session) {
		System.out.println("=>UserController.java::loginCustomer.do");
		CustomerVO loginResult = userService.loginCustomer(vo);
		if (loginResult != null) { // login success!
			session.setAttribute("loginCno", loginResult.getCno());
			session.setAttribute("loginName", loginResult.getName());
			session.setAttribute("loginGender", loginResult.getGender());
			session.setAttribute("loginId", loginResult.getId());
			session.setAttribute("loginPw", loginResult.getPw());
			session.setAttribute("loginTel", loginResult.getTel());
			session.setAttribute("loginEmail", loginResult.getEmail());
			session.setAttribute("loginAddr", loginResult.getAddr());
			return "redirect:index.do";
		}
		return "redirect:login.do";
	}

	// func: logging out customer
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
	public void cart(ListOrderVO vo, Model m) {
		List<HashMap> list = userService.getCartList(vo);		// selectItemToCart
		 m.addAttribute("getCartList", list);	
		 System.out.println(list.size());
	}

	@RequestMapping("checkout.do")
	public void checkout() {

	}

	@RequestMapping("contact_complete.do")
	public void contact_complete() {

	}

	@RequestMapping("contact.do")
	public void contact() {

	}

	@RequestMapping("index.do")
	public void index(Model m) {
		List<ProductVO> list = userService.getProductList();
		m.addAttribute("productList", list);
	}

	@RequestMapping("login.do")
	public void login() {

	}

	@RequestMapping("mypage.do")
	public void mypage( Model m, HttpSession session) {
		//CustomerVO cvo, QuestionVO qvo,
		//System.out.println("cvo:"+cvo);
		//System.out.println("qvo:"+qvo);
		Integer cno = 0;
		Object obj = session.getAttribute("loginCno");
		if( obj != null ) cno = (Integer)obj;	
		
		List<HashMap> list = userService.getQuestionAnswer(cno);
		m.addAttribute("questionAnswerList", list);
		/*
		 * for(HashMap map: list) { System.out.println(map); }
		 */
	}

	@RequestMapping("registration_complete.do")
	public void registration_complete() {

	}

	@RequestMapping("registration_incomplete.do")
	public void registration_incomplete() {

	}

	@RequestMapping("pay_complete.do")
	public void pay_complete() {

	}

	@RequestMapping("registration")
	public void registration() {

	}

	@RequestMapping("shop.do")
	public void shop(Model m) {
		List<ProductVO> list = userService.getProductList();
		m.addAttribute("productList", list);
	}

	@RequestMapping("shop2.do")
	public void shop2(Model m) {
		List<ProductVO> list = userService.getProductList2();
		m.addAttribute("productList2", list);
	}

	@RequestMapping("single_product.do")
	public void single_product() {

	}
	// ----------------------------------user end

}
