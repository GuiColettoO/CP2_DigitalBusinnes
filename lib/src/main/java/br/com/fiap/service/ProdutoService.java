package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.Entity.ProdutoEntity;
import br.com.fiap.principal.Produto;
import br.com.fiap.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto saveProduto(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity(produto);
		produtoRepository.save(produtoEntity);
		return produto;
	}
	
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll()
					.stream().map(entity -> new Produto(entity)).toList();
	}
	
	public Produto findById(Long uuid) {
		 Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(uuid);
		 if(produtoEntity.isPresent()) {
			 return new Produto(produtoEntity.get());
		 } 
		 return null;
	}

	public Produto updateProduto(Produto newProduto, Long uuid) {
		Optional<ProdutoEntity> produtoEntityOptional = produtoRepository.findById(uuid);
		if(produtoEntityOptional.isPresent()) {
			ProdutoEntity produtoEntity = produtoEntityOptional.get();
			produtoEntity.setNome(newProduto.getNome());
			produtoEntity.setDataCadastro(newProduto.getDataCadastro());
			produtoEntity.setDataAtualizacao(newProduto.getDataAtualizacao());
			produtoEntity.setProdutoHabilitado(newProduto.isProdutoHabilitado());
			produtoRepository.save(produtoEntity);
			return newProduto;
		}
		return null;
		
	}

	public Produto deleteProduto(Long uuid) {
		Optional<ProdutoEntity> produtoEntityOptional = produtoRepository.findById(uuid);
		if(produtoEntityOptional.isPresent()) {
			ProdutoEntity produtoEntity = produtoEntityOptional.get();
			produtoRepository.delete(produtoEntity);
			return new Produto(produtoEntity);
		}
		return null;
	}
}
