package com.dapenbi.writermod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dapenbi.writermod.model.TRegisterDapenbi;
import com.dapenbi.writermod.repository.TRegisterDapenbiRepository;

@Service
public class TRegisterDapenbiServiceImpl implements TRegisterDapenbiService {
	
	@Autowired
	TRegisterDapenbiRepository tregdbiRepo;

	@Override
	public void updateDataGenerate(TRegisterDapenbi tRegDapenbi, String isGenerate) {
		// TODO Auto-generated method stub
		tRegDapenbi.setIsgenerate(isGenerate);
		tregdbiRepo.save(tRegDapenbi);
	}

	
}
