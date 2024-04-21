package com.project.assignment.services;

import java.util.List;

import com.project.assignment.models.request.PatronReqModel;
import com.project.assignment.models.response.PatronResModel;

public interface PatronService {
	
	int createPatron(PatronReqModel patronReqModel);
	int updatePatron(int patronId,PatronReqModel patronReqModel);
	PatronResModel getPatronById(int patronId);
	List<PatronResModel> getAllPatrons();
	void deletePatronById(int patronId);
	
}
