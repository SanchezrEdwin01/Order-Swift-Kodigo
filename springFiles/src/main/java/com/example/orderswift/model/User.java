package com.example.orderswift.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity(name = "User")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "user_email")
        }
)
@Data @NoArgsConstructor
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    @NotBlank(message = "User name must not be null or blank")
    private String userName;

    @Column(name = "first_name")
    @NotBlank(message = "First name must not be null or blank")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name must not be null or blank")
    private String lastName;

    @Column(name = "user_password")
    @NotBlank(message = "Password must not be null or blank")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String userPassword;

    @Column(name = "phone_num")
    @NotBlank(message = "Phone number must not be null or blank")
    private String phoneNum;

    @Column(name = "user_email")
    @NotBlank(message = "Email must not be null or blank")
    @Email(message = "Email format is incorrect")
    private String userEmail;

    @OneToMany(mappedBy = "user")
    private List<TransactionUser> transactionUsers;

    public User( String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int i, String john) {
    }

    public User(int i, String text, String text1, String text2, String text3, String text4, String text5) {
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