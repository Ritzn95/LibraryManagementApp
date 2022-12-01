package com.Librarymanagementapplication.Repository;

import com.Librarymanagementapplication.Model.Allocation;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
public class AllocationRepository {

    final String hashReference= "Allocation";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    HashOperations<String, String, Allocation> hashOperations;


    public void allocateBook(String bookId, String studentId) {
        hashOperations.putIfAbsent(hashReference,bookId + studentId, new Allocation(bookId, studentId));
    }

    public void unallocateBook(String bookId, String studentId) {
        hashOperations.delete(bookId + studentId, hashReference);
    }

}
