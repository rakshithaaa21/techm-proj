package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="admissionuser")
public class Admissionuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String number;// used string bcuz, some num starts from zero, which int removes
    private String state;
    private String city;
    private int year;
    private String course;
    private int feeAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String admissionStatus;


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admissionuser() {
    }

    public String getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(String admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    public Admissionuser(Long id, String name, String email, String password, String number, String state, String city, int year, String course, String admissionStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.state = state;
        this.city = city;
        this.year = year;
        this.course = course;
        this.admissionStatus = admissionStatus;
    }

    public Admissionuser(String name, String email, String password, String number, String state, String city, int year, String course, String admissionStatus) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.state = state;
        this.city = city;
        this.year = year;
        this.course = course;
        this.admissionStatus = admissionStatus;
    }

    @Override
    public String toString() {
        return "Admissionuser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", year=" + year +
                ", course='" + course + '\'' +
                ", admissionStatus='" + admissionStatus + '\'' +
                '}';
    }

    public int getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(int feeAmount) {
        this.feeAmount = feeAmount;
    }
}
