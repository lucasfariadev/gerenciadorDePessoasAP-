package com.lurf.gerenciadorPessoasAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lurf.gerenciadorPessoasAPI.entity.Endereco;
import com.lurf.gerenciadorPessoasAPI.entity.Pessoa;
import com.lurf.gerenciadorPessoasAPI.repository.EnderecoRepository;
import com.lurf.gerenciadorPessoasAPI.repository.PessoaRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository ;
	
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);	
	}
	
	public List<Endereco> listaEnderecos(){
		
		return enderecoRepository.findAll();
	}
	
	public Optional<Endereco> buscarPorId(Long id){
		return enderecoRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		enderecoRepository.deleteById(id);
	}
}
