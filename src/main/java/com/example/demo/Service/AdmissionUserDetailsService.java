package com.example.demo.Service;

import com.example.demo.Repository.AdmissionUserRepository;
import com.example.demo.model.Admissionuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AdmissionUserDetailsService implements UserDetailsService {

    @Autowired
    private AdmissionUserRepository admissionUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admissionuser user = admissionUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList() // add roles here if needed
        );
    }
}

