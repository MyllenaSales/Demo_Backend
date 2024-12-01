package br.edu.ifba.demo.backend.api.controller;

import br.edu.ifba.demo.backend.api.dto.LivroDTO;
import br.edu.ifba.demo.backend.api.model.LivroModel;
import br.edu.ifba.demo.backend.api.repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
	public String teste() {
		return "Testando Rota Livro";
	}

    @GetMapping("/debug/{id}") 
    public String debugFindById(@PathVariable Long id) {
    return livroRepository.findById(id).toString();
    }

    @GetMapping("/testRepository/{id}")
    public String testRepository(@PathVariable Long id) {
    Optional<LivroModel> livro = livroRepository.findById(id);
    return livro.isPresent() ? "Livro encontrado: " + livro.get().getTitulo() : "Livro não encontrado";
    }


    // Método para listar todos os livros
    @GetMapping("/listall")
    public List<LivroModel> listAll() {
        return livroRepository.findAll();
    }

    // Método para consultar livro por ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable("id") Long id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.map(l -> ResponseEntity.ok(new LivroDTO(l)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para consultar livro por ISBN
    @GetMapping("/findByIsbn/{isbn}")
    public ResponseEntity<LivroDTO> findByIsbn(@PathVariable("isbn") String isbn) {
        Optional<LivroModel> livro = livroRepository.findByIsbn(isbn);
        return livro.map(l -> ResponseEntity.ok(new LivroDTO(l)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para consultar livro por título
    @GetMapping("/findByTitulo/{titulo}")
    public ResponseEntity<LivroDTO> findByTitulo(@PathVariable("titulo") String titulo) {
        Optional<LivroModel> livro = livroRepository.findByTitulo(titulo);
        return livro.map(l -> ResponseEntity.ok(new LivroDTO(l)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para adicionar um novo livro
    @PostMapping
    public ResponseEntity<LivroDTO> addLivro(@RequestBody LivroModel livro) {
        LivroModel savedLivro = livroRepository.save(livro);
        return new ResponseEntity<>(new LivroDTO(savedLivro), HttpStatus.CREATED);
    }

    // Método para excluir um livro
    @DeleteMapping("/{id_livro}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id_livro) {
        if (livroRepository.existsById(id_livro)) {
            livroRepository.deleteById(id_livro);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
