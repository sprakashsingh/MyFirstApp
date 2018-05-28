package com.Satya.FirstApp.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

// @Entity annotation : used to mark the class as a persistent Java class.

// @Table annotation is used to provide the details of the table that this entity will be mapped to.

// @JsonIgnoreProperties annotation is a Jackson annotation.
// Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON.
// This annotation is used because we don’t want the clients of the rest api to supply the createdAt and updatedAt values.

@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class User {
    // @Id annotation is used to define the primary key.
    // @GeneratedValue annotation is used to define the primary key generation strategy.
    // In the below case, we have declared the primary key to be an Auto Increment field.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank annotation is used to validate that the annotated field is not null or empty.
    @NotBlank
    private String fname;

    @NotBlank
    private String lname;

    @NotBlank
    private String email;

    @NotNull
    private Long phone;

    // @Column annotation is used to define the properties of the column that will be mapped to the annotated field.
    // You can define several properties like name, length, nullable, updateable etc.

    // @Temporal annotation is used with java.util.Date and java.util.Calendar classes.
    // It converts the date and time values from Java Object to compatible database type and vice versa.

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(Long phoneNumber) {
        this.phone = phoneNumber;
    }

    public long getPhone() {
        return phone;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
