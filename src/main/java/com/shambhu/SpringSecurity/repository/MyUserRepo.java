package com.shambhu.SpringSecurity.repository;

import com.shambhu.SpringSecurity.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<Users,Integer> {
}
