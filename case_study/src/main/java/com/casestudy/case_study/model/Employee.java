package com.casestudy.case_study.model;

import java.util.Date;

public class Employee {
    private Long id;
    private String name;
    private String gender;
    private String date_of_birth;
    private String id_card;
    private String phone_number;
    private String email;
    private String address;
    private double salary;
    private Long position_id;
    private Long department_id;
    private Long education_degree_id;
    private Long user_id;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Long getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(Long education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public Employee(Long id, String name, String gender, String date_of_birth, String id_card, String phone_number, String email, String address, double salary, Long position_id, Long department_id, Long education_degree_id, Long user_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.position_id = position_id;
        this.department_id = department_id;
        this.education_degree_id = education_degree_id;
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Employee(Long id, String name, String gender, String date_of_birth, String id_card, String phone_number, String email, String address, double salary, Long position_id, Long department_id, Long education_degree_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.position_id = position_id;
        this.department_id = department_id;
        this.education_degree_id = education_degree_id;
    }

    public Employee(String name, String gender, String date_of_birth, String id_card, String phone_number, String email, String address, double salary, Long position_id, Long department_id, Long education_degree_id, Long user_id) {
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.position_id = position_id;
        this.department_id = department_id;
        this.education_degree_id = education_degree_id;
        this.user_id = user_id;
    }
}
