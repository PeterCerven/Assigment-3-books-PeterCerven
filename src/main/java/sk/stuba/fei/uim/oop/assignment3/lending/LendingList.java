package sk.stuba.fei.uim.oop.assignment3.lending;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class LendingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @OneToMany
//    private List<Book> lendingList;
    private boolean lended;


}
