package com.backend.demoHabr.User_roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    int id;

    int userId;
    int RoleId;
}
