package br.com.gustavoantunes.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoantunes.loja.controller.dto.CompraDTO;
import br.com.gustavoantunes.loja.model.Compra;
import br.com.gustavoantunes.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public Compra realizaCompra(@RequestBody  CompraDTO compra) {
		return compraService.realizaCompra(compra);
	}
	
	@GetMapping("/{id}")
	public Compra getById(@PathVariable("id") Long id) {
		return compraService.getById(id);
	}
	
}
