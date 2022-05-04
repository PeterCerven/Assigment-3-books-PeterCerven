package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.bodies.AuthorResponse;
import sk.stuba.fei.uim.oop.assignment3.author.service.InterfaceAuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final InterfaceAuthorService authorService;

    @Autowired
    public AuthorController(InterfaceAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest author) {
        return new ResponseEntity<>(new AuthorResponse(authorService.createAuthor(author)), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public AuthorResponse getAuthorWithId(@PathVariable("id") Long authorId) {
        return new AuthorResponse(this.authorService.getAuthor(authorId));
    }

    @PutMapping({"/{id}"})
    public AuthorResponse updateAuthor(@PathVariable("id") Long authorId, @RequestBody AuthorRequest body) {
        return new AuthorResponse(this.authorService.updateAuthor(authorId, body));
    }

    @DeleteMapping({"/{id}"})
    public void deleteAuthor(@PathVariable("id") Long authorId) {
        this.authorService.delete(authorId);
    }
}
