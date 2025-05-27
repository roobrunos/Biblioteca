package com.rodrigo.bibliotecan1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    
    public Long getId() { 
        return id; }
    public void setId(Long id) { 
        
        this.id = id;}

    public String getTitulo() { 
        return titulo;   }
    public void setTitulo(String titulo) { 
        this.titulo = titulo;   }

    public String getAutor() { 
        return autor; }
    public void setAutor(String autor) { 
        
        this.autor = autor;   }

    public String getEditora() { 
        return editora; }
    public void setEditora(String editora) { this.editora = editora;      }

    public int getAnoPublicacao() { 
        
        return anoPublicacao; }

    public void setAnoPublicacao(int anoPublicacao) { 
        
        this.anoPublicacao = anoPublicacao; 
    }




}

