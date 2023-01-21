package com.lurf.gerenciadorPessoasAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lurf.gerenciadorPessoasAPI.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
}
