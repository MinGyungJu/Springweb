package sample.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.vo.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSess;
	
	@Override
	public List<EmpVO> empSelect(){
		return sqlSess.selectList("EmpDao.empSelect");
	}
	
	public List<HashMap> empDept(){
		return sqlSess.selectList("EmpDao.empDept");
	}
}
