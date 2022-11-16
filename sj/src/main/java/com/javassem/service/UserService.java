package com.javassem.service;

import com.javassem.domain.CustomerVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;


public interface UserService { 
	// ----------------------------------manager
	
	// ---manager product
	public int insertProduct(ProductVO vo);
	// ---manager product end
	
	// ---manager login
	public ManagerVO checkMId(ManagerVO vo);
	public int insertManager(ManagerVO vo);
	public ManagerVO loginManager(ManagerVO vo);
	// ---manager login end

	// ----------------------------------manager end

	
	// ----------------------------------user
	
	// ---user login
	public CustomerVO checkId(CustomerVO vo);
	public int insertCustomer(CustomerVO vo);
	public CustomerVO loginCustomer(CustomerVO vo);
	// ---user login end

	// ----------------------------------user end

}
