package br.com.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Pessoa;

public interface Repository extends JpaRepository<Pessoa, Long>{

}
