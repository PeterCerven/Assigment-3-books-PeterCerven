package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.InterfaceBookService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements  InterfaceAuthorService{

    private final AuthorRepository repository;


    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;

    }


    @Override
    public List<Author> getAllAuthors() {
        return this.repository.findAll();
    }

//    @Override
//    public Author addBookToAuthor(Long bookId, Long authorId) {
//        Optional<Author> authorOptional = this.repository.findById(authorId);
//        Author author = authorOptional.orElseThrow();
//        Book book = bookService.getById(bookId);
//        author.getBooks().add(book);
//        return this.repository.save(author);
//    }

    @Override
    public Author createAuthor(AuthorRequest request) {
        return this.repository.save(new Author(request));
    }

    @Override
    public Author getAuthor(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public Author updateAuthor(Long id, AuthorRequest body) {
        Optional<Author> authorOptional = this.repository.findById(id);
        Author author = authorOptional.orElseThrow();
        if (body.getName() != null){
            author.setName(body.getName());
        }
        if (body.getSurname() != null){
            author.setSurname(body.getSurname());
        }
        return this.repository.save(author);
    }

    @Override
    public void delete(Long id) {
        Optional<Author> authorOptional = this.repository.findById(id);
        Author author = authorOptional.orElseThrow();
        this.repository.delete(author);
    }


}
