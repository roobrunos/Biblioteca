package com.rodrigo.bibliotecan1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.bibliotecan1.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}







