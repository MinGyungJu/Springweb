package sample.dao;

import java.util.HashMap;
import java.util.List;

import sample.vo.EmpVO;

public interface EmpDAO {

	List<EmpVO> empSelect();
	
	List<HashMap> empDept();

}