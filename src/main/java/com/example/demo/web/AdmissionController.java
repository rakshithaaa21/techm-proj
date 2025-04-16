package com.example.demo.web;

import com.example.demo.Service.Admissionservice;
import com.example.demo.model.Admissionuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")  // Allow frontend to access backend
@RestController
@RequestMapping("/admission")
public class AdmissionController{

    private final Admissionservice admissionService;

    @Autowired
    public AdmissionController(Admissionservice admissionService) {
        this.admissionService = admissionService;
    }

    // Register user
    @PostMapping("/register")
    public Admissionuser register(@RequestBody Admissionuser user) {
        return admissionService.save(user);
    }

    // Login validation
    @PostMapping("/login")
    public String login(@RequestBody Admissionuser user) {
        return admissionService.validateLogin(user.getEmail(), user.getPassword()) ?
                "Login Successful" : "Invalid Credentials";
    }

    // Get user by email
    @GetMapping("/user/{email}")
    public Optional<Admissionuser> getUser(@PathVariable String email) {
        return admissionService.getuserByEmail(email);
    }

    // Get admission status
    @GetMapping("/status/{email}")
    public String getAdmissionStatus(@PathVariable String email) {
        return admissionService.getAdmissionStatus(email);
    }

    // Update admission status
    @PutMapping("/status")
    public String updateAdmissionStatus(@RequestParam String email, @RequestParam String status) {
        return admissionService.updateAdmissionStatus(email, status);
    }

    // Update fee amount
    @PutMapping("/fee")
    public String updateFeeAmount(@RequestParam String email, @RequestParam int amount) {
        return admissionService.updateFeeStatus(email, amount);
    }
}
