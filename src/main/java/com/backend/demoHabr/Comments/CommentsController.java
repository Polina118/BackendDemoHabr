package com.backend.demoHabr.Comments;

import com.backend.demoHabr.Posts.Posts;
import com.backend.demoHabr.Posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/comment")
@CrossOrigin()
public class CommentsController {

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    @Autowired
    public CommentsController(CommentsRepository commentsRepository,
                              PostsRepository postsRepository) {
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
    }

    @PostMapping(path = "/setcom")
    public Comments addComment(@RequestBody Comments comment){
        Posts post = postsRepository.findById(comment.postId).orElseThrow(() ->
                new IllegalStateException((" --!incorrect post id!-- ")));
//        Users user = usersRepository.findById(comment.userId).orElseThrow(() ->
//                new IllegalStateException((" --!incorrect user id!-- ")));

        commentsRepository.save(comment);
        post.addComment(comment);
        return comment;
    }
}
