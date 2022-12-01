package com.Librarymanagementapplication.Services;

import java.util.List;

import com.Librarymanagementapplication.Model.Book;
import com.Librarymanagementapplication.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public Book getOneBook(String bookId) {
    return bookRepository.getOneBook(bookId);
    }

    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }
    public void createBook(Book book) {
        bookRepository.saveBook(book);
    }

    public void deleteBook(Book book) {
        bookRepository.deleteBook(book.getBookId());
    }

    public void reduceAvailable(String bookId) {
        Book book = bookRepository.getOneBook(bookId);
        book.setNoOfCopiesAvailable(book.getNoOfCopiesAvailable() - 1);
        bookRepository.updateBook(book);
    }

    public void increaseAvailable(String bookId) {
        Book book = bookRepository.getOneBook(bookId);
        book.setNoOfCopiesAvailable(book.getNoOfCopiesAvailable() + 1);
        bookRepository.updateBook(book);
    }
}