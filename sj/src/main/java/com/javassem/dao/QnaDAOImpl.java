package com.javassem.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.QuestionVO;

@Repository("QnaDAO")
public class QnaDAOImpl implements QnaDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertContact(QuestionVO vo) {
		System.out.println("===> Mybatis insertContact() 호출");
		mybatis.insert("QnaDAO.insertContact", vo);
	}

	// ----------------------------------------------------------
	
	
	@Override
	public void updateContact(QuestionVO vo) {
		System.out.println("===> Mybatis updateContact() 호출");		
	}

	@Override
	public void deleteContact(QuestionVO vo) {
		System.out.println("===> Mybatis deleteContact() 호출");		
	}

}
