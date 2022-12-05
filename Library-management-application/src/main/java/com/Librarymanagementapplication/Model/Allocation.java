package com.Librarymanagementapplication.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Allocation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String allocationId;// externalId

    private String bookId;

    private String studentId;


   public Allocation(String bookId, String studentId) {
       this.bookId= bookId;
       this.studentId = studentId;
   }


	public String getBookId() {
		return bookId;
	}
		
		
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
		
		
	public String getStudentId() {
		return studentId;
	}
		
		
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
		
}
