package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.Entity.UsuarioEntity;
import br.com.fiap.principal.Usuario;
import br.com.fiap.repository.UsuarioRepository;

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario saveUsuario(Usuario usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
		return usuario;
	}
	
	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll()
					.stream().map(entity -> new Usuario(entity)).toList();
	}
	
	public Usuario findById(Long uuid) {
		 Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(uuid);
		 if(usuarioEntity.isPresent()) {
			 return new Usuario(usuarioEntity.get());
		 } 
		 return null;
	}

	public Usuario updateUsuario(Usuario newUsuario, Long uuid) {
		Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(uuid);
		if(usuarioEntityOptional.isPresent()) {
			UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
			usuarioEntity.setNome(newUsuario.getNome());
			usuarioEntity.setEmail(newUsuario.getEmail());
			usuarioEntity.setNomeMae(newUsuario.getNomeMae());
			usuarioEntity.setSenha(newUsuario.getSenha());
			usuarioEntity.setTelefone(newUsuario.getTelefone());
			usuarioEntity.setIdade(newUsuario.getIdade());
			usuarioEntity.setEnderecoCompleto(newUsuario.getEnderecoCompleto());
			usuarioEntity.setCpf(newUsuario.getCpf());
			usuarioEntity.setRg(newUsuario.getRg());
			usuarioEntity.setPoliticamenteExposta(newUsuario.isPoliticamenteExposta());
			usuarioEntity.setRendaMensal(newUsuario.getRendaMensal());
			usuarioEntity.setValorPatrimonio(newUsuario.getValorPatrimonio());
			usuarioEntity.setDataCadastro(newUsuario.getDataCadastro());
			usuarioEntity.setDataAtualizacao(newUsuario.getDataAtualizacao());
			usuarioEntity.setListaProduto(newUsuario.getListaProduto());
			usuarioEntity.setTipo(newUsuario.getTipo());
			usuarioRepository.save(usuarioEntity);
			return newUsuario;
		}
		return null;
		
	}

	public Usuario deleteUsuario(Long uuid) {
		Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(uuid);
		if(usuarioEntityOptional.isPresent()) {
			UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
			usuarioRepository.delete(usuarioEntity);
			return new Usuario(usuarioEntity);
		}
		return null;
	}
}
