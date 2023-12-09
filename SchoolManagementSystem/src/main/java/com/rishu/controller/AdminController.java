package com.rishu.controller;

import com.rishu.entities.Teacher;
import com.rishu.entities.User;
import com.rishu.service.AdminService;
import com.rishu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;

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


    //teacher operation
    //create
    @PostMapping("/postteacher")
    public Teacher addTeacher(@RequestBody Teacher teacher)
    {
        return this.teacherService.createTeacher(teacher);
    }

    //read

    @GetMapping("/getteacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable Integer teacherId)
    {
        return this.teacherService.getTeacherById(teacherId);
    }

    @GetMapping("/getallteacher")
    public List<Teacher> getAllTeacherlist()
    {
        return this.teacherService.getAllTeacherRecord();
    }

    //delete
    @DeleteMapping("/deleteteacher/{teacherId}")
    public String deleteTeacher(@PathVariable Integer teacherId)
    {
        return this.teacherService.deleteTeacher(teacherId);
    }

    //update
    @PutMapping("/updateteacher/{teacherId}")
    public Teacher updateTeacher(@PathVariable Integer teacherId,@RequestBody Teacher teacher)
    {
        return this.teacherService.updateTeacher(teacherId,teacher);
    }


}
