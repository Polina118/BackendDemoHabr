package com.backend.demoHabr.Comments;

import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Posts.PostsRepository;
import com.backend.demoHabr.Users.Users;
import com.backend.demoHabr.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/comment")
@CrossOrigin()
public class CommentsController {

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public CommentsController(CommentsRepository commentsRepository,
                              PostsRepository postsRepository,
                              UsersRepository usersRepository) {
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    @PostMapping(path = "/setcom")
    public Comments addComment(@RequestBody Comments comment){
        Posts post = postsRepository.findById(comment.postId).orElseThrow(() ->
                new IllegalStateException((" --!incorrect post id!-- ")));
        Users user = usersRepository.findById(comment.userId).orElseThrow(() ->
                new IllegalStateException((" --!incorrect user id!-- ")));

        commentsRepository.save(comment);
        post.addComment(comment);
        return comment;
    }
}
