package com.backend.demoHabr.Roles;

import com.backend.demoHabr.User_roles.User_roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Table
@Entity(name = "roles")
public class Roles {
    @Id
    @SequenceGenerator(
            name = "roles_sequence",
            sequenceName = "roles_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "roles_sequence"
    )
    @Column(nullable = false)
    int id;
    @Column(nullable = false)
    String value;
    @Column()
    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private User_roles user;

    public Roles(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
