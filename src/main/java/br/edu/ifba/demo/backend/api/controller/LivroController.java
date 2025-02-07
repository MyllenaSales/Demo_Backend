package br.edu.ifba.demo.backend.api.controller;

import br.edu.ifba.demo.backend.api.dto.LivroDTO;
import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.model.LivroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;
import br.edu.ifba.demo.backend.api.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;
    private final GeneroRepository generoRepository;

    public LivroController(LivroRepository livroRepository, GeneroRepository generoRepository) {
        this.livroRepository = livroRepository;
        this.generoRepository = generoRepository;
    }

    @PostMapping
    public ResponseEntity<LivroDTO> addLivro(@RequestBody LivroModel livro) {
        Optional<GeneroModel> genero = generoRepository.findById(livro.getGenero().getId_genero());
        if (genero.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        livro.setGenero(genero.get());
        LivroModel savedLivro = livroRepository.save(livro);
        return ResponseEntity.ok(new LivroDTO(savedLivro));
    }
    
@PutMapping("/update/{id}")
public ResponseEntity<LivroDTO> updateLivro(@PathVariable Long id, @RequestBody LivroModel livro) {
    Optional<LivroModel> existingLivro = livroRepository.findById(id);
    if (existingLivro.isPresent()) {
        LivroModel livroToUpdate = existingLivro.get();
        livroToUpdate.setTitulo(livro.getTitulo());
        livroToUpdate.setAutor(livro.getAutor());
        livroToUpdate.setEditora(livro.getEditora());
        livroToUpdate.setAno_publicacao(livro.getAno_publicacao());
        livroToUpdate.setGenero(livro.getGenero());
        livroToUpdate.setIsbn(livro.getIsbn());
        livroToUpdate.setNum_paginas(livro.getNum_paginas());
        livroToUpdate.setSinopse(livro.getSinopse());
        livroToUpdate.setIdioma(livro.getIdioma());
        livroToUpdate.setPreco(livro.getPreco());

        LivroModel updatedLivro = livroRepository.save(livroToUpdate);
        return ResponseEntity.ok(new LivroDTO(updatedLivro));
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @GetMapping
	public String teste() {
		return "Testando Rota Livro - As outras rotas estão em Camel case, ex: findById, findByTitulo, findByIsbn";
	}

    @GetMapping("/listAll")
    public List<LivroModel> listAll() {
        return livroRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable("id") Long id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.map(l -> ResponseEntity.ok(new LivroDTO(l)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByIsbn/{isbn}")
    public ResponseEntity<LivroDTO> findByIsbn(@PathVariable("isbn") String isbn) {
        Optional<LivroModel> livro = livroRepository.findByIsbn(isbn);
        return livro.map(l -> ResponseEntity.ok(new LivroDTO(l)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByTitulo/{titulo}")
    public ResponseEntity<LivroDTO> findByTitulo(@PathVariable("titulo") String titulo) {
        Optional<LivroModel> livro = livroRepository.findByTitulo(titulo);
        return livro.map(l -> ResponseEntity.ok(new LivroDTO(l)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id_livro}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id_livro) {
        Optional<LivroModel> livro = livroRepository.findById(id_livro);
        
        if (livro.isPresent()) {
            livroRepository.delete(livro.get());
            System.out.println("Livro deletado com sucesso, ID: " + id_livro); 
            return ResponseEntity.noContent().build();
        } else {
            System.out.println("Livro não encontrado, ID: " + id_livro); 
            return ResponseEntity.notFound().build(); 
        }
    }    

    
}
