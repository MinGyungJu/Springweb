package sample.service;

import java.util.HashMap;
import java.util.List;

import sample.vo.EmpVO;

public interface SampleService {
	
	
	// CRUD 기능의 메소드 구현
	public String getTime();
	
	List<EmpVO> empselect();
	
	public List<HashMap> empDept();

}
