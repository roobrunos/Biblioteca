package com.rodrigo.bibliotecan1.controller;


import com.rodrigo.bibliotecan1.modelo.Emprestimo;
import com.rodrigo.bibliotecan1.repository.EmprestimoRepository;
import com.rodrigo.bibliotecan1.service.EmprestimoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping
    public List<Emprestimo> listar() {
        return emprestimoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> emprestar(@RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo novo = emprestimoService.realizarEmprestimo(emprestimo);
            return ResponseEntity.ok(novo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<Emprestimo> devolver(@PathVariable Long id) {
        Emprestimo atualizado = emprestimoService.devolver(id);
        return ResponseEntity.ok(atualizado);
    }
}

