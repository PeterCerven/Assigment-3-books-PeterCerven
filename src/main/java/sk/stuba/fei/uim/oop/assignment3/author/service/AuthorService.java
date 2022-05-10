package sk.stuba.fei.uim.oop.assignment3.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements InterfaceAuthorService {

    private final AuthorRepository authorRepository;


    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author createAuthor(AuthorRequest request) {
        return this.authorRepository.save(new Author(request));
    }

    @Override
    public Author getAuthor(Long id) throws NotFoundException {
        return this.authorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Author updateAuthor(Long id, AuthorRequest body) throws NotFoundException {
        Optional<Author> authorOptional = this.authorRepository.findById(id);
        Author author = authorOptional.orElseThrow(NotFoundException::new);
        if (body.getName() != null) {
            author.setName(body.getName());
        }
        if (body.getSurname() != null) {
            author.setSurname(body.getSurname());
        }
        return this.authorRepository.save(author);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        this.authorRepository.delete(this.authorRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public Author findAuthorById(Long id) throws NotFoundException {
        Optional<Author> authorOptional = authorRepository.findById(id);
        return authorOptional.orElseThrow(NotFoundException::new);
    }


}
