package br.com.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.model.Pessoa;
import br.com.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping("/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pessoa add(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva= this.pessoaService.add(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pessoa/save/{codigo}")
				.buildAndExpand(pessoa.getId()).toUri();
		response.setHeader("location", uri.toString());
		return pessoaSalva;
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Pessoa> listOne(@PathVariable long id, HttpServletResponse response) {
		Pessoa pessoaEncontrada =  this.pessoaService.listOne(id);
		return pessoaEncontrada == null?ResponseEntity.ok().build():ResponseEntity.notFound().build();
	}
}
