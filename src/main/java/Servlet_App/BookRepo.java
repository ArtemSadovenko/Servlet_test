package Servlet_App;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookRepo {
    @Autowired
    private List<Book> books;
    private static long currentId = -1;

    public void addBook(Book book){
        book.setId(currentId++);
        books.add(book);
    }

    public Book gatBook(long id){
        return books.stream()
                .filter(e ->(e.getId() == id))
                .findFirst()
                .get();
    }

    public List<Book> getAll(){
        return books;
    }
}
