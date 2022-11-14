package sample.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dao.EmpDAO;
import sample.dao.SampleDAO;
import sample.vo.EmpVO;


@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private EmpDAO empDAO;
	
	@Autowired
	private SampleDAO sampleDAO;

	public String getTime() {
		return sampleDAO.getTime();
	}

	@Override
	public List<EmpVO> empselect() {
		
		return empDAO.empSelect();
	}
	
	public List<HashMap> empDept(){
		return empDAO.empDept();
	}

	

}