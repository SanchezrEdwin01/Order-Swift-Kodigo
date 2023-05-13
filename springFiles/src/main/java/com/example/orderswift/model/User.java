package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "User")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "user_email")
        }
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "user_email")
    private String userEmail;

    public User(int i, String john, String doe) {
    }

    public User(int i, String john) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}