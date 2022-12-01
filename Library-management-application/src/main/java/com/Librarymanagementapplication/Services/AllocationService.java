package com.Librarymanagementapplication.Services;

import com.Librarymanagementapplication.Model.Book;
import com.Librarymanagementapplication.Model.Student;
import com.Librarymanagementapplication.Repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;



    @Autowired
    AllocationRepository allocationRepository;

    public void allocateBook(String bookId, String studentId
                             ) throws Exception {
        Book book = bookService.getOneBook(bookId);
        if (book.getNoOfCopiesAvailable() == 0) {
            throw new Exception("no books available");
        }

        Student student = studentService.getOneStudent(studentId);
        if (student.getBooksAllocated() > 3) {
            throw new Exception("Books limit exceeded");
        }


        allocationRepository.allocateBook(bookId, studentId);
        studentService.increaseAvailable(studentId);
        bookService.reduceAvailable(bookId);
    }

    public void unallocateBook(String bookId, String studentId) {


        allocationRepository.unallocateBook(bookId, studentId);
        studentService.reduceAvailable(studentId);
        bookService.increaseAvailable(bookId);
    }

}
