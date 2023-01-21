package com.lurf.gerenciadorPessoasAPI.http.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lurf.gerenciadorPessoasAPI.entity.Pessoa;
import com.lurf.gerenciadorPessoasAPI.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa salvar(@RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> listaPessoas() {
		return pessoaService.listaPessoas();
	}

	@GetMapping("/id")
	@ResponseStatus(HttpStatus.OK)
	public Pessoa buscarPessoaPorID(@PathVariable("/id") Long id) {
		return pessoaService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não Encontrada"));
	}
	
	
	@DeleteMapping("/id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPessoa(@PathVariable("/id") Long id) {
		pessoaService.buscarPorId(id)
		.map(pessoa -> {
			pessoaService.removerPorId(pessoa.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não Encontrada"));
	}
	
	
	
	@PutMapping("id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPessoa(@PathVariable("/id") Long id, @RequestBody Pessoa pessoa) {
		pessoaService.buscarPorId(id)
		.map(pessoaBase -> {
			modelMapper.map(pessoa, pessoaBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não Encontrada"));
	}
	
}
