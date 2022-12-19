package com.rajat_agarwal.Tax_Calculator.controllers;

import com.rajat_agarwal.Tax_Calculator.entities.User;
import com.rajat_agarwal.Tax_Calculator.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    Logger logger = LoggerFactory.getLogger(TaxController.class);

    // Register New User
    @PostMapping("/registerNerUser")
    public User registerNewUser(@RequestBody User user) {
        logger.info("registerNewUser method get started");
        return userServiceImpl.registerNewUser(user);
    }

    // Delete User
    @DeleteMapping("/deleteUser/{userName}")
    @PreAuthorize("hasRole('Admin')")
    public void deleteUser(@PathVariable String userName) {
        logger.info("deleteUser method get started");
        this.userServiceImpl.deleteUser(userName);
    }

    // Update User
    @PutMapping("/UpdateUser/{userName}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public User updateUser(@RequestBody User user,@PathVariable String userName) {
        logger.info("updateUser method get started");
        return userServiceImpl.updateUser(user, userName);
    }

    // Method to Change Password
    @PutMapping("/ChangePassword/{userName}")
    @PreAuthorize("hasRole('User')")
    public User changePassword(@RequestBody User user,@PathVariable String userName) {
        logger.info("changePassword method get started");
        return userServiceImpl.changePassword(user, userName);
    }

    // Get User by Id
    @GetMapping("/{userName}")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public User getUserById(@PathVariable String userName) {
        logger.info("getUserById method get started");
        return userServiceImpl.getUserById(userName);
    }

    // Get All User
    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('Admin')")
    public List<User> getAllUser() {
        logger.info("getALLUser method get started");
        return userServiceImpl.getAllUser();
    }

    // Sample Method for Admin
    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This URL is only accessible to admin";
    }

    // Sample Method for User
    @GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        return "This URL is only accessible to user";
    }
}
