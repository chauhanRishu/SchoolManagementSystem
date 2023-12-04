package com.rishu.service;


import com.rishu.entities.User;
import com.rishu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //read
    public User getStudentById(int studentId)
    {
        User studentData= this.userRepo.findById(studentId).get();
        return studentData;
    }

    //update
    public User updateStudent(int studentId,User updateData)
    {
        User data=this.userRepo.findById(studentId).get();
        User newData=new User();
        if(data.getName()!=null)
        {
            newData.setId(studentId);
            newData.setName(updateData.getName());
            newData.setMobileNumber(updateData.getMobileNumber());
            newData.setAddress(updateData.getAddress());
            newData.setEmail(updateData.getEmail());
            //newData.setClass(updateData.getClass());
            newData.setMobileNumber(updateData.getMobileNumber());
            newData.setAddress(updateData.getAddress());
            newData.setGender(updateData.getGender());
            newData.setPassword(this.passwordEncoder.encode(updateData.getPassword()));
            this.userRepo.save(newData);
        }
        else
        {
            System.out.println("Student not found with student Id : "+studentId);
        }
        return newData;
    }
}
