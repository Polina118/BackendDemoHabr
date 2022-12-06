package com.backend.demoHabr.Posts;

import com.backend.demoHabr.Comments.Comments;
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
    @Column
    String chapter;
    @Column
    String subChapter;
    @Column
    private String links;
    @Column(nullable = false)
    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private List<Comments> comments = new ArrayList<>();

    @Column(nullable = false)
    private Integer userId;

    public Posts(){
    }

    public Posts(String title, String chapter, String subChapter, String links, String text, Integer userId) {
        this.title = title;
        this.chapter = chapter;
        this.subChapter = subChapter;
        this.links = links;
        this.text = text;
        this.userId = userId;
    }

    public void addComment(Comments comment){
        this.comments.add(comment);
    }

    public String[] getList(){
        return links.split(",");
    }

    public String requestText(){
        String result = text;
        String[] listLinks = getList();
        String path = "http://localhost:8080/api/posts/image/";
        for (String link : listLinks){
            result = result.replace(link, "</div> <img src = \"" + path + link
            + "\" ></div>");
        }
        return "<div>" + result + "</div>";
    }
}
