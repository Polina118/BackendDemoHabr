package com.backend.demoHabr.Chapter;

import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Subchapt.Subchapt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "chapter")
public class Chapter {
    @Id
    @SequenceGenerator(
            name = "chapter_sequence",
            sequenceName = "chapter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "chapter_sequence"
    )
    private Integer id;
    private String name;

    @OneToMany
    @JoinColumn(name = "chapterId")
    private List<Posts> postsList;

    public Chapter(String name) { // name
        this.name = name;
        postsList = new ArrayList<>();
    }

    public void addPost(Posts post){
        postsList.add(post);
    }
}
