package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Validation;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;

    @Size(min = 5, max = 45)
    private String lastName;
    @Size(min = 5, max = 45)
    private String firstName;
    @Size(min = 10, max = 11)
    private int phone;

    @Min(value = 18)
    private int age;

    @Email()
    private String email;

    public User() {
    }

    public User(String lastName, String firstName, int phone, int age, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
