package com.Librarymanagementapplication.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue
    private String studentId;
    private String studentName;
    private int booksAllocated;

    public Student(String studentId, String studentName, int booksAllocated) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.booksAllocated = booksAllocated;
    }

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getBooksAllocated() {
        return booksAllocated;
    }
    public void setBooksAllocated(int booksAllocated) {
        this.booksAllocated = booksAllocated;
    }

}

