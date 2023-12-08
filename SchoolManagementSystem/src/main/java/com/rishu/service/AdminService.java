package com.rishu.service;


import com.rishu.entities.Teacher;
import com.rishu.entities.User;
import com.rishu.enums.UserRole;
import com.rishu.repository.UserRepo;
import com.rishu.repository.TeacherRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TeacherRepo teacherRepo;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount=userRepo.findByRole(UserRole.ADMIN);
        if(adminAccount==null)
        {
            User admin=new User();
            admin.setId(1);
            admin.setName("rishu");
            admin.setEmail("rishu@gmail.com");
            admin.setPassword(this.passwordEncoder.encode("rishu"));
            //admin.setClass("null");
            admin.setRole(UserRole.ADMIN);
            this.userRepo.save(admin);
        }

    }
    //create
    public User createStudent(User saveData)
    {
        User studenData=new User();
        studenData.setName(saveData.getName());
        studenData.setMobileNumber(saveData.getMobileNumber());
        studenData.setAddress(saveData.getAddress());
        studenData.setEmail(saveData.getEmail());
        studenData.setPassword(this.passwordEncoder.encode(saveData.getPassword()));
        studenData.setStudentclass(saveData.getStudentclass());
        studenData.setMobileNumber(saveData.getMobileNumber());
        studenData.setAddress(saveData.getAddress());
        studenData.setGender(saveData.getGender());
        studenData.setRole(UserRole.STUDENT);
        return this.userRepo.save(studenData);

    }

    //read

    public User getStudentById(int studentId)
    {
        User studentData= this.userRepo.findById(studentId).get();
        return studentData;
    }

    public List<User> getAllStudentRecord()
    {
        List<User> allStudentlist=this.userRepo.findAllByRole(UserRole.STUDENT);
        return allStudentlist;
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
            newData.setAddress(updateData.getAddress());
            newData.setEmail(updateData.getEmail());
            newData.setStudentclass(updateData.getStudentclass());
            newData.setMobileNumber(updateData.getMobileNumber());
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

    //delete
    public String deleteStudent(int studentId)
    {
        this.userRepo.deleteById(studentId);
        return "student delete with Id : "+studentId+" successfully!!";
    }



    //teacher operation
    //create
    public Teacher createTeacher(Teacher saveData)
    {
        Teacher teacherData=new Teacher();
        teacherData.setName(saveData.getName());
        teacherData.setGender(saveData.getGender());
        teacherData.setDepartment(saveData.getDepartment());
        teacherData.setQualification(saveData.getQualification());
        teacherData.setAddress(saveData.getAddress());
        return this.teacherRepo.save(teacherData);

    }

    //read

    public Teacher getTeacherById(int teacherId)
    {
        Teacher teacherData= this.teacherRepo.findById(teacherId).get();
        return teacherData;
    }
    public List<Teacher> getAllTeacherRecord()
    {
        List<Teacher> allTeacherlist=this.teacherRepo.findAll();
        return allTeacherlist;
    }

    //delete
    public String deleteTeacher(int teacherId)
    {
        this.userRepo.deleteById(teacherId);
        return "Teacher delete with Id : "+teacherId+" successfully!!";
    }

    //update

    public Teacher updateTeacher(int teacherId,Teacher updateData)
    {
        Teacher data=this.teacherRepo.findById(teacherId).get();
        Teacher newData=new Teacher();
        if(data.getName()!=null)
        {
            newData.setId(teacherId);
            newData.setName(updateData.getName());
            newData.setGender(updateData.getGender());
            newData.setDepartment(updateData.getDepartment());
            newData.setQualification(updateData.getQualification());
            newData.setAddress(updateData.getAddress());
            this.teacherRepo.save(newData);
        }
        else
        {
            System.out.println("Teacher not found with teacher Id : "+teacherId);
        }
        return newData;
    }



}
