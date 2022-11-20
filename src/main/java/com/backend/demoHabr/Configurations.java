package com.backend.demoHabr;

import com.backend.demoHabr.Chapter.Chapter;
import com.backend.demoHabr.Chapter.ChapterRepository;
import com.backend.demoHabr.Comments.Comments;
import com.backend.demoHabr.Comments.CommentsRepository;
import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Posts.PostsRepository;
import com.backend.demoHabr.Roles.Roles;
import com.backend.demoHabr.Roles.RolesRepository;
import com.backend.demoHabr.Subchapt.Subchapt;
import com.backend.demoHabr.Users.Users;
import com.backend.demoHabr.Users.UsersRepository;
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
            UsersRepository usersRepository,
            CommentsRepository commentsRepository
    ) {
        return args -> {
            Users polina = new Users("Polina", "Guk", "pg@inbox.ru", "12");
            Users user1 = new Users("user", "user", "@email", "pass");

            Roles role = new Roles("admin", "desc");

            polina.addRole(role);
            usersRepository.saveAll(List.of(polina, user1));

            Chapter chapter = new Chapter("Java");

            Subchapt chapter1 = new Subchapt("JavaFX", 1);
            Subchapt chapter2 = new Subchapt("Spring", 1);

            Posts post1 = new Posts("title1", "desc1", polina.getId());
            Posts post2 = new Posts("title2", "desc2", polina.getId());
            Posts post3 = new Posts("title3", "desc3", user1.getId());

            Comments comment1 = new Comments("Wow1",polina.getId(), post1.getId());
            post1.addComment(comment1);

            chapter1.setPostsList(List.of(post1, post2));
            chapter2.setPostsList(List.of(post3));

            chapter.setSubchaptList(List.of(chapter1, chapter2));

            chapterRepository.save(chapter);

        };
    }
}