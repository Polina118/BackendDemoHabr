package com.backend.demoHabr.Users;

import com.backend.demoHabr.Posts.Posts;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Column(updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Posts> posts;

    public Users(){}

    public Users(String firstname, String lastname, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public Users(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

//    public List<Posts> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Posts> posts) {
//        this.posts = posts;
//    }
//
//    public void addPost(Posts posts){
//        this.posts.add(posts);
//    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + "'}";
    }
}
