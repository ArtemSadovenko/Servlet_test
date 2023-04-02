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

@WebServlet(name = "saveBook", value = "/add")
public class SaveBook extends HttpServlet {
    //private static long currentId = 0;
    @Autowired
    private BookRepo bookRepo;

    protected void
    processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    // override the supertype method post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String author = request.getParameter("author");

        // Instances of User class
        Book book = new Book(-1, name, author);


        bookRepo.addBook(book);

        // check if the values correspond to the one
        // specified
            out.print(" < p > Record saved successfully ! </p > ");
            request.getRequestDispatcher("index.html")
                    .include(request, response);

        // close database connection
        out.close();
    }
}

