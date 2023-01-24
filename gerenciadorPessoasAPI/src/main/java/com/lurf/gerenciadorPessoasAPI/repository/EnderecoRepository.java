package com.lurf.gerenciadorPessoasAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lurf.gerenciadorPessoasAPI.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}
