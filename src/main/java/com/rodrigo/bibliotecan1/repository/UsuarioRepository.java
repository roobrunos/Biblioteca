package com.rodrigo.bibliotecan1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.bibliotecan1.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
