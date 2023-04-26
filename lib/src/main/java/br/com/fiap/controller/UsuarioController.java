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

import br.com.fiap.principal.Usuario;
import br.com.fiap.service.UsuarioService;
import jakarta.annotation.PostConstruct;

public class UsuarioController {

	private List<Usuario> produtoList = new ArrayList<>();
	
	@Autowired
	private UsuarioService usuarioService;

	@PostConstruct
	private void postConstruct() {
		Usuario Kleber = new Usuario("Kleber", "Kleber@fiap.com.br", "Jessica", "KL19KL", "11999999999", 34, "rua logo ali", "12312312312","121231231",true, 3000, 120000, Calendar.getInstance(), Calendar.getInstance(), null, null);
		Usuario Joao = new Usuario("João", "João@fiap.com.br", "Carla", "JP19KP", "11949999999", 75, "rua logo ali perto de la", "12312312212","111231231",true, 3030, 420000, Calendar.getInstance(), Calendar.getInstance(), null, null);
		produtoList.add(Kleber);
		produtoList.add(Joao);
	}

	@GetMapping("/usuario")
	ResponseEntity<List<Usuario>> all() {
		return ResponseEntity.ok(usuarioService.getAllUsuario());
	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> newUsuario(@RequestBody Usuario newUsuario) {
		validateUsuario(newUsuario);
		usuarioService.saveUsuario(newUsuario);
		return ResponseEntity.ok(newUsuario);
	}

	private void validateUsuario(Usuario newUsuario) {
		if (newUsuario.getNome() == null) {
			throw new IllegalArgumentException("Usuario without name");
		}

	}

	@GetMapping("/usuario/{uuid}")
	public ResponseEntity<Usuario> one(@PathVariable Long uuid) {
		return ResponseEntity.ofNullable(usuarioService.findById(uuid));
	}

	@PutMapping("/usuario/{uuid}")
	public ResponseEntity<Usuario> replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long uuid) {
		Usuario usuarioUpdated = usuarioService.updateUsuario(newUsuario,uuid);
		return ResponseEntity.ofNullable(usuarioUpdated);
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long uuid) {
		return ResponseEntity.ofNullable(usuarioService.deleteUsuario(uuid));
	}
	
}
