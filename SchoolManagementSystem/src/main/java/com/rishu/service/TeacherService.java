package com.rishu.service;

import com.rishu.entities.Teacher;
import com.rishu.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;


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
        this.teacherRepo.deleteById(teacherId);
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
