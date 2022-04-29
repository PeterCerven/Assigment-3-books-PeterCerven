package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    List<Book> findBookByName(String name);
}
