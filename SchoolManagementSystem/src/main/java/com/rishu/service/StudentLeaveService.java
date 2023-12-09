package com.rishu.service;

import com.rishu.entities.StudentLeave;
import com.rishu.entities.User;
import com.rishu.repository.StudentLeaveRepo;
import com.rishu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLeaveService {
    @Autowired
    private StudentLeaveRepo studentLeaveRepo;
    @Autowired
    private UserRepo userRepo;

    //apply leave or create
    public StudentLeave applyLeave(StudentLeave leaveData)
    {
        StudentLeave leave=new StudentLeave();
        leave.setSubject(leaveData.getSubject());
        leave.setBody(leaveData.getBody());
        leave.setDate(leaveData.getDate());
        User u=this.userRepo.findById(leaveData.getUser().getId()).get();
        leave.setUser(u);
        return this.studentLeaveRepo.save(leave);
    }

}
