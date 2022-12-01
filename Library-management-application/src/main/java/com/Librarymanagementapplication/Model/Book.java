package com.Librarymanagementapplication.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue
	private String bookId;
	private String BookName;
	private int TotalCopies;
	private int NoOfCopiesAvailable;
	
	@ElementCollection
	private List<Allocation> allocations;
	
	public Book() {
	}
	
	public Book(String bookId, String BookName, int TotalCopies, int NoOfCopiesAvailable) {
		super();
		this.bookId = bookId;
		this.BookName = BookName;
		this.TotalCopies = TotalCopies;
		this.NoOfCopiesAvailable = NoOfCopiesAvailable;
	}


	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public int getTotalCopies() {
		return TotalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		TotalCopies = totalCopies;
	}
	public int getNoOfCopiesAvailable() {
		return NoOfCopiesAvailable;
	}
	public void setNoOfCopiesAvailable(int noOfCopiesAvailable) {
		NoOfCopiesAvailable = noOfCopiesAvailable;
	}
	
}
