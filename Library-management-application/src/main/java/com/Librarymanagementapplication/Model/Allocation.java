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
       bookId= bookId;
       studentId = studentId;
   }

}
