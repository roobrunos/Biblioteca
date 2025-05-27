
package com.rodrigo.bibliotecan1.service;

import com.rodrigo.bibliotecan1.modelo.Emprestimo;
import com.rodrigo.bibliotecan1.modelo.Livro;
import com.rodrigo.bibliotecan1.modelo.StatusEmprestimo;
import com.rodrigo.bibliotecan1.modelo.Usuario;
import com.rodrigo.bibliotecan1.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Emprestimo realizarEmprestimo(Emprestimo emprestimo) {
        Livro livro = emprestimo.getLivro();
        Usuario usuario = emprestimo.getUsuario();

        if (emprestimoRepository.existsByLivroAndStatus(livro, StatusEmprestimo.EMPRESTADO)) {
            throw new RuntimeException("O livro ja está emprestado.");
        }

        if (emprestimoRepository.countByUsuarioAndStatus(usuario, StatusEmprestimo.EMPRESTADO) >= 3) {
            throw new RuntimeException("O usuario ja possui 3 livros emprestados.");
        }

        emprestimo.setStatus(StatusEmprestimo.EMPRESTADO);
        emprestimo.setDataEmprestimo(LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolver(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));

        emprestimo.setStatus(StatusEmprestimo.DEVOLVIDO);
        return emprestimoRepository.save(emprestimo);
    }
}

