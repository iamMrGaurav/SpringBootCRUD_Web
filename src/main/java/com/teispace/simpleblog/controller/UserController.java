package com.teispace.simpleblog.controller;

import com.teispace.simpleblog.entities.User;
import com.teispace.simpleblog.exceptions.ResourceNotFoundException;
import com.teispace.simpleblog.services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImplementation userService;

    @Autowired
    public UserController(UserServiceImplementation userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable String id ) throws Exception {
        return new ResponseEntity<>(userService.updateUser(user,Integer.parseInt(id)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) throws Exception {
        userService.deleteUser(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) throws ResourceNotFoundException,Exception {
        int uId;
        try{
            uId = Integer.parseInt(id);
        }catch (NumberFormatException e){
            throw new ResourceNotFoundException("User","Id",id);
        }catch (Exception ex){
            throw new Exception("Something Went Wrong");
        }
        return  new ResponseEntity<>(userService.getUserById(uId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllUsers(){
        return  new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{fromId}/{toId}")
    public ResponseEntity<Object> getUserById(@PathVariable String fromId,@PathVariable String toId){
        return  new ResponseEntity<>(userService.getUserBetween(Integer.parseInt(fromId),Integer.parseInt(toId)),HttpStatus.OK);
    }


}
