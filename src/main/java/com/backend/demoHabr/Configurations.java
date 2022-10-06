package com.backend.demoHabr;

import com.backend.demoHabr.Chapter.Chapter;
import com.backend.demoHabr.Chapter.ChapterRepository;
import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Posts.PostsRepository;
import com.backend.demoHabr.Subchapt.Subchapt;
import com.backend.demoHabr.Subchapt.SubchapterRepository;
import com.backend.demoHabr.Users.Users;
import com.backend.demoHabr.Users.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Configurations {

    @Bean
    CommandLineRunner commandLineRunner(
            UsersRepository usersRepository
    ) {
        return args -> {
            Users polina = new Users("Polina", "Guk", "pg@inbox.ru", "12");
            Users user1 = new Users("user", "user", "@email", "pass");


            Posts post1 = new Posts("title1", "desc1", polina.getId());
            Posts post2 = new Posts("title2", "desc2", polina.getId());
            Posts post3 = new Posts("title3", "desc3", user1.getId());

            polina.setPosts(List.of(post1, post2));
            user1.setPosts(List.of(post3));

            usersRepository.saveAll(List.of(polina, user1));
        };
    }
}