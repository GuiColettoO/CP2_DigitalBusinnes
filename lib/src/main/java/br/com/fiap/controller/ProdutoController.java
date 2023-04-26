package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.principal.Produto;
import br.com.fiap.service.ProdutoService;
import jakarta.annotation.PostConstruct;

public class ProdutoController {
	
	private List<Produto> produtoList = new ArrayList<>();
	
	@Autowired
	private ProdutoService produtoService;

	@PostConstruct
	private void postConstruct() {
		Produto Laranja = new Produto("Laranja", Calendar.getInstance(), Calendar.getInstance(), true);
		Produto Chocolate = new Produto("Chocolate", Calendar.getInstance(), Calendar.getInstance(), true);
		produtoList.add(Laranja);
		produtoList.add(Chocolate);
	}

	@GetMapping("/produtos")
	ResponseEntity<List<Produto>> all() {
		return ResponseEntity.ok(produtoService.getAllProdutos());
	}

	@PostMapping("/produtos")
	public ResponseEntity<Produto> newProduto(@RequestBody Produto newProduto) {
		validateProduto(newProduto);
		produtoService.saveProduto(newProduto);
		return ResponseEntity.ok(newProduto);
	}

	private void validateProduto(Produto newProduto) {
		if (newProduto.getNome() == null) {
			throw new IllegalArgumentException("Produto without name");
		}

	}

	@GetMapping("/produtos/{uuid}")
	public ResponseEntity<Produto> one(@PathVariable Long uuid) {
		return ResponseEntity.ofNullable(produtoService.findById(uuid));
	}

	@PutMapping("/produtos/{uuid}")
	public ResponseEntity<Produto> replaceProduto(@RequestBody Produto newProduto, @PathVariable Long uuid) {
		Produto produtoUpdated = produtoService.updateProduto(newProduto,uuid);
		return ResponseEntity.ofNullable(produtoUpdated);
	}

	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable Long uuid) {
		return ResponseEntity.ofNullable(produtoService.deleteProduto(uuid));
	}

}
