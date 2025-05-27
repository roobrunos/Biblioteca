package com.rodrigo.bibliotecan1.repository;

import com.rodrigo.bibliotecan1.modelo.Emprestimo;
import com.rodrigo.bibliotecan1.modelo.Livro;
import com.rodrigo.bibliotecan1.modelo.StatusEmprestimo;
import com.rodrigo.bibliotecan1.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    boolean existsByLivroAndStatus(Livro livro, StatusEmprestimo status);

    long countByUsuarioAndStatus(Usuario usuario, StatusEmprestimo status);
}
  