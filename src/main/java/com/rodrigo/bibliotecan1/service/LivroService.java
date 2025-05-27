package com.rodrigo.bibliotecan1.service;

import com.rodrigo.bibliotecan1.modelo.Livro;
import com.rodrigo.bibliotecan1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro criar(Livro livro) {
        return livroRepository.save(livro);
    }

    public ResponseEntity<Livro> atualizar(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            return ResponseEntity.ok(livroRepository.save(livro));
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deletar(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

