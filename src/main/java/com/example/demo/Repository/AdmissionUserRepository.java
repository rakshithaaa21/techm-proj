package com.example.demo.Repository;

import com.example.demo.model.Admissionuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdmissionUserRepository extends JpaRepository<Admissionuser,Long> {
    Optional<Admissionuser> findByEmail(String email);

}
