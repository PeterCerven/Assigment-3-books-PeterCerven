package sk.stuba.fei.uim.oop.assignment3.lending;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import java.util.List;

@Setter
@Getter
public class LendingListRequest {
    private List<Book> temporaryLendingList;
    private boolean lended;
}
