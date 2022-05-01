package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public AuthorResponse createAuthor(@RequestBody AuthorRequest author) {
        return new AuthorResponse(authorService.createAuthor(author));
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
