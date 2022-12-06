package com.backend.demoHabr;

import com.backend.demoHabr.Chapter.Chapter;
import com.backend.demoHabr.Chapter.ChapterRepository;
import com.backend.demoHabr.Comments.Comments;
import com.backend.demoHabr.Comments.CommentsRepository;
import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Posts.PostsRepository;
import com.backend.demoHabr.Subchapt.Subchapt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Configurations {
//Test push
    @Bean
    CommandLineRunner commandLineRunner(
            ChapterRepository chapterRepository,
            CommentsRepository commentsRepository,
            PostsRepository postsRepository
    ) {
        return args -> {
//            Users polina = new Users("Polina", "Guk", "pg@inbox.ru", "12");
//            Users user1 = new Users("user", "user", "@email", "pass");
//
//            Roles role = new Roles("admin", "desc");
//
//            polina.addRole(role);
//            usersRepository.saveAll(List.of(polina, user1));

            Chapter chapter = new Chapter("Java");

            Subchapt chapter1 = new Subchapt("JavaFX", 1);
            Subchapt chapter2 = new Subchapt("Spring", 1);

            Posts post1 = new Posts("title1","Java", "JavaFX",
                    "pic1,pic2",
                    "text1 pic1 hsufehvuhev pic2 fff", 1);
            Posts post2 = new Posts("title2","Java", "JavaFX",  "pic3", "text2", 1);
            Posts post3 = new Posts("title3","Java", "Spring",  "pic4, pic5", "text3", 2);

            Comments comment1 = new Comments("Wow1",1, post1.getId());
            post1.addComment(comment1);

            postsRepository.saveAll(List.of(post1, post2, post3));

            chapter.setSubchaptList(List.of(chapter1, chapter2));

            chapterRepository.save(chapter);

        };
    }
}