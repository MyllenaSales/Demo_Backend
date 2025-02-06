package br.edu.ifba.demo.backend.api.dto;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import java.io.Serializable;

public class GeneroDTO implements Serializable {
    private Long id_genero;
    private String nome_genero;

    public GeneroDTO() {}

    public GeneroDTO(GeneroModel generoModel) {
        this.id_genero = generoModel.getId_genero();
        this.nome_genero = generoModel.getNome_genero();
    }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome_genero() {
        return nome_genero;
    }

    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }
}