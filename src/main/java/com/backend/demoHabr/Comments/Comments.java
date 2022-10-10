package com.backend.demoHabr.Comments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "comments")
public class Comments {
    @Id
    @SequenceGenerator(
            name = "comments_sequence",
            sequenceName = "comments_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comments_sequence"
    )
    @Column(nullable = false)
    Integer id;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    Integer userId;
    @Column()
    Integer postId;

    public Comments(String description, Integer userId, Integer postId) {
        this.description = description;
        this.userId = userId;
        this.postId = postId;
    }
}
