package com.javassem.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javassem.domain.AnswerVO;
import com.javassem.domain.CriteriaVO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ListOrderVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;
import com.javassem.domain.QuestionVO;
import com.javassem.paging.PageMaker;
import com.javassem.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// ----------------------------------manager
	// ---manager product
	// 메니저가 재품(BEANS) 더하기
	@RequestMapping(value = "addProduct.do")
	public String addProduct(ProductVO vo) {
		System.out.println("=>UserController.java::addProduct.do");
		userService.insertProduct(vo);
		return "redirect:shop_m.do";
	}

	// 메니저가 재품(GOODS) 더하기
	@RequestMapping(value = "addProduct2.do")
	public String addProduct2(ProductVO vo) {
		System.out.println("=>UserController.java::addProduct2.do");
		userService.insertProduct2(vo);
		return "redirect:shop2_m.do";
	}

	// 메니저가 재품 수정하기
	@RequestMapping(value = "modifyProduct.do")
	public String modifyProduct(ProductVO vo) {
		System.out.println("=>UserController.java::modifyProduct.do");
		userService.modifyProduct(vo);
		return "redirect:shop_m.do";
	}

	// 메니저가 재품 삭제하기
	@RequestMapping(value = "deleteProduct.do")
	public String deleteProduct(ProductVO vo) {
		System.out.println("=>UserController.java::deleteProduct.do");
		userService.deleteProduct(vo);
		File file = new File(
				"D:\\springspace\\springweb\\sj\\src\\main\\webapp\\resources\\assets\\img\\products\\" + vo.getImg());
		// 절대 경로로 이지지를 없엘 경로를 지정해준다. sj 아래서부터는 같음
		if (file.exists()) {
			file.delete();
		}
		return "redirect:shop_m.do";
	}
	// ---manager product end

	// ---manager contact
	// 메니저가 질문에 응답 삽입
	@RequestMapping(value = "insertAnswer.do")
	public String insertAnswer(AnswerVO vo) {
		System.out.println("=>UserController.java::insertAnswer.do");
		userService.insertAnswer(vo);
		return "redirect:contact_m.do";
	}
	// ---manager contact end

	// ---manager login
	// 새로운 메니저 삽입
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

	// 메니저 로그인 확인
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

	// 메니저 로그아웃
	@RequestMapping(value = "logout_m.do")
	public String logout_m(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:index_m.do";
	}
	// ---manager login end
	
	// 주문 지우기
	@RequestMapping("deleteOrder.do")
	public String deleteOrder(Integer lono) {
		userService.deleteOrders(lono);
		userService.deleteOrder(lono);
		return "redirect:index_m.do";
	}

	// 대답이 없는 질문들 리스트
	@RequestMapping("contact_m.do")
	public void contact_m(Model m) {
		List<ListOrderVO> list = userService.getQuestionList();
		m.addAttribute("questionList", list);
	}

	// 메니저에게 고객들 주문 내역들 보이기
	@RequestMapping("index_m.do")
	public void index_m(Model m) {
		List<HashMap> list = userService.getCustomersOrders();
		m.addAttribute("getCustomersOrders", list);
	}
	
	// BEANS list 가져요기 (페이징 포함)
	@RequestMapping("shop_m.do")
	public void shop_m(Model m) {
		List<ProductVO> list = userService.getAllProductList();
		m.addAttribute("productList", list);
	}
	

	// GOODS list 가져오기 (페이징 포함)
	@RequestMapping("shop2_m.do")
	public void shop2_m(Model m)  {
		List<ProductVO> list = userService.getAllProductList2();
		m.addAttribute("productList2", list);
	}

	// ----------------------------------manager end

	// ----------------------------------user
	// ---user product
	// 장바구니에서 상품 지우기
	@RequestMapping(value = "removeCart.do")
	public String removeCart(ListOrderVO vo) {
		userService.removeCart(vo);
		return "redirect:cart.do?cno=" + vo.getCno();
	}

	// 장바구니 물품 갯수 수정 
	@RequestMapping(value = "updateCart.do")
	public String updateCart(ListOrderVO vo) { // pno, cno, ocnt 를 가져옴
		userService.updateCart(vo);
		return "redirect:cart.do?cno=" + vo.getCno();
	}

	// 장바구니에 더하기 (업데이트 하기)
	@RequestMapping(value = "addCart.do")
	public String addCart(ListOrderVO vo, Model m) {
		// 장바구니에 고객이 산 상품의 갯수
		ListOrderVO exists = userService.selectCart(vo); // 만약 pno cno 가 장바구니 안에 있다면
		int req = 0;
		//만약 장바구니에 exist 제품이 없다면 insert, 있다면 overwrite
		if (exists == null)
			req = userService.insertCart(vo);
		else
			req = userService.updateCart(vo);
		if (req == 1) {
			List<HashMap> list = userService.getCartList(vo);
			m.addAttribute("getCartList", list);
			//자기의 카트로 다시 가게 하기
			return "redirect:cart.do?cno=" + vo.getCno();
		} else {
			return "redirect:404.do";
		}
	}
	// ---user product end

	// ---user contact
	// 고객이 질문하기
	@RequestMapping(value = "insertQustion.do")
	public String insertQustion(QuestionVO vo) {
		System.out.println("=>UserController.java::insertQustion.do");
		int result = userService.insertQustion(vo);
		if (result == 1)
			return "redirect:contact_complete.do";
		return "redirect:contact.do";
	}

	// 고객이 질문 지우기
	@RequestMapping("questionDelete.do")
	public String questionDelete(AnswerVO avo, QuestionVO vo) {
		System.out.println("=>UserController.java::questionDelete.do");
		userService.deleteAnswer(avo);
		//만약 답변이 달린 경우 먼저 지우고 질문을 지우기
		userService.deleteQuestion(vo);
		return "redirect:mypage.do";
	}
	// ---user contact end

	// ---user login
	// 새로운 고객을 추가함
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

	// 고객 로그인 확인
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

	// 고객 로그아웃
	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		logCustomer(" logged out at ", session);
		session.invalidate();
		return "redirect:index.do";
	}
	

	// fileLog.txt 로 고객이 하는 일<strToWrite> 을 시간과 함께 적음
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
	
	// 고객 회원정보 수정
	@RequestMapping(value = "modifyCustomer.do", method = RequestMethod.POST)
	public String modifyCustomer(CustomerVO vo, HttpSession session) {
		//데이터베이스에서 고객정보 수정		
		userService.modifyCustomer(vo);
		
		//수정값을 세션값에 저장
		session.setAttribute("loginName", vo.getName());
		session.setAttribute("loginGender", vo.getGender());
		session.setAttribute("loginId", vo.getId());
		session.setAttribute("loginPw", vo.getPw());
		session.setAttribute("loginTel", vo.getTel());
		session.setAttribute("loginEmail", vo.getEmail());
		session.setAttribute("loginAddr", vo.getAddr());
		
		//수정 후 mypage로 이동
		return "redirect:mypage.do";
		
	}
	// 회원 정보 삭제 (모든 정보를 삭제함)
	@RequestMapping("deleteMember.do")
	public String deleteMember(int cno, AnswerVO avo, CustomerVO cvo, QuestionVO qvo, ListOrderVO lvo, HttpServletRequest request) {
		// 모든 답변 삭제
		userService.deleteAllAnswer(avo);
		// 장바구니 삭제
		userService.deleteCart(lvo);
		// 질문 삭제
		userService.deleteAllQuestion(qvo);
		// 주문 목록을 뽑아와서 주문 내역 삭제
		List<HashMap> list1 = userService.getOrdersList(cvo.getCno());
		for(HashMap map : list1) {
			int lono = Integer.valueOf(String.valueOf(map.get("LONO")));
			userService.deleteAllOrders(lono);
			userService.deleteAllOrder(lono);
		}
		// 회원 삭제
		userService.deleteCustomer(cvo);
		logout(request);
		return "redirect:delete_member_complete.do";
		}
	// ---user login end

	// 장바구니 리스트
	@RequestMapping("cart.do")
	public void cart(ListOrderVO vo, Model m) {
		List<HashMap> list = userService.getCartList(vo);
		m.addAttribute("getCartList", list);
	}

	// 장바구니 리스트
	@RequestMapping("checkout.do")
	public void checkout(ListOrderVO vo, Model m) {
		List<HashMap> list = userService.getCartList(vo);
		m.addAttribute("getCartList", list);
	}

	// 상품 목록 리스트
	@RequestMapping("index.do")
	public void index(Model m, CriteriaVO cri) throws Exception {
		List<ProductVO> list = userService.getProductList(cri);
		m.addAttribute("productList", list);
	}

	// 마이 페이지의 주문 목록, 질의 목록
	@RequestMapping("mypage.do")
	public void mypage(Model m, HttpSession session) {
		Integer cno = 0;
		Object obj = session.getAttribute("loginCno");
		if (obj != null)
			cno = (Integer) obj;
		//주문 목록
		List<HashMap> list1 = userService.getOrdersList(cno);
		m.addAttribute("OrdersList", list1);
		// 질문응답 목록
		List<HashMap> list = userService.getQuestionAnswer(cno);
		m.addAttribute("questionAnswerList", list);
	}

	// 결제하기
	@RequestMapping("pay_mid_complete.do")
	public String pay_complete(String cno, String addr) {
		ListOrderVO vo = new ListOrderVO();
		vo.setCno(Integer.valueOf(cno));
		// 장바구니
		List<HashMap> list = userService.getCartList(vo);
		// 장바구니에 있는 제품 목록들을 보고
		for (HashMap m : list) {
			// 한 제품의 재고가 있는지 확인, 뺄수 있는지 확인
			int stock = userService.selectStock(Integer.valueOf(String.valueOf(m.get("PNO"))));
			int checkStock = stock - Integer.valueOf(String.valueOf(m.get("OCNT")));
			// 만약 재고가 없거나, 부족하면 재고에서 빠진 제품들의 ocnt 를 다시 더해준다
			if (checkStock < 0) { // 다른 방법으로는 재고가 있는지 확인을 밖의 for loop 에서 확인하고 빼는 방법도 있을 것이다 
				for (HashMap m3 : list) { //하지만 단 한번의 for loop를 사용하기 위해 안의 for loop을 돌리고 break 을 쓴다
					stock = userService.selectStock(Integer.valueOf(String.valueOf(m3.get("PNO"))));
					checkStock = stock - Integer.valueOf(String.valueOf(m3.get("OCNT")));
					// 재고가 ocnt 보다 적은 경우 break 해서 더이상 빠진 것들이 없기 때문에 더해주지 않는다
					if (checkStock < 0)
						break; 
					//이미 빠져버린 값들을 다시 더해준다 (rollback의 개념)
					HashMap map2 = new HashMap();
					map2.put("pno", m3.get("PNO"));
					map2.put("ocnt", m3.get("OCNT"));
					userService.increaseStock(map2);
				}
				return "redirect:pay_incomplete.do";
			} else {
				// 만약 stock > ocnt, stock 을 줄인다
				HashMap map2 = new HashMap();
				map2.put("pno", m.get("PNO"));
				map2.put("ocnt", m.get("OCNT"));
				userService.decreaseStock(map2);
			} // else
		} // for
		
		// 주문처리를 위해 주문 번호를 미리 만든다
		int lono = userService.selectLono();
		HashMap map = new HashMap();
		map.put("cno", vo.getCno());
		map.put("addr", addr);
		map.put("lono", lono);
		// 주문을 때린다
		int result = userService.insertOrder(map);
		if (result > 0) {
			// 만약 주문이 만들어 졌으면 장바구니에 있는 리스트를 주문으로 옮긴다
			list = userService.getCartList(vo);
			for (HashMap m : list) {
				HashMap map2 = new HashMap();
				map2.put("lono", lono);
				map2.put("pno", m.get("PNO"));
				map2.put("ocnt", m.get("OCNT"));
				result = userService.insertOrders(map2);
			} // for
			// 주문이 끝나면 장바구니를 지운다
			userService.deleteCart(vo);
		} // if
		return "redirect:pay_complete.do";
	}
	
	@RequestMapping(value = "shop.do", method = RequestMethod.GET)
	public String shop(Model m, CriteriaVO cri) throws Exception {

		m.addAttribute("productList", userService.getProductList(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop";
	}

	@RequestMapping(value = "shop_capsule.do", method = RequestMethod.GET)
	public String shop_capsule(Model m, CriteriaVO cri) throws Exception {

		m.addAttribute("productList", userService.getProductList_1(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop_capsule";
	}
	
	@RequestMapping(value = "shop_dripbag.do", method = RequestMethod.GET)
	public void shop_dripbag(Model m, CriteriaVO cri) throws Exception {

		m.addAttribute("productList", userService.getProductList_2(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

	}
	
	@RequestMapping(value = "shop_beans.do", method = RequestMethod.GET)
	public String shop_beans(Model m, CriteriaVO cri) throws Exception {

		m.addAttribute("productList", userService.getProductList_3(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop_beans";
	}
	
	@RequestMapping(value = "shop2.do",  method = RequestMethod.GET)
	public String shop2(Model m, CriteriaVO cri) throws Exception {
		System.out.println("shop2.do 요청");
		List<ProductVO> list = userService.getProductList2(cri);
		m.addAttribute("productList", list);
		System.out.println("list.size()" + list.size());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop2";
	}
	
	@RequestMapping(value = "shop2_extraction.do",  method = RequestMethod.GET)
	public String shop2_extraction(Model m, CriteriaVO cri) throws Exception {
		List<ProductVO> list = userService.getProductList2_1(cri);
		m.addAttribute("productList", list);
		//System.out.println("list.size()" + list.size());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop2_extraction";
	}
	
	@RequestMapping(value = "shop2_grinder.do",  method = RequestMethod.GET)
	public String shop2_grinder(Model m, CriteriaVO cri) throws Exception {
		List<ProductVO> list = userService.getProductList2_2(cri);
		m.addAttribute("productList", list);
		//System.out.println("list.size()" + list.size());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop2_grinder";
	}
	
	@RequestMapping(value = "shop2_cup.do",  method = RequestMethod.GET)
	public String shop2_cup(Model m, CriteriaVO cri) throws Exception {
		List<ProductVO> list = userService.getProductList2_3(cri);
		m.addAttribute("productList", list);
		//System.out.println("list.size()" + list.size());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.listCount());

		m.addAttribute("pageMaker", pageMaker);

		return "shop2_cup";
	}

	// ----------------------------------user end
	// index_m 의 차트를 위해 월별 매출액을 얻어오기
	@ResponseBody
	@RequestMapping("sales/{year}")
	public List<Map<String, Object>> getSalesByYear(@PathVariable String year) {
		return userService.getSalesListBy(year);
	}

	// index_m의 차트를 위해 월별 매출 건수 얻어오기
	@ResponseBody
	@RequestMapping("countsales/{year}")
	public List<Map<String, Object>> getCountSalesByYear(@PathVariable String year) {
		return userService.getCountSalesListBy(year);
	}

	// 상품검색
	@RequestMapping("shop_search.do")
	public void shop_search(String searchKeyword, Model m) {

		System.out.println("searchKeyword : " + searchKeyword);
		HashMap map = new HashMap();
		map.put("searchKeyword", searchKeyword);

		List<ProductVO> list = userService.shop_search(map);

		m.addAttribute("productList", list);
	}
	
	// 상품검색
	@RequestMapping("shop_search_m.do")
	public void shop_search_m(String searchKeyword, Model m) {

		System.out.println("searchKeyword : " + searchKeyword);
		HashMap map = new HashMap();
		map.put("searchKeyword", searchKeyword);

		List<ProductVO> list = userService.shop_search(map);

		m.addAttribute("productList", list);
	}

	
	// request를 받으면 똑같은 이름으로 답하기
	@RequestMapping("{url}.do")
	public String userPage(@PathVariable String url) {
		System.out.println("확인");
		return url;
		// [/WEB-INF/views/*]로 받음
	}
	// 다른 방법
	// @RequestMapping("<fileName>")
	// public void <fileName>() {
	//
	// }
	
	@RequestMapping(value = "find_password.do")
	public void find_password() {
		
	}
	
	@RequestMapping(value = "mail.do")
	public String mail(String email, String id) {
		System.out.println("MAIL : : : : : : : : : : : : : : : : : : : :");
		HashMap map = new HashMap();
		map.put("email",email);
		map.put("id", id);
		
		List<CustomerVO> existingCustomer = userService.getCustomer(map);
		System.out.println("The customer with id and email exists: " + existingCustomer);
		
		String temporaryPassword = "";
		if(existingCustomer.size() == 0 || existingCustomer == null) {
			System.out.println(existingCustomer);
			return "redirect:sendmail_incomplete.do";
			
		}else {
			//이메일 보내기
		    String username = "icecream1213@naver.com";
		    String password = "bellaC480@1212";
		    String recipient = email;

		    Properties props = new Properties();

		    props.put("mail.smtp.host", "smtp.naver.com");
		    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		    props.put("mail.smtp.ssl.trust", "smtp.naver.com");
		    props.put("mail.from", "icecream1213@naver.com");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.port", "587");
		    props.setProperty("mail.debug", "true");

		    Session session = Session.getInstance(props, null);
		    MimeMessage msg = new MimeMessage(session);
		    
		    //임시 비밀번호 만들기
		    try {
		    msg.setFrom();
		    msg.setRecipients(Message.RecipientType.TO, recipient);
		    msg.setSubject("Reply for your request for <password change>");
		    msg.setSentDate(new Date());
		    
		    //임시 비밀번호 만들기
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 6;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    temporaryPassword = buffer.toString();

		    msg.setText("The temporary password is : \n" + temporaryPassword);

		    Transport transport = session.getTransport("smtp");

		    transport.connect(username, password);
		    transport.sendMessage(msg, msg.getAllRecipients());
		    transport.close();
		    
		    }catch(Exception e) {
		    	System.out.println(e);
		    }//catch
		    
		    System.out.println(temporaryPassword);
		    
		    //이메일을 보낸 후 로그인 할때 임시 비밀번호도 적용이 되게하기
		    List<CustomerVO> list = userService.getCustomerInfo(map);
		    	
		    //CustomerVO 객체를 하나 더 만들어 temporary pw 를 저장한다
		    CustomerVO vo = new CustomerVO();
		    vo.setCno(list.get(0).getCno());
		    vo.setAddr(list.get(0).getAddr());
		    vo.setEmail(list.get(0).getEmail());
		    vo.setGender(list.get(0).getGender());
		    vo.setId(list.get(0).getId());
		    vo.setName(list.get(0).getName());
		    vo.setPw(temporaryPassword);
		    vo.setTel(list.get(0).getTel());
		    userService.insertCustomer(vo);		    
		    
		}//else
		
		return "redirect:sendmail_complete.do";
    }//mail
}
