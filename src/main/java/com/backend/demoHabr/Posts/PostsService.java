package com.backend.demoHabr.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostsService {

    PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }

    public void createNewPost(Posts post) {
        Optional<Posts> postOptional = postsRepository.findByTitle(post.getTitle());
        if (postOptional.isPresent())
            throw new IllegalStateException("title is taken");
        postsRepository.save(post);
    }

    public List<Posts> getByTitle(String subtitle) {
        return postsRepository.findByTitleContaining(subtitle);
    }

    public void deletePost(int id) {
        if (!postsRepository.existsById(id))
            throw new IllegalStateException("post with id " + id + " does not exists");
        postsRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(int postId, String title, String description) {
        Posts post = postsRepository.findById(postId).
                orElseThrow(()-> new IllegalStateException(("post with id "+  postId + "does not exists")));
        if (title != null && title.length() >0 && !Objects.equals(post.getTitle(), title))
            post.setTitle(title);

        if (description != null && description.length()>0 && !Objects.equals(post.getDescription(), description)){
            Optional<Posts> optionalPost = postsRepository.findByDescription(description);
            if (optionalPost.isPresent())
                throw new IllegalStateException("description is taken");
            post.setDescription(description);

            post.setUpdatedAt(LocalDate.now());
        }
    }
}