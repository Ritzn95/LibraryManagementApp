package com.Librarymanagementapplication.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Librarymanagementapplication.Model.Book;
import com.Librarymanagementapplication.Services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="api/v1/AddNewBook", method = RequestMethod.POST)
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		bookService.createBook(book);
		return new ResponseEntity<>("the book is added successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/v1/GetAllBooks", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> bookList = bookService.getBooks();
			return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
}
