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
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
	public String teste() {
		return "Testando Rota Livro - As outras rotas estão em Camel case, ex: findById, findByTitulo, findByIsbn";
	}

    // Método para listar todos os livros
    @GetMapping("/listAll")
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
        try {
            System.out.println("Livro recebido no backend: " + livro);
            LivroModel save = livroRepository.save(livro);
    
            return new ResponseEntity<>(new LivroDTO(save), HttpStatus.CREATED);
        } catch (Exception e) {
            // Registra o erro no console
            System.err.println("Erro ao salvar livro: " + e.getMessage());
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
