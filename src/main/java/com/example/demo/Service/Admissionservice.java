package com.example.demo.Service;

import com.example.demo.Repository.AdmissionUserRepository;
import com.example.demo.model.Admissionuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Admissionservice {

    private final AdmissionUserRepository ar;

    @Autowired
    public Admissionservice(AdmissionUserRepository ar) {
        this.ar = ar;
    }

    public Admissionuser save(Admissionuser au){
        return ar.save(au);
    }

    public boolean validateLogin(String email, String password) {
        Optional<Admissionuser> user = ar.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
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

}



