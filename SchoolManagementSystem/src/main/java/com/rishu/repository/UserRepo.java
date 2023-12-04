package com.rishu.repository;

import com.rishu.entities.User;
import com.rishu.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {


    User findByEmail(String email);
    User findByRole(UserRole userRole);

    List<User> findAllByRole(UserRole userRole);

    //User findById(int id,UserRole userrole);

}
