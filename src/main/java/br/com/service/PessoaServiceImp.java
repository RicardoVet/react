package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Pessoa;

@Service
public class PessoaServiceImp implements PessoaService{

	@Autowired
	private Repository repository;
	
	@Override
	public Pessoa add(Pessoa pessoa) {
		return this.repository.save(pessoa);
	}

	@Override
	public Pessoa listOne(long id) {
		return this.repository.getOne(id);
	}
}
