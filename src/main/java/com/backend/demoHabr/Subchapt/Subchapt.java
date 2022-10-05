package com.backend.demoHabr.Subchapt;

import com.backend.demoHabr.Posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    int id;

    String name;
//    LocalDate createdAt;
//    LocalDate updatedAt;

    @OneToMany
    @JoinColumn(name = "subchapterId")
    List<Posts> postsList;

    public Subchapt(String name, List<Posts> postsList) {
        this.name = name;
        this.postsList = postsList;
    }
}
