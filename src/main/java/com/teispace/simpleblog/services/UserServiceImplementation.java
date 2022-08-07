package com.teispace.simpleblog.services;
import com.teispace.simpleblog.entities.User;
import com.teispace.simpleblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImplementation(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, int id) throws Exception {

          User searchUser = userRepo.findById(id).orElseThrow(()->new Exception("No dara FOUND"));

          searchUser.setName(user.getName());
          searchUser.setEmail(user.getEmail());
          searchUser.setAbout(user.getAbout());


          return userRepo.save(searchUser);

    }

    @Override
    public User getUserById(int id) throws Exception {
        return userRepo.findById(id).orElseThrow(()-> new Exception("NOT FOUND"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<User> getUserBetween(int fromId, int toId) {

        return userRepo.findByIdBetween(fromId,toId);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepo.findByNameStartingWith(name);
    }


    @Override
    public void deleteUser(int id) throws Exception {
        User user = getUserById(id);

        userRepo.deleteById(id);
    }





}
