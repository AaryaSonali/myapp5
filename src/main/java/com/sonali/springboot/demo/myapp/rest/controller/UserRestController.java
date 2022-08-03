package com.sonali.springboot.demo.myapp.rest.controller;

import com.sonali.springboot.demo.myapp.rest.entity.User;
import com.sonali.springboot.demo.myapp.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService)
    {
        userService = theUserService;
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id){
          User theUser= userService.findById(id);
          if(theUser==null)
              throw new RuntimeException("There is no user with id " + id);
          return theUser;
    }

    @GetMapping ("/users")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User theUser)
    {
        theUser.setId(0);
        userService.save(theUser);
        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser)
    {
        if(userService.findById(theUser.getId())==null)
            throw new RuntimeException("No matching user is available in database");
        userService.save(theUser);
        return theUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id)
    {
        User user= userService.findById(id);
        if(user==null)
            throw new RuntimeException("There is no user with id " + id);
        userService.deleteById(id);
        return "Deleted user id: " + id;
    }

    @GetMapping("/hi")
    public String check()
    {
        return "Hi this is working!!!";
    }


}
