package com.rishu.service;


import com.rishu.entities.Fee;
import com.rishu.entities.StudentLeave;
import com.rishu.entities.User;
import com.rishu.enums.UserRole;
import com.rishu.repository.FeeRepo;
import com.rishu.repository.StudentLeaveRepo;
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
    @Autowired
    private FeeRepo feeRepo;
    @Autowired
    private StudentLeaveRepo leaveRepo;

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
            newData.setEmail(updateData.getEmail());
            //newData.setClass(updateData.getClass());
            newData.setMobileNumber(updateData.getMobileNumber());
            newData.setAddress(updateData.getAddress());
            newData.setGender(updateData.getGender());
            newData.setRole(UserRole.STUDENT);
            newData.setPassword(this.passwordEncoder.encode(updateData.getPassword()));
            this.userRepo.save(newData);
        }
        else
        {
            System.out.println("Student not found with student Id : "+studentId);
        }
        return newData;
    }

    //payfee
    public Fee payFee(Fee feeData)
    {
        Fee fee=new Fee();
        fee.setMonth(feeData.getMonth());
        fee.setAmount(feeData.getAmount());
        fee.setGivenBy(feeData.getGivenBy());
        fee.setDescription(feeData.getDescription());
        return this.feeRepo.save(fee);
    }
    //apply leave or create
    public StudentLeave applyLeave(StudentLeave leaveData)
    {
        StudentLeave leave=new StudentLeave();
        leave.setSubject(leaveData.getSubject());
        leave.setBody(leaveData.getBody());
        return this.leaveRepo.save(leave);
    }

}
