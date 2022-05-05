package sk.stuba.fei.uim.oop.assignment3.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements InterfaceAuthorService {

    private final AuthorRepository repository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Author> getAllAuthors() {
        return this.repository.findAll();
    }


    @Override
    public Author createAuthor(AuthorRequest request) {
        return this.repository.save(new Author(request));
    }

    @Override
    public Author getAuthor(Long id) {
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Author updateAuthor(Long id, AuthorRequest body) {
        Optional<Author> authorOptional = this.repository.findById(id);
        Author author = authorOptional.orElseThrow(NotFoundException::new);
        if (body.getName() != null) {
            author.setName(body.getName());
        }
        if (body.getSurname() != null) {
            author.setSurname(body.getSurname());
        }
        return this.repository.save(author);
    }

    @Override
    public void delete(Long id) {
        Optional<Author> authorOptional = this.repository.findById(id);
        Author author = authorOptional.orElseThrow(NotFoundException::new);
        if (!author.getBooks().isEmpty()){
            this.bookRepository.deleteAll(author.getBooks());
        }
        this.repository.delete(author);
    }


}
