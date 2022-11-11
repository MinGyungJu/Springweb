package sample.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAOImpl implements SampleDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public String getTime() {
		System.out.println("===> Mybatis selectTime() 호출");
		return mybatis.selectOne("sampleDAO.getTime");
	}
}