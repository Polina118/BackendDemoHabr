package com.backend.demoHabr.Subchapt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
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

    public Subchapt(String name, Integer chapterId) {
        this.name = name;
        this.chapterId = chapterId;
    }

}
