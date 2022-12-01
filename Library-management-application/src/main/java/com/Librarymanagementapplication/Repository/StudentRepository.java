package com.Librarymanagementapplication.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.Librarymanagementapplication.Model.Student;

import jakarta.annotation.Resource;

@Repository
public class StudentRepository  {
    final String hashReference= "Student";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    HashOperations<String, String, Student> hashOperations;

    public void saveStudent(Student emp) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, emp.getStudentId(), emp);
    }

    public void saveAllStudents(Map<String, Student> map) {
        hashOperations.putAll(hashReference, map);
    }

    public Student getOneStudent(String id) {
        return hashOperations.get(hashReference, id);
    }

    public void updateStudent(Student emp) {
        hashOperations.put(hashReference, emp.getStudentId(), emp);
    }

    public List<Student> getAllStudents() {
        Map<String, Student> temp =  hashOperations.entries(hashReference);
        List<Student> students = new ArrayList<Student>(temp.values());
        return students;

    }

    public void deleteStudent(String id) {
        hashOperations.delete(hashReference, id);
    }

}