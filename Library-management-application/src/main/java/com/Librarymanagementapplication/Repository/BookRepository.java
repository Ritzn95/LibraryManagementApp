package com.Librarymanagementapplication.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.Librarymanagementapplication.Model.Book;

import jakarta.annotation.Resource;

@Repository
public class BookRepository {
	
	final String hashReference= "Book";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    HashOperations<String, String, Book> hashOperations;

    public void saveBook(Book emp) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, emp.getBookId(), emp);
    }

    public void saveAllBooks(Map<String, Book> map) {
        hashOperations.putAll(hashReference, map);
    }

    public Book getOneBook(String bookId) {
       return hashOperations.get(hashReference, bookId);
    }

    public void updateBook(Book emp) {
       hashOperations.put(hashReference, emp.getBookId(), emp);
    }

    public List<Book> getAllBooks() {
       Map<String, Book> temp =  hashOperations.entries(hashReference);
       List<Book> books = new ArrayList<Book>(temp.values());
       return books;
    }

    public void deleteBook(String id) {
       hashOperations.delete(hashReference, id);
    }


}
