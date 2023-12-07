package com.rishu.repository;

import com.rishu.entities.StudentLeave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentLeaveRepo extends JpaRepository<StudentLeave,Integer> {
}
