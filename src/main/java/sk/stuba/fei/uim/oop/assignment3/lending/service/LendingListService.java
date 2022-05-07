package sk.stuba.fei.uim.oop.assignment3.lending.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.BookID;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendingListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LendingListService implements InterfaceLendingListService {

    private final LendingListRepository lendingListRepository;

    private final BookRepository bookRepository;

    @Autowired
    public LendingListService(LendingListRepository lendingListRepository, BookRepository bookRepository) {
        this.lendingListRepository = lendingListRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<LendList> getAllLendingLists() {
        return lendingListRepository.findAll();
    }

    @Override
    public LendList getById(Long id) {
        return lendingListRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public LendList createLending() {
        return this.lendingListRepository.save(new LendList());
    }

    @Override
    public void deleteLendingList(Long id) {
        LendList lendList = lendingListRepository.findById(id).orElseThrow(NotFoundException::new);
        lendingListRepository.delete(lendList);
    }

    @Override
    public LendList addBookToList(Long listId, BookID bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId.getId());
        Book book = bookOptional.orElseThrow(NotFoundException::new);
        LendList lendList = lendingListRepository.findById(listId).orElseThrow(NotFoundException::new);
        lendList.getLendingLists().add(book);
        return lendingListRepository.save(lendList);
    }

    @Override
    public void removeBookFromLendingList(Long listId, BookID bookId) {
        Book book = bookRepository.findById(bookId.getId()).orElseThrow(NotFoundException::new);
        LendList lendList = lendingListRepository.findById(listId).orElseThrow(NotFoundException::new);
        lendList.getLendingLists().remove(book);
        lendingListRepository.save(lendList);
    }

    @Override
    public void lendList(Long listId) {
        LendList lendList = lendingListRepository.findById(listId).orElseThrow(NotFoundException::new);
        lendList.setLended(true);
        lendingListRepository.save(lendList);
    }
}
