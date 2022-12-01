package com.Librarymanagementapplication.Controllers;

import com.Librarymanagementapplication.Services.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocationController {


    @Autowired
    AllocationService allocationService;

    @RequestMapping(value="api/v1/AllocateBookToStudent", method = RequestMethod.PUT)
    public ResponseEntity<String> allocateBook(@RequestParam String studentId, @RequestParam String bookId) throws Exception {
        allocationService.allocateBook(bookId, studentId);
        return new ResponseEntity<>("the book is allocated successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="api/v1/UnAllocateBookToStudent", method = RequestMethod.PUT)
    public ResponseEntity<String> unallocateBook(@RequestParam String studentId, @RequestParam String bookId) throws Exception {
        allocationService.unallocateBook(bookId, studentId);
        return new ResponseEntity<>("the book is unallocated successfully", HttpStatus.CREATED);
    }
}
