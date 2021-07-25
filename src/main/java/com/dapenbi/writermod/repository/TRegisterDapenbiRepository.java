package com.dapenbi.writermod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.dapenbi.writermod.model.TRegisterDapenbi;

public interface TRegisterDapenbiRepository extends JpaRepository<TRegisterDapenbi, Long> {
	List<TRegisterDapenbi> findByNip(String nip);
	
	List<TRegisterDapenbi> findByIsgenerate(String isgenerate);
	
	@Modifying
	@Transactional
	Long deleteByNip(String nip);
}
