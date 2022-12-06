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
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapterId")
    private List<Subchapt> subchaptList = new ArrayList<>();

    public Chapter(String name) {
        this.name = name;
    }

    public void addSubChapter(Subchapt subchapt){
        subchaptList.add(subchapt);
    }
}
