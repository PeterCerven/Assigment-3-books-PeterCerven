package sk.stuba.fei.uim.oop.assignment3.lending.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class LendList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Book> lendingLists;

    private boolean lended;

    public LendList() {
        this.lended = false;
        this.lendingLists = new ArrayList<>();
    }
}
