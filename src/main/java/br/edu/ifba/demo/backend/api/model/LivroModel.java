package br.edu.ifba.demo.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "livro")
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long id_livro;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "editora")
    private String editora;

    @Column(name = "ano_publicacao")
    private Integer ano_publicacao;

    @ManyToOne
    @JoinColumn(name = "genero_id_genero", nullable = false)
    private GeneroModel genero;
    
    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "num_paginas")
    private Integer num_paginas;

    @Column(name = "sinopse")
    private String sinopse;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "data_cadastro")
    private LocalDateTime data_cadastro;

    @Column(name = "preco")
    private Double preco;
}