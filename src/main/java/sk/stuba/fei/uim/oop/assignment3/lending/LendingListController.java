package sk.stuba.fei.uim.oop.assignment3.lending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.author.AuthorResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingListController {

    private final InterfaceLendingListService lendingListService;

    @Autowired
    public LendingListController(InterfaceLendingListService lendingListService) {
        this.lendingListService = lendingListService;
    }
    @GetMapping
    public List<LendingListResponse> getAllLendingLists(){
        return lendingListService.getAllAuthors().stream().map(LendingListResponse::new).collect(Collectors.toList());
    }
}
