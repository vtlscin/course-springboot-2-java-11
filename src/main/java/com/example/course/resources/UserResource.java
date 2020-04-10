/**
 * 
 */
package com.example.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.course.entities.User;
import com.example.course.services.UserService;

/**
 * @author vinic
 * Classe que disponibiliza recursos web para a entidade User.
 */
@RestController //Recurso web implementado por um controlador rest
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//Tipo especifico do spring para retornar respostas web
	@GetMapping // indica que o metodo responde a requisicao tipo get 
	public ResponseEntity<List<User>> findAll()
	{
		List<User> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * @param Uma resposta 201 retorna um uri que é o endereco do objeto inserido
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<User> insert(@RequestBody User obj)
	{
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		service.delete(id);
		return ResponseEntity.noContent().build(); //para respostas sem corpo codigo 204
	}
}
