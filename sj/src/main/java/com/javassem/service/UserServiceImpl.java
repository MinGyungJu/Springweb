package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.UserDAO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;

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
	
	public int delete(ProductVO vo) {
		return userDAO.delete(vo);
		
	}
	
	// ---manager product end

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

	public List<ProductVO> getProductList(){
		return userDAO.getProductList();
	}

	// ----------------------------------manager end

	// ----------------------------------user
	
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

	

	// ----------------------------------user end




}