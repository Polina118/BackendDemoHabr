package com.backend.demoHabr.Posts;

import com.backend.demoHabr.Comments.Comments;
import com.backend.demoHabr.Subchapt.Subchapt;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column()
    private Integer user_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private List<Comments> comments;

    public Posts(){}

    public Posts(String title, String description, Integer user_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comments comment){
        this.comments.add(comment);
    }
}
