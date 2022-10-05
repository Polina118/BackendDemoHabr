package com.backend.demoHabr.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
@CrossOrigin()
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping
    public List<Posts> getPosts() {
        return postsService.getAllPosts();
    }

    @GetMapping(path = "{subtitle}")
    public List<Posts> getPostByTitle(@PathVariable("subtitle") String subtitle){
        return postsService.getByTitle(subtitle);
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public String createNewPosts(@RequestBody Posts post) {
        postsService.createNewPost(post);
        return "Success";
    }

    @DeleteMapping(path = "/delete{id}")
    public String DeletePost(@PathVariable("id") int id) {
        postsService.deletePost(id);
        return "Deleted";
    }

    @PutMapping(path = "{postId}")
    public void UpdatePost(
            @PathVariable("postId") int postId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description){
        postsService.updatePost(postId, title, description);
    }
}
