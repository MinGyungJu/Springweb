package com.javassem.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
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

	@RequestMapping("deleteOrder.do")
	public String deleteOrder(Integer lono) {
		userService.deleteOrders(lono);
		userService.deleteOrder(lono);
		return "redirect:index_m.do";
	}

	@RequestMapping("contact_m.do")
	public void contact_m(Model m) {
		List<ListOrderVO> list = userService.getQuestionList();
		m.addAttribute("questionList", list);
	}

	@RequestMapping("login_m")
	public void login_m() {

	}

	@RequestMapping("index_m.do")
	public void index_m(Model m) {
		List<HashMap> list = userService.getCustomersOrders();
		m.addAttribute("getCustomersOrders", list);
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

	@RequestMapping("single_product_addBeans_m.do")
	public void single_product_addBeans_m() {

	}

	@RequestMapping("single_product_addCapule_m.do")
	public void single_product_addCapsule_m() {

	}

	@RequestMapping("single_product_addDripbag_m.do")
	public void single_product_addDripbag_m() {

	}

	@RequestMapping("single_product_addExtraction_m.do")
	public void single_product_addExtraction_m() {

	}

	@RequestMapping("single_product_addGrinder_m.do")
	public void single_product_addGrinder_m() {

	}

	@RequestMapping("single_product_addCup_m.do")
	public void single_product_addCup_m() {

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
		return "redirect:cart.do?cno=" + vo.getCno();
	}

	@RequestMapping(value = "updateCart.do")
	public String updateCart(ListOrderVO vo) { // gets pno, cno, ocnt
		userService.updateCart(vo);
		return "redirect:cart.do?cno=" + vo.getCno();
	}

	@RequestMapping(value = "addCart.do")
	public String addCart(ListOrderVO vo, Model m) {
		System.out.println("=>UserController.java::addCart.do");
		ListOrderVO exists = userService.selectCart(vo); // if pno cno exists in the cart
		int req = 0;
		if (exists == null)
			req = userService.insertCart(vo);
		else
			req = userService.updateCart(vo);

		if (req == 1) {
			List<HashMap> list = userService.getCartList(vo); // selectItemToCart
			m.addAttribute("getCartList", list);

			return "redirect:cart.do?cno=" + vo.getCno();
		} else {
			return "redirect:404.do";
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
			logCustomer(" logged in at ", session);

			return "redirect:index.do";
		}
		return "redirect:login.do";
	}

	// func: logging out customer
	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		logCustomer(" logged out at ", session);
		session.invalidate();
		return "redirect:index.do";
	}

	// func: recording customer behavior into fileLog.txt
	public void logCustomer(String strToWrite, HttpSession session) {
		try {
			File myObj = new File("fileLog.txt");
			FileWriter myWriter = null;
			if (myObj.createNewFile()) {
				myWriter = new FileWriter("D:\\springspace\\springweb\\sj\\src\\main\\fileLog.txt");
				LocalDateTime now = LocalDateTime.now();
				myWriter.write("Customer " + session.getAttribute("loginCno") + strToWrite + String.valueOf(now));
				myWriter.write('\n');
			} else {
				// file already exists
				myWriter = new FileWriter("D:\\springspace\\springweb\\sj\\src\\main\\fileLog.txt", true);
				LocalDateTime now = LocalDateTime.now();
				myWriter.write("Customer " + session.getAttribute("loginCno") + strToWrite + String.valueOf(now));
				myWriter.write('\n');
			}
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// logCustomer
		// ---user login end\

	@RequestMapping("404.do")
	public void notfound() {

	}

	@RequestMapping("cart.do")
	public void cart(ListOrderVO vo, Model m) {
		List<HashMap> list = userService.getCartList(vo);
		m.addAttribute("getCartList", list);
	}

	@RequestMapping("checkout.do")
	public void checkout(ListOrderVO vo, Model m) {
		List<HashMap> list = userService.getCartList(vo);
		m.addAttribute("getCartList", list);
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
	public void mypage(Model m, HttpSession session) {
		// CustomerVO cvo, QuestionVO qvo,
		// System.out.println("cvo:"+cvo);
		// System.out.println("qvo:"+qvo);
		Integer cno = 0;
		Object obj = session.getAttribute("loginCno");
		if (obj != null)
			cno = (Integer) obj;
		List<HashMap> list1 = userService.getOrdersList(cno);
		m.addAttribute("OrdersList", list1);
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

	@RequestMapping("pay_incomplete.do")
	public void pay_incomplete() {

	}

	@RequestMapping("pay_complete.do")
	public void pay_complete() {

	}

	@RequestMapping("pay_mid_complete.do")
	public String pay_complete(String cno, String addr) {
		ListOrderVO vo = new ListOrderVO();
		vo.setCno(Integer.valueOf(cno));
		// cart
		List<HashMap> list = userService.getCartList(vo);
		// for cart items
		for (HashMap m : list) {
			// check if the stock is available
			int stock = userService.selectStock(Integer.valueOf(String.valueOf(m.get("PNO"))));
			int checkStock = stock - Integer.valueOf(String.valueOf(m.get("OCNT")));
			// no stock, add back values that were subtracted from stock
			if (checkStock < 0) {
				for (HashMap m3 : list) { // for cart items
					stock = userService.selectStock(Integer.valueOf(String.valueOf(m3.get("PNO"))));
					checkStock = stock - Integer.valueOf(String.valueOf(m3.get("OCNT")));
					if (checkStock < 0)
						break; // when you reach the part where stock is less than the ordered
					System.out.println("CHECKING STOCK : " + m3 + checkStock);
					HashMap map2 = new HashMap();
					map2.put("pno", m3.get("PNO"));
					map2.put("ocnt", m3.get("OCNT"));
					userService.increaseStock(map2);
				}
				return "redirect:pay_incomplete.do";
			} else {
				// if stock > order, decrease stock
				HashMap map2 = new HashMap();
				map2.put("pno", m.get("PNO"));
				map2.put("ocnt", m.get("OCNT"));
				userService.decreaseStock(map2);
			} //else
		} //for
		// making finished_order object
		int lono = userService.selectLono();
		HashMap map = new HashMap();
		map.put("cno", vo.getCno());
		map.put("addr", addr);
		map.put("lono", lono);
		// insert into Finshed_Order
		int result = userService.insertOrder(map);
		if (result > 0) {
			// insert into Orders if order is made
			list = userService.getCartList(vo);
			for (HashMap m : list) {
				HashMap map2 = new HashMap();
				map2.put("lono", lono);
				map2.put("pno", m.get("PNO"));
				map2.put("ocnt", m.get("OCNT"));
				result = userService.insertOrders(map2);
				// delete Cart when Orders are Finished
				userService.deleteCart(vo);
			} // for
		} // if
		return "redirect:pay_complete.do";
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
	@RequestMapping("questionDelete.do")
	public String questionDelete(AnswerVO avo, QuestionVO vo) {
		System.out.println("=>UserController.java::questionDelete.do");
		userService.answerDelete(avo);
		userService.questionDelete(vo);
		return "redirect:mypage.do";
	}

}
