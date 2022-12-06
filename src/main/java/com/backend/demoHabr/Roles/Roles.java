//package com.backend.demoHabr.Roles;
//
//import com.backend.demoHabr.Users.Users;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@NoArgsConstructor
//@Data
//@Table
//@Entity(name = "roles")
//public class Roles {
//    @Id
//    @SequenceGenerator(
//            name = "roles_sequence",
//            sequenceName = "roles_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "roles_sequence"
//    )
//    @Column(nullable = false)
//    private Integer id;
//    @Column(nullable = false)
//    private String value;
//    @Column()
//    private String description;
//
//    public Roles(String value, String description) {
//        this.value = value;
//        this.description = description;
//    }
//
//    @ManyToMany(mappedBy = "roles")
//    private Set<Users> users = new HashSet<>();
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
