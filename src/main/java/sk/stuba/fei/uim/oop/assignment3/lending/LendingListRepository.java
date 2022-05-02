package sk.stuba.fei.uim.oop.assignment3.lending;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

import java.util.List;

@Repository
public interface LendingListRepository extends CrudRepository <LendingList, Long> {
    List<LendingList> findAll();
}
