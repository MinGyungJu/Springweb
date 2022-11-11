package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dao.SampleDAO;


@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private SampleDAO sampleDAO;

	public String getTime() {
		return sampleDAO.getTime();
	}

}