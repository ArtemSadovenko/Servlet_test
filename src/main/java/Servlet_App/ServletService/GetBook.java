package Servlet_App.ServletService;

import Servlet_App.Book;
import Servlet_App.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getBook", value = "/all")
public class GetBook extends HttpServlet {
    @Autowired
    private BookRepo bookRepo;

    protected void
    processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();

        List<Book> list = bookRepo.getAll();

        if (list != null) {
            // iterating through the list of Users
            // And getting username and id of users.
            for (Book book : list) {
                out.print("<tr><td>" + book.getId()
                        + "</td><td>" + book.getName()
                        + "</td><td>" + book.getAuthor()
                        + "</td></tr>");
            }
        }

        // override the supertype method post
//        @Override
//        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
//        ServletException, IOException {
//        }
    }
}
