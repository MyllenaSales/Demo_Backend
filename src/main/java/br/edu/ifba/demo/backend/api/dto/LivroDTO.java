package br.edu.ifba.demo.backend.api.dto;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.model.LivroModel;
import java.io.Serializable;
import java.time.LocalDateTime;

public class LivroDTO implements Serializable {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private GeneroModel genero;
    private String isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;
    private LocalDateTime data_cadastro;
    private Double preco;

    public LivroDTO() {}

    public LivroDTO(LivroModel livroModel) {
        this.id_livro = livroModel.getId_livro();
        this.titulo = livroModel.getTitulo();
        this.autor = livroModel.getAutor();
        this.editora = livroModel.getEditora();
        this.ano_publicacao = livroModel.getAno_publicacao();
        this.genero = livroModel.getGenero();
        this.isbn = livroModel.getIsbn();
        this.num_paginas = livroModel.getNum_paginas();
        this.sinopse = livroModel.getSinopse();
        this.idioma = livroModel.getIdioma();
        this.data_cadastro = livroModel.getData_cadastro();
        this.preco = livroModel.getPreco();
    }

    public Long getId_livro() {
        return id_livro;
    }

    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public GeneroModel getGenero() {
        return genero;
    }

    public void setGenero(GeneroModel genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(Integer num_paginas) {
        this.num_paginas = num_paginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
