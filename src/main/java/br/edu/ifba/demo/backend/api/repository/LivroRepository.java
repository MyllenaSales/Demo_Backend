package br.edu.ifba.demo.backend.api.repository;

import br.edu.ifba.demo.backend.api.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    Optional<LivroModel> findByIsbn(String isbn);
    Optional<LivroModel> findByTitulo(String titulo);
}



