package com.javassem.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.AnswerVO;
import com.javassem.domain.CriteriaVO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ListOrderVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;
import com.javassem.domain.QuestionVO;

@Repository
public class UserDAOImpl implements UserDAO {
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
		return mybatis.update("UserDAO.modifyProduct", vo);
	}

	public int deleteProduct(ProductVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::deleteProduct");
		return mybatis.delete("UserDAO.deleteProduct", vo);
	}
	// ---manager product end

	// ---manager orders
	public int deleteOrder(Integer lono) {
		return mybatis.delete("UserDAO.deleteOrder", lono);
	}

	public int deleteOrders(Integer lono) {
		return mybatis.delete("UserDAO.deleteOrders", lono);

	}
	// ---manager orders end

	// ---manager contact
	public int insertAnswer(AnswerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::deleteProduct");
		return mybatis.insert("UserDAO.insertAnswer", vo);
	}
	// ---manager contact end

	// ---manager login
	public ManagerVO checkMId(ManagerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::checkMId");
		return mybatis.selectOne("UserDAO.checkMId", vo);
	}

	public int insertManager(ManagerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::insertManager");
		return mybatis.insert("UserDAO.insertManager", vo);
	}

	public ManagerVO loginManager(ManagerVO vo) {
		return mybatis.selectOne("UserDAO.loginManager", vo);
	}
	// ---manager login end

	// 상품 목록 조회
	public List<ProductVO> getProductList(CriteriaVO cri) throws Exception{
	return mybatis.selectList("UserDAO.getProductList", cri);
	}

	public List<ProductVO> getProductList2(CriteriaVO cri) throws Exception{
		return mybatis.selectList("UserDAO.getProductList2", cri);
	}

	// 상품 총 갯수
	public int listCount() throws Exception {
		return mybatis.selectOne("UserDAO.listCount");
	}

	public List<HashMap> getCustomersOrders() {
		return mybatis.selectList("UserDAO.getCustomersOrders");
	}

	// ----------------------------------manager end
	// ----------------------------------user
	// ---user product
	public int removeCart(ListOrderVO vo) {
		return mybatis.delete("UserDAO.removeCart", vo);
	}

	public int insertCart(ListOrderVO vo) {
		return mybatis.insert("UserDAO.insertCart", vo);
	}

	public ListOrderVO selectCart(ListOrderVO vo) {

		System.out.println(vo);
		return mybatis.selectOne("UserDAO.selectCart", vo);
	}

	public int updateCart(ListOrderVO vo) {
		return mybatis.update("UserDAO.updateCart", vo);
	}

	public int deleteCart(ListOrderVO vo) {
		return mybatis.delete("UserDAO.deleteCart", vo);
	}

	public int selectLono() {
		return mybatis.selectOne("UserDAO.selectLono");
	}

	// ---user product end
	// ---user orders
	public int selectStock(int pno) {
		return mybatis.selectOne("selectStock", pno);
	}

	public int increaseStock(HashMap map) {
		return mybatis.update("UserDAO.increaseStock", map);
	}

	public int decreaseStock(HashMap map) {
		return mybatis.update("UserDAO.decreaseStock", map);
	}

	public int insertOrder(HashMap map) {
		return mybatis.insert("UserDAO.insertOrder", map);
	}

	public int insertOrders(HashMap map) {
		return mybatis.insert("UserDAO.insertOrders", map);
	}

	// ---user orders end
	// ---user contact
	public int insertQustion(QuestionVO vo) {
		return mybatis.insert("UserDAO.insertQustion", vo);
	}

	public int questionDelete(QuestionVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::questionDelete");
		return mybatis.delete("UserDAO.questionDelete", vo);
	}

	public int answerDelete(AnswerVO avo) {
		return mybatis.delete("UserDAO.answerDelete", avo);
	}
	// ---user contact end

	// ---user login
	public CustomerVO checkId(CustomerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::checkId");
		return mybatis.selectOne("UserDAO.checkId", vo);
	}

	public int insertCustomer(CustomerVO vo) {
		System.out.println("=>UserDAOImpl.java::UserMapper::insertCustomer");
		return mybatis.insert("UserDAO.insertCustomer", vo);
	}

	public CustomerVO loginCustomer(CustomerVO vo) {
		return mybatis.selectOne("UserDAO.loginCustomer", vo);
	}
	// ---user login end

	public List<ListOrderVO> getQuestionList() {
		return mybatis.selectList("UserDAO.getQuestionList");
	}

	public List<HashMap> getQuestionAnswer(Integer loginCno) {
		return mybatis.selectList("UserDAO.getQuestionAnswer", loginCno);
	}

	public List<HashMap> getOrdersList(Integer loginCno) {
		return mybatis.selectList("UserDAO.getOrdersList", loginCno);
	}

	public List<HashMap> getCartList(ListOrderVO vo) {
		return mybatis.selectList("UserDAO.getCartList", vo);
	}
	// ----------------------------------user

	public List<Map<String, Object>> getSalesListBy(String year) {
		return mybatis.selectList("UserDAO.getSalesListBy", year);
	}

	public List<Map<String, Object>> getCountSalesListBy(String year) {
		return mybatis.selectList("UserDAO.getCountSalesListBy", year);
	}

	public List<ProductVO> shop_search(HashMap map) {
		System.out.println("===> UserDAO.shop_search 호출");
		return mybatis.selectList("UserDAO.shop_search", map);
	}

}