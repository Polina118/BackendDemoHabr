package com.backend.demoHabr.Posts;

import com.backend.demoHabr.Chapter.Chapter;
import com.backend.demoHabr.Chapter.ChapterRepository;
import com.backend.demoHabr.Subchapt.Subchapt;
import com.backend.demoHabr.Subchapt.SubchapterRepository;
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
    ChapterRepository chapterRepository;

    SubchapterRepository subchapterRepository;

    @Autowired
    public PostsController(PostsRepository postsRepository,
                           UsersRepository usersRepository,
                           ChapterRepository chapterRepository,
                           SubchapterRepository subchapterRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
        this.chapterRepository = chapterRepository;
        this.subchapterRepository = subchapterRepository;
    }

    @GetMapping(path = "/all")
    public List<Posts> getAllPosts(){
        return postsRepository.findAll();
    }

    @PostMapping("/create")
    public Posts createPost(@RequestBody Posts posts){
        Users users = usersRepository.findById(posts.getUser_id()).orElseThrow(() ->
                new IllegalStateException((" --!incorrect user id!-- ")));
        Subchapt subchapter = subchapterRepository.findById(posts.getSubchapter_id()).orElseThrow(()->
                new IllegalStateException((" --!incorrect subchapter id!-- ")));
        postsRepository.save(posts);
        subchapter.addPost(posts);
        return posts;
    }

    @PostMapping(path = "/get{userId}")
    public List<Posts> postsOfUser(@PathVariable("userId") Integer userId){
        return postsRepository.findAllByUserId(userId);
    }

    @PostMapping(path = "/getGroup{subchapterId}")
    public List<Posts> postsOfChapter(@PathVariable("subchapterId") Integer subchapterId){
        return postsRepository.findAllByChapterId(subchapterId);
    }
}
