package Servlet_App;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookRepo {
    @Autowired
    private List<Book> books;

    public void addBook(Book book){
        books.add(book);
    }

    public Book gatBook(long id){
        return books.stream()
                .filter(e ->(e.getId() == id))
                .findFirst()
                .get();
    }
}
