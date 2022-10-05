package com.backend.demoHabr.Chapter;

import com.backend.demoHabr.Subchapt.Subchapt;
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
    int id;
    String name;
//    LocalDate createdAt;
//    LocalDate updatedAt;

    @OneToMany
    @JoinColumn(name = "chapterId")
    List<Subchapt> subchapts;

    public Chapter(String name, List<Subchapt> subchapts) {
        this.name = name;
        this.subchapts = subchapts;
    }
}
