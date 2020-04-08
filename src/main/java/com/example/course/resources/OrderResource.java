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

import com.example.course.entities.Order;
import com.example.course.services.OrderService;

/**
 * @author vinic
 * Classe que disponibiliza recursos web para a entidade Order.
 */
@RestController //Recurso web implementado por um controlador rest
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	//Tipo especifico do spring para retornar respostas web
	@GetMapping // indica que o metodo responde a requisicao tipo get 
	public ResponseEntity<List<Order>> findAll()
	{
		List<Order> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id)
	{
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
