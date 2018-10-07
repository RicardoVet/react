package br.com.service;

import br.com.model.Pessoa;

public interface PessoaService {

	public Pessoa add(Pessoa pessoa);
	
	public Pessoa listOne(long id);
}
