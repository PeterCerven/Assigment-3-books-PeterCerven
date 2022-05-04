package sk.stuba.fei.uim.oop.assignment3.lending.bodies;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class LendingListRequest {
    private List<Book> lendingList;
    private boolean lended;


}
