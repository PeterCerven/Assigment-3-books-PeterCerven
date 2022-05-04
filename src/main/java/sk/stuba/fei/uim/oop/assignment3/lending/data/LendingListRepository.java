package sk.stuba.fei.uim.oop.assignment3.lending.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendingListRepository extends CrudRepository<LendList, Long> {
    List<LendList> findAll();
}
