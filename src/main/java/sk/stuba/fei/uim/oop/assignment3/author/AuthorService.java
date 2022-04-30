package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.InterfaceBookService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements  InterfaceAuthorService{

    private final AuthorRepository repository;
    private final InterfaceBookService bookService;

    @Autowired
    public AuthorService(AuthorRepository repository, InterfaceBookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
        this.repository.save(new Author("Tomas"));
        this.repository.save(new Author("Jakub"));
        this.repository.save(new Author("Fero"));
    }


    @Override
    public List<Author> getAllAuthors() {
        return this.repository.findAll();
    }

    @Override
    public Author addBookToAuthor(Long bookId, Long authorId) {
        Optional<Author> authorOptional = this.repository.findById(authorId);
        Author author = authorOptional.get();
        Book book = bookService.getById(bookId);
        author.getBooks().add(book);
        return this.repository.save(author);
    }
}
