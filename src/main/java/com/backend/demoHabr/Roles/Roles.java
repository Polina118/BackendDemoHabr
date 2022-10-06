package com.backend.demoHabr.Roles;

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
    int id;
    String value;
    String description;

    public Roles(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
