package sk.stuba.fei.uim.oop.assignment3.author.service;

import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.bodies.AuthorRequest;

import java.util.List;

public interface InterfaceAuthorService {
    List<Author> getAllAuthors();

    Author createAuthor(AuthorRequest author);

    Author getAuthor(Long id);

    Author updateAuthor(Long id, AuthorRequest body);

    void delete(Long id);
}
