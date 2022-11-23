package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.UserDAO;
import com.javassem.domain.AnswerVO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ListOrderVO;
import com.javassem.domain.ManagerVO; 
import com.javassem.domain.ProductVO;
import com.javassem.domain.QuestionVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	// ----------------------------------manager
	// ---manager product
	public int insertProduct(ProductVO vo) {
		return userDAO.insertProduct(vo);
	}

	public int insertProduct2(ProductVO vo) {
		return userDAO.insertProduct2(vo);
	}

	public int modifyProduct(ProductVO vo) {
		return userDAO.modifyProduct(vo);
	}

	public int deleteProduct(ProductVO vo) {
		return userDAO.deleteProduct(vo);
	}
	// ---manager product end
	
	// ---manager orders
	public int deleteOrder(Integer lono) {
		return userDAO.deleteOrder(lono);
	}
	public int deleteOrders(Integer lono) {
		return userDAO.deleteOrders(lono);
	}
	// ---manager orders end
	
	// ---manager contact
	public int insertAnswer(AnswerVO vo) {
		return userDAO.insertAnswer(vo);
	}
	// ---manager contact end
	
	// ---manager login
	public ManagerVO checkMId(ManagerVO vo) {
		return userDAO.checkMId(vo);
	}

	public int insertManager(ManagerVO vo) {
		return userDAO.insertManager(vo);
	}

	public ManagerVO loginManager(ManagerVO vo) {
		return userDAO.loginManager(vo);
	}
	// ---manager login end

	public List<ProductVO> getProductList() {
		return userDAO.getProductList();
	}

	public List<ProductVO> getProductList2() {
		return userDAO.getProductList2();
	}
	public List<HashMap> getCustomersOrders(){
		return userDAO.getCustomersOrders();
	}
	// ----------------------------------manager end

	// ----------------------------------user
	// ---user product
	public int removeCart(ListOrderVO vo) {
		return userDAO.removeCart(vo);
	}
	public int insertCart(ListOrderVO vo) {
		return userDAO.insertCart(vo);
	} 
	public ListOrderVO selectCart(ListOrderVO vo) {
		return userDAO.selectCart(vo);
	}
	public int updateCart(ListOrderVO vo) {
		return userDAO.updateCart(vo);
	}
	public int deleteCart(ListOrderVO vo) {
		return userDAO.deleteCart(vo);
	}
	public int selectLono() {
		return userDAO.selectLono();
	}
	// ---user product end
	
	// --user orders
	public int insertOrder(HashMap map) {
		return userDAO.insertOrder(map);
	}
	public int insertOrders(HashMap map2) {
		return userDAO.insertOrders(map2);
	}
	// --user orders end

	// ---user contact
	public int insertQustion(QuestionVO vo) {
		return userDAO.insertQustion(vo);
	}
	// ---user contact end

	// ---user login
	public CustomerVO checkId(CustomerVO vo) {
		return userDAO.checkId(vo);
	}

	public int insertCustomer(CustomerVO vo) {
		return userDAO.insertCustomer(vo);
	}

	public CustomerVO loginCustomer(CustomerVO vo) {
		return userDAO.loginCustomer(vo);
	}
	// ---user login end

	public List<ListOrderVO> getQuestionList(){
		return userDAO.getQuestionList();
	}

	public List<HashMap> getQuestionAnswer(Integer loginCno) {
		return userDAO.getQuestionAnswer(loginCno);
	}

	public List<HashMap> getOrdersList(Integer loginCno){
		return userDAO.getOrdersList(loginCno);
	}
	@Override
	public List<HashMap> getCartList(ListOrderVO vo) {
		return userDAO.getCartList(vo);
	}

	// ----------------------------------user end
	public int stock(HashMap map) {
		return userDAO.stock(map);
	}



}