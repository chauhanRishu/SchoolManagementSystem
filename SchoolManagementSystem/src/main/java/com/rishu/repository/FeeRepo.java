package com.rishu.repository;

import com.rishu.entities.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepo extends JpaRepository<Fee,Integer> {
}
