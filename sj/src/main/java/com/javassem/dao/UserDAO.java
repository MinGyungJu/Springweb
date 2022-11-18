package com.javassem.dao;

import java.util.List;

import com.javassem.domain.AnswerVO;
import com.javassem.domain.CustomerVO;
import com.javassem.domain.ListOrderVO;
import com.javassem.domain.ManagerVO;
import com.javassem.domain.ProductVO;
import com.javassem.domain.QuestionVO;

public interface UserDAO {
	// ----------------------------------manager
	// ---manager product
	public int insertProduct(ProductVO vo);
	public int insertProduct2(ProductVO vo);
	public int modifyProduct(ProductVO vo);
	public int deleteProduct(ProductVO vo);
	// ---manager product end

	// ---manager contact
	public int insertAnswer(AnswerVO vo);
	// ---manager contact end
	
	// ---manager login
	public ManagerVO checkMId(ManagerVO vo);
	public int insertManager(ManagerVO vo);
	public ManagerVO loginManager(ManagerVO vo);
	// ---manager login end
	public List<ProductVO> getProductList();
	public List<ProductVO> getProductList2();
	// ----------------------------------manager end
	
	// ----------------------------------user

	// ---user product
	public int insertCart(ListOrderVO vo);
	// ---user product end
	
	// ---user contact
	public int insertQustion(QuestionVO vo);
	// ---user contact

	// ---user login
	public CustomerVO checkId(CustomerVO vo);
	public int insertCustomer(CustomerVO vo);
	public CustomerVO loginCustomer(CustomerVO vo);
	// ---user login end
	public List<ListOrderVO> getQuestionList();
	// ----------------------------------user end
	public List<AnswerVO> getAnswerList();



}
