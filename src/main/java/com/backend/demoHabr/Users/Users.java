//package com.backend.demoHabr.Users;
//
//import com.backend.demoHabr.Roles.Roles;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Table
//@Entity(name = "users")
//public class Users {
//    @Id
//    @SequenceGenerator(
//            name = "users_sequence",
//            sequenceName = "users_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "users_sequence"
//    )
//    @Column(updatable = false)
//    private Integer id;
//
//    @Column(nullable = false)
//    private String firstname;
//
//    @Column(nullable = false)
//    private String lastname;
//
//    @Column(nullable = false)
//    private String login;
//
//    @Column(nullable = false)
//    private Integer password;
//
//    public Users(){}
//    public Users(String email, String password, String name, String surname) {
//        this.firstname = name;
//        this.lastname = surname;
//        this.login = email;
//        this.password = password.hashCode();
//    }
//
//    public Users(Integer id, String firstname, String lastname) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    @Override
//    public String toString() {
//        return "User {" +
//                "id=" + id +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", login='" + login + "'}";
//    }
//
//    @ManyToMany (cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<Roles> roles=new ArrayList<>();
//
//    public void addRole(Roles role){
//        this.roles.add(role);
//        role.getUsers().add(this);
//    }
//
//    public void removeRole(Roles role){
//        this.roles.remove(role);
//        role.getUsers().remove(this);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//
//        if (!(o instanceof Users)) return false;
//
//        return id != null && id.equals(((Users) o).getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return 31;
//    }
//}
