package com.teispace.simpleblog.repository;
import com.teispace.simpleblog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByIdBetween(int from,int to);
    List<User> findByNameStartingWith(String name);

}
