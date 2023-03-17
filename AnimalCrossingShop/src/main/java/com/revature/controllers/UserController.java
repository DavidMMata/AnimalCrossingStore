package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Customizer;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping(value="/users")
public class UserController {


    private UserService uService;

    public UserController(UserService uService){
        this.uService = uService;
    }


    //Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(uService.getAll());
    }


}
