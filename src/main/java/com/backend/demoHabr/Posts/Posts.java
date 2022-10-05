package com.backend.demoHabr.Posts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
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
    int id;

    String title;
    String description;
//    int userId;
//    int subchaptId;
//    int chapterId;
    LocalDate createdAt;
    LocalDate updatedAt;

//    @ManyToOne
//    @JoinColumn(name = "author")
//    Users user_author;

    public Posts(String title, String description){
        this.title = title;
        this.description = description;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }
}
