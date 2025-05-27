package com.rodrigo.bibliotecan1.controller;

import com.rodrigo.bibliotecan1.Usuario;
import com.rodrigo.bibliotecan1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll(  );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity:: ok)
                      .orElseGet(  () -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setCurso(usuarioAtualizado.getCurso());
            usuario.setMatricula(usuarioAtualizado.getMatricula());

            return ResponseEntity.ok(usuarioRepository.save(usuario));
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }
}

