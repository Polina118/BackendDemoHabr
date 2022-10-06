package com.backend.demoHabr.Subchapt;

import com.backend.demoHabr.Posts.Posts;
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
@Entity(name = "subchapt")
public class Subchapt {
    @Id
    @SequenceGenerator(
            name = "subchapt_sequence",
            sequenceName = "subchapt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subchapt_sequence"
    )
    private Integer id;

    private String name;
    private Integer chapterId;

    @OneToMany
    @JoinColumn(name = "subchapterId")
    List<Posts> postsList;

    public Subchapt(String name, Integer chapterId) { //name, chapterId
        this.name = name;
        this.chapterId = chapterId;
        this.postsList = new ArrayList<>();
    }

    public void addPost(Posts post){
        postsList.add(post);
    }
}
