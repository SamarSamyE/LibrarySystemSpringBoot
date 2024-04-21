package com.project.assignment.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.assignment.entities.Patron;
import com.project.assignment.models.mapinterface.PatronMapper;
import com.project.assignment.models.request.PatronReqModel;
import com.project.assignment.models.response.PatronResModel;
import com.project.assignment.repositories.PatronRepository;
import com.project.assignment.services.PatronService;

@Service
public class DefaultPatronService implements PatronService {

	@Autowired
	PatronRepository patronRepository;
	
	@Autowired
	PatronMapper patronMapper;
	
	@Override
	@Transactional
	@CacheEvict(value= {"getPatronById","getAllPatrons"},key="#root.methodName",allEntries=true)
	public int createPatron(PatronReqModel patronReqModel) {
		Patron patron=new Patron();
		mapPatronReqModelToPatron(patron,patronReqModel);
		patronRepository.save(patron);
		return patron.getId();
	}
	
	@Override
	@Transactional
	@CacheEvict(value= {"getPatronById","getAllPatrons"},key="#root.methodName",allEntries=true)
	public int updatePatron(int patronId, PatronReqModel patronReqModel) {
		Patron updatedPatron=patronRepository.findById(patronId).get();
		mapPatronReqModelToPatron(updatedPatron,patronReqModel);
		patronRepository.save(updatedPatron);
		return updatedPatron.getId();
	}
	
	
	@Override
	@Cacheable(value="getPatronById", key="#patronId")
	public PatronResModel getPatronById(int patronId) {
		Patron patron=patronRepository.findById(patronId).get();
		return patronMapper.mapToPatronResModel(patron);
	}
	
	@Override
	@Cacheable(value="getAllPatrons", key="#root.methodName")
	public List<PatronResModel> getAllPatrons() {
		return patronMapper.mapToPatronResModel(patronRepository.findAll());
	}
	
	@Override
	@Transactional
	@CacheEvict(value= {"getPatronById","getAllPatrons"},key="#root.methodName",allEntries=true)
	public void deletePatronById(int patronId) {
		patronRepository.deleteById(patronId);
	}
	
	
	private void mapPatronReqModelToPatron(Patron patron,PatronReqModel patronReqModel){
		patron.setName(patronReqModel.getName());
		patron.setEmail(patronReqModel.getEmail());
		patron.setMobile(patronReqModel.getMobile());
	}

}
