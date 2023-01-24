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

import com.lurf.gerenciadorPessoasAPI.entity.Endereco;
import com.lurf.gerenciadorPessoasAPI.entity.Pessoa;
import com.lurf.gerenciadorPessoasAPI.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco salvar(@RequestBody Endereco endereco) {
		return enderecoService.salvar(endereco);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Endereco> listaEnderecos() {
		return enderecoService.listaEnderecos();
	}

	@GetMapping("/id")
	@ResponseStatus(HttpStatus.OK)
	public Endereco buscarPessoaPorID(@PathVariable("/id") Long id) {
		return enderecoService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não Encontrada"));
	}
	
	
	@DeleteMapping("/id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPessoa(@PathVariable("/id") Long id) {
		enderecoService.buscarPorId(id)
		.map(pessoa -> {
			enderecoService.removerPorId(pessoa.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não Encontrada"));
	}
	
	@PutMapping("id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarEndereco(@PathVariable("/id") Long id, @RequestBody Endereco endereco) {
		enderecoService.buscarPorId(id)
		.map(enderecoBase -> {
			modelMapper.map(endereco, enderecoBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não Encontrada"));
	}
}
