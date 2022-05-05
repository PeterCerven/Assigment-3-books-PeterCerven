package sk.stuba.fei.uim.oop.assignment3.lending.service;

import sk.stuba.fei.uim.oop.assignment3.lending.bodies.BookID;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.LendingListRequest;

import java.util.List;

public interface InterfaceLendingListService {

    List<LendList> getAllLendingLists();

    LendList getById(Long id);

    LendList createLending();

    void deleteLendingList(Long id);

    LendList addBookToList(Long listId, BookID bookId);

    void removeBookFromLendingList(Long listId, BookID bookId);

    void lendList(Long listId);
}
