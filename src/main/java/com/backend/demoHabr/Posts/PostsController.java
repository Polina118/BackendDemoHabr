package com.backend.demoHabr.Posts;

import com.backend.demoHabr.Chapter.ChapterRepository;
import com.backend.demoHabr.Users.Users;
import com.backend.demoHabr.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
@CrossOrigin()
public class PostsController {

    PostsRepository postsRepository;
    UsersRepository usersRepository;

    @Autowired
    public PostsController(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping(path = "/all")
    public List<Posts> getAllPosts(){
        return postsRepository.findAll();
    }

    @PostMapping("/create")
    public Posts createPost(@RequestBody Posts posts){
        Users users = usersRepository.findById(posts.getUser_id()).orElseThrow(() ->
                new IllegalStateException((" --!incorrect user id!-- ")));
        postsRepository.save(posts);
        users.addPost(posts);
        return new Posts(posts.getId(), posts.getTitle(), posts.getDescription());
    }

    @PostMapping(path = "/get{userId}")
    public List<Posts> postsOfUser(@PathVariable("userId") Long userId){
        return postsRepository.findAllByUserId(userId);
    }
}
