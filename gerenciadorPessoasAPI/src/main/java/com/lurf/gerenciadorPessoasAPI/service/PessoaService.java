package com.lurf.gerenciadorPessoasAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lurf.gerenciadorPessoasAPI.entity.Pessoa;
import com.lurf.gerenciadorPessoasAPI.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository ;
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);	
	}
	
	public List<Pessoa> listaPessoas(){
		return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> buscarPorId(Long id){
		return pessoaRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
}
