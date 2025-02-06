package br.edu.ifba.demo.backend.api.repository;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<GeneroModel, Long> {
}