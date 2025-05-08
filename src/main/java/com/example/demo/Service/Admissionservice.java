package com.example.demo.Service;

import com.example.demo.Repository.AdmissionUserRepository;
import com.example.demo.model.Admissionuser;
import org.apache.catalina.User;
import com.example.demo.dto.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Admissionservice {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AdmissionUserRepository ar;

    @Autowired
    public Admissionservice(AdmissionUserRepository ar) {
        this.ar = ar;
    }

    public Admissionuser save(Admissionuser au){
        if (!au.getPassword().startsWith("$2a$")) {
            au.setPassword(passwordEncoder.encode(au.getPassword()));
        }
        return ar.save(au);
    }


    public boolean validateLogin(String email, String password) {
        Optional<Admissionuser> user = ar.findByEmail(email);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }

    public Optional<Admissionuser> getuserByEmail(String email) {
        return ar.findByEmail(email);// retruns actual data
    }

    public String getAdmissionStatus(String email) {
        Optional<Admissionuser> user = ar.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getAdmissionStatus(); // Return actual status
        }
        return "Not Found";
    }

    public String updateAdmissionStatus(String email, String admissionStatus) {
        Optional<Admissionuser> user = ar.findByEmail(email);
        if (user.isPresent()) {
            Admissionuser au = user.get();
            au.setAdmissionStatus(admissionStatus);
            ar.save(au);
            return "Admission successfully updated";
        }
        return "user not found";
    }

    public String updateFeeStatus(String email, int amount) {
        Optional<Admissionuser> user = ar.findByEmail(email);
        if (user.isPresent()) {
            Admissionuser au = user.get();
            au.setFeeAmount(amount); // correctly store fee
            ar.save(au);
            return "Fee successfully updated";
        }
        return "user not found";
    }
    public List<Admissionuser> getAllUsers() {
        return ar.findAll();
    }

    public void saveUser(Admissionuser user) {
        String rawPassword = user.getPassword(); // This is abc123
        String encodedPassword = passwordEncoder.encode(rawPassword); // This becomes a hash
        user.setPassword(encodedPassword);
        ar.save(user);// Now save to DB
    }

    public String login(loginRequest loginRequest) {
        Admissionuser user = ar.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful!";
    }

}



