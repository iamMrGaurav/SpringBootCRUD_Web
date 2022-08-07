package com.teispace.simpleblog.services;

import com.teispace.simpleblog.entities.User;


import java.util.List;
import java.util.Optional;


public interface UserService {

    User createUser(User user);
    User updateUser(User user,int id) throws Exception;

    User getUserById(int id) throws Exception;

    List<User> getAllUsers();
    List<User> getUserBetween(int fromId,int toId);

    List<User> findUserByName(String name);

    void deleteUser(int id) throws Exception;





}
