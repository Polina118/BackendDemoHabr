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

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Configurations {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersrepository,
                                        PostsRepository postsRepository,
                                        ChapterRepository chapterRepository,
                                        SubchapterRepository subchapterRepository){
        return args -> {
            Posts post1 = new Posts( "title1", "lalalalal");
            Posts post2 = new Posts( "title2", "lalalalal");
            Posts post3 = new Posts( "title3", "lalalalal");
            postsRepository.saveAll(List.of(post1, post2, post3));
            List<Posts> postsList = List.of(post1, post2);

            Subchapt subchapt1 = new Subchapt("JavaFX", postsList);
            subchapterRepository.save(subchapt1);

            Chapter chapter1 = new Chapter( "Java", List.of(subchapt1));
            chapterRepository.save(chapter1);

            Users Maria = new Users("maria_email", "password", "Maria", "Smith", true, LocalDate.now(), postsList);
            Users Willy = new Users("willy_email", "password", "Willy", "tomm", true, LocalDate.now(), List.of(post3));

            usersrepository.saveAll(List.of(Maria, Willy));
        };
    }
}