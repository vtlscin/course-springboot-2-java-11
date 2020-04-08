/**
 * 
 */
package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
