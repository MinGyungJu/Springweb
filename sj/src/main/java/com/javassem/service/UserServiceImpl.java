package com.javassem.service;

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
	
	public int insertProduct(ProductVO vo) {
		return userDAO.insertProduct(vo);
	}
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