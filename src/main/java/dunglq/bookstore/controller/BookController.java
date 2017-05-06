package dunglq.bookstore.controller;

import dunglq.bookstore.model.Book;
import dunglq.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(value = {"/books"})
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "")
    public String home(Map<String, Object> model) {
        List<Book> books = StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.put("books", books);
        return "books";
    }
}