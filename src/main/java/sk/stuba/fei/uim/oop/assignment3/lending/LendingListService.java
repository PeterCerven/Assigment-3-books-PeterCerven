package sk.stuba.fei.uim.oop.assignment3.lending;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingListService implements InterfaceLendingListService{

    private final LendingListRepository repository;

    @Autowired
    public LendingListService(LendingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LendingList> getAllAuthors() {
        return repository.findAll();
    }
}
