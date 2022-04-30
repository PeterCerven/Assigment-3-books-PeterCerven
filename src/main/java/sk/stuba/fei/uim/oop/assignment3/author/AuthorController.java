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
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAllAuthors().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }
    @PutMapping("/{bookId}")
    public AuthorResponse addBookToAuthor(@PathVariable Long bookId, @RequestParam("author") Long authorId){
        return new AuthorResponse((this.authorService.addBookToAuthor(bookId, authorId)));
    }
}
