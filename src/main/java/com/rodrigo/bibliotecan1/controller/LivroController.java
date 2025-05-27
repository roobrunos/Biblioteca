package com.rodrigo.bibliotecan1.controller;


import com.rodrigo.bibliotecan1.Livro;
import com.rodrigo.bibliotecan1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listar(){
        return livroRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Livro criar(@RequestBody Livro livro)   {
        return livroRepository.save(livro);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado){
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            Livro atualizado = livroRepository.save(livro);
            return ResponseEntity.ok(atualizado);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());


    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();
    }

    
}


