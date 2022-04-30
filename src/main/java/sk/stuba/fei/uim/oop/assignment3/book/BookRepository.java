package sk.stuba.fei.uim.oop.assignment3.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    List<Book> findBookByName(String name);

    Book findBookById(Long id);
}
