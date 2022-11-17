package com.javassem.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.CustomerVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	// ----------------------------------manager
	// ---manager product
	public int insertProduct(ProductVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::insertProduct");
		return mybatis.insert("UserDAO.insertProduct", vo);
	}

	public int insertProduct2(ProductVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::insertProduct2");
		return mybatis.insert("UserDAO.insertProduct2", vo);
	}

	public int modifyProduct(ProductVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::modifyProduct");
		return mybatis.update("UserDAO.modifyProduct",vo);
	}
	@Override
	public int delete(ProductVO vo) {
		
		return mybatis.delete("UserDAO.delete",vo);
	}
	// ---manager product end
	
	// ---manager login
	public ManagerVO checkMId(ManagerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::checkMId");
		return mybatis.selectOne("UserDAO.checkMId",vo);
	}
	public int insertManager(ManagerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::insertManager");
		return mybatis.insert("UserDAO.insertManager", vo);
	}
	public ManagerVO loginManager(ManagerVO vo) {
		return mybatis.selectOne("UserDAO.loginManager", vo);
	}
	// ---manager login end

	public List<ProductVO> getProductList(){
		return mybatis.selectList("UserDAO.getProductList");
	}
	// ----------------------------------manager end
	// ----------------------------------user
	// ---user login
	public CustomerVO checkId(CustomerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::checkId");
		return mybatis.selectOne("UserDAO.checkId",vo);
	}
	public int insertCustomer(CustomerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::insertCustomer");
		return mybatis.insert("UserDAO.insertCustomer", vo);
	}
	public CustomerVO loginCustomer(CustomerVO vo) {
		return mybatis.selectOne("UserDAO.loginCustomer", vo);
	}
	// ---user login end

	

	

	

	// ----------------------------------user

}