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
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column()
    private Integer chapterId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "subchapt_id")
//    private List<Posts> postsList;

    public Subchapt(String name, Integer chapterId) { //name, chapterId
        this.name = name;
        this.chapterId = chapterId;
//        this.postsList = new ArrayList<>();
    }

//    public void addPost(Posts post){
//        postsList.add(post);
//    }
}
