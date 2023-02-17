package com.example.RecomSys.Controllers;

import com.example.RecomSys.Models.Movies;
import com.example.RecomSys.Models.User;
import com.example.RecomSys.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired(required = true)
    private UserRepository userRepo;

    //API EndPoint for getting list of users
    @GetMapping
    public ResponseEntity<List<User>> allUsers() {
        return new ResponseEntity<List<User>>(userRepo.findAll(), HttpStatus.OK);
    }

}
