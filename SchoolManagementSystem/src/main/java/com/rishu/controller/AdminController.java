package com.rishu.controller;

import com.rishu.entities.Fee;
import com.rishu.entities.Teacher;
import com.rishu.entities.User;
import com.rishu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //create
    @PostMapping("/poststudent")
    public User addStudent(@RequestBody User student)
    {
        return this.adminService.createStudent(student);
    }

    //read
    @GetMapping("/getstudent/{studentId}")
    public User getStudentById(@PathVariable Integer studentId)
    {
        return this.adminService.getStudentById(studentId);
    }

    @GetMapping("/getallstudent")
    public List<User> getAllStudentlist()
    {
        return this.adminService.getAllStudentRecord();
    }

    //update
    @PutMapping("/updatestudent/{studentId}")
    public User updateStudent(@PathVariable Integer studentId,@RequestBody User student)
    {
        return this.adminService.updateStudent(studentId,student);
    }

    //delete
    @DeleteMapping("/deletestudent/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId)
    {
        return this.adminService.deleteStudent(studentId);
    }

    //create or post
    @PostMapping("/payfee/{studentId}")
    public Fee payFee(@PathVariable Integer studentId,@RequestBody Fee fee)
    {
        return this.adminService.payFee(studentId,fee);
    }

    //teacher operation
    //create
    @PostMapping("/postteacher")
    public Teacher addTeacher(@RequestBody Teacher teacher)
    {
        return this.adminService.createTeacher(teacher);
    }

    //read

    @GetMapping("/getteacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable Integer teacherId)
    {
        return this.adminService.getTeacherById(teacherId);
    }

    @GetMapping("/getallteacher")
    public List<Teacher> getAllTeacherlist()
    {
        return this.adminService.getAllTeacherRecord();
    }

    //delete
    @DeleteMapping("/deleteteacher/{teacherId}")
    public String deleteTeacher(@PathVariable Integer teacherId)
    {
        return this.adminService.deleteTeacher(teacherId);
    }

    //update
    @PutMapping("/updateteacher/{teacherId}")
    public Teacher updateTeacher(@PathVariable Integer teacherId,@RequestBody Teacher teacher)
    {
        return this.updateTeacher(teacherId,teacher);
    }


}
