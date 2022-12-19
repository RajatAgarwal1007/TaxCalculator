package com.rajat_agarwal.Tax_Calculator.service.Impl;

import com.rajat_agarwal.Tax_Calculator.entities.Role;
import com.rajat_agarwal.Tax_Calculator.entities.User;
import com.rajat_agarwal.Tax_Calculator.exception.TaxNotFoundException;
import com.rajat_agarwal.Tax_Calculator.repo.RoleRepo;
import com.rajat_agarwal.Tax_Calculator.repo.UserRepo;
import com.rajat_agarwal.Tax_Calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(User user) {
        Role role = roleRepo.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String userName) {
        User user = userRepo.findById(userName).orElseThrow(() -> new TaxNotFoundException("User", "UserName", userName));
        this.userRepo.delete(user);
    }

    public User updateUser(User user, String userName) {
        User u = userRepo.findById(userName).orElseThrow(() -> new TaxNotFoundException("User", "UserName", userName));
        u.setUserFirstName(user.getUserFirstName());
        u.setUserLastName(user.getUserLastName());
        return userRepo.save(u);
    }

    public User changePassword(User user, String userName) {
        User u = userRepo.findById(userName).orElseThrow(() -> new TaxNotFoundException("User", "UserName", userName));
        u.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepo.save(u);
    }

    public User getUserById(String userName) {
        return userRepo.findById(userName).orElseThrow(() -> new TaxNotFoundException("User", "UserName", userName));
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }


    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }



}
