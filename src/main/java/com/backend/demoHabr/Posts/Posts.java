package com.backend.demoHabr.Posts;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Table
@Entity(name = "posts")
public class Posts {

    @Id
    @SequenceGenerator(
            name = "posts_sequence",
            sequenceName = "posts_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "posts_sequence"
    )
    @Column(updatable = false)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    private Long user_id;


    public Posts(){}

    public Posts(String title, String description, Long user_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public Posts(Long id, String title, String description) {
        Id = id;
        this.title = title;
        this.description = description;
    }
}
