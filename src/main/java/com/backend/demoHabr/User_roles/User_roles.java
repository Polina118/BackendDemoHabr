package com.backend.demoHabr.User_roles;

import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Roles.Roles;
import com.backend.demoHabr.Users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "user_roles")
public class User_roles {
    @Id
    @SequenceGenerator(
            name = "user_roles_sequence",
            sequenceName = "user_roles_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_roles_sequence"
    )
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "UR_id")
    private List<Users> users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "UR_id")
    private List<Roles> roles;

    public User_roles(List<Users> users, List<Roles> roles) {
        this.users = users;
        this.roles = roles;
    }
}
