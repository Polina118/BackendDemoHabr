package com.backend.demoHabr.Chapter;
import com.backend.demoHabr.Subchapt.Subchapt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "chapter")
public class Chapter {
    //test
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapterId")
    private List<Subchapt> subchaptList;

    public Chapter(String name) { // name
        this.name = name;
        subchaptList = new ArrayList<>();
    }

    public void addSubChapter(Subchapt subchapt){
        subchaptList.add(subchapt);
    }
}
