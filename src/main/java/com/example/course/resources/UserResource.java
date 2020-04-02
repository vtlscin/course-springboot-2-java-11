/**
 * 
 */
package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;

/**
 * @author vinic
 * Classe que disponibiliza recursos web para a entidade User.
 */
@RestController //Recurso web implementado por um controlador rest
@RequestMapping(value = "/users")
public class UserResource {

	//Tipo especifico do spring para retornar respostas web
	@GetMapping // indica que o metodo responde a requisicao tipo get 
	public ResponseEntity<User> findAll()
	{
		User u = new User(1L, "maria", "maria@gmail.com", "99999999", "123456");
		return ResponseEntity.ok().body(u);
	}
	
}
