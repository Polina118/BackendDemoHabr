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
    private Integer Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    private Integer user_id;
    private Integer subchapter_id;

    public Posts(){}

    public Posts(String title, String description, Integer user_id, Integer subchapter_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.subchapter_id = subchapter_id;
    }
}
