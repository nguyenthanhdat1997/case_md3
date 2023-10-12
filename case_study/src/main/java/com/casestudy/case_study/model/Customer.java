package com.casestudy.case_study.model;

import java.util.Date;

public class Customer {
    private Long id;
    private String name;
    private String gender;
    private String date_of_birth;
    private String id_card;
    private String phone_number;
    private String email;
    private String address;
    private Long customer_type_id;
    private Long user_id;
    public Customer() {
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

    public Long getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(Long customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Customer(Long id, String name, String gender, String date_of_birth, String id_card, String phone_number, String email, String address, Long customer_type_id, Long user_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.customer_type_id = customer_type_id;
        this.user_id = user_id;
    }

    public Customer(String name, String gender, String date_of_birth, String id_card, String phone_number, String email, String address, Long customer_type_id, Long user_id) {
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.customer_type_id = customer_type_id;
        this.user_id = user_id;
    }
}
