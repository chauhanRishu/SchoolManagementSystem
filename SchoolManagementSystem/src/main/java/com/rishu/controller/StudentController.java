package com.rishu.controller;

import com.rishu.entities.Fee;
import com.rishu.entities.StudentLeave;
import com.rishu.entities.User;
import com.rishu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //get student
    @GetMapping("/{studentId}")
    public User getStudentById(@PathVariable Integer studentId)
    {
        return this.studentService.getStudentById(studentId);
    }

    //update student
    @PutMapping("/update/{studentId}")
    public User updateStudent(@PathVariable Integer studentId,@RequestBody User student)
    {
        return this.studentService.updateStudent(studentId,student);
    }
    //payfee or post
    @PostMapping("/payfee")
    public Fee payFee( @RequestBody Fee fee)
    {
        return this.studentService.payFee(fee);
    }

    //applyleave or create
    @PostMapping("/applyleave")
    public StudentLeave applyLeave( @RequestBody StudentLeave studentLeave)
    {
        return this.studentService.applyLeave(studentLeave);
    }




}
