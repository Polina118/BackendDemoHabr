package com.backend.demoHabr.Users;

import com.backend.demoHabr.Posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "users")
public class Users {
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    //String secondname;
    private boolean isActivated;
    //String acticationLink;
    private LocalDate createdAt;
    //LocalDate updatedAt;

    @OneToMany
    @JoinColumn(name = "authorId")
    List<Posts> postsList;

    public Users(String email,
                 String password,
                 String name,
                 String surname,
                 boolean isActivated,
                 LocalDate createdAt,
                 List<Posts> postsList) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isActivated = isActivated;
        this.createdAt = createdAt;
        this.postsList = postsList;
    }
}
