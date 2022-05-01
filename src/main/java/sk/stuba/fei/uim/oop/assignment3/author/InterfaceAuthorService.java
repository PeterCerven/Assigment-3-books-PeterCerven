package sk.stuba.fei.uim.oop.assignment3.author;

import java.util.List;

public interface InterfaceAuthorService {
    List<Author> getAllAuthors();

    Author createAuthor(AuthorRequest author);

    Author getAuthor(Long id);

    Author updateAuthor(Long id, AuthorRequest body);

    void delete(Long id);
}
