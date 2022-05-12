package sk.stuba.fei.uim.oop.assignment3.author.service;

import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;

public interface InterfaceAuthorService {
    List<Author> getAllAuthors();

    Author createAuthor(AuthorRequest author);

    Author getAuthor(Long id) throws NotFoundException;

    Author updateAuthor(Long id, AuthorRequest body) throws NotFoundException;

    void delete(Long id) throws NotFoundException;
}
