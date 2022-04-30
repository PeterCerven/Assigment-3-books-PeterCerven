package sk.stuba.fei.uim.oop.assignment3.author;

import java.util.List;

public interface InterfaceAuthorService {
    List<Author> getAllAuthors();
    Author addBookToAuthor(Long bookId, Long authorId);
}
