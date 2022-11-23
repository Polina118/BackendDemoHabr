package com.backend.demoHabr.Posts;

import com.backend.demoHabr.Chapter.Chapter;
import com.backend.demoHabr.Chapter.ChapterRepository;
import com.backend.demoHabr.Subchapt.Subchapt;
import com.backend.demoHabr.Subchapt.SubchapterRepository;
import com.backend.demoHabr.Users.Users;
import com.backend.demoHabr.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping(path = "/api/posts")
@CrossOrigin()
public class PostsController {

    PostsRepository postsRepository;
    UsersRepository usersRepository;
    ChapterRepository chapterRepository;
    SubchapterRepository subchapterRepository;

    @Value("${upload-path}")
    private String uploadPath;

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

    @GetMapping("/{postId}")
    public ResponsePost getPostById(@PathVariable("postId") Integer postId){
        Posts posts = postsRepository.findById(postId).orElseThrow(()->
                new IllegalStateException("post not found"));
        String title = posts.getTitle();
        String data = "<div>" + posts.requestText() + "</div>";
        return new ResponsePost(title, data);
    }

    @PostMapping("/create")
    public String createPost(@RequestBody Posts post, @RequestParam MultipartFile[] files){
        postsRepository.save(post);

        String[] links = post.getList();

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];

            if (file.isEmpty() && file.getOriginalFilename().isEmpty())
                throw new IllegalStateException("file not found");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();

            String resultFileName = links[i]; //file.getOriginalFilename();

            try {
                file.transferTo(new File(uploadPath + "/" + resultFileName));
            } catch (Exception e) {
                throw new IllegalStateException("error");
            }
        }
        return "create";

        //return "<div>" + post.requestText() + "</div>";
    }

//    @PostMapping("/create/{chapterId}")
//    public Posts createPost(@RequestBody Posts posts, @PathVariable("chapterId") Integer chapterId){
//        Users users = usersRepository.findById(posts.getUser_id()).orElseThrow(() ->
//                new IllegalStateException((" --!incorrect user id!-- ")));
//        Subchapt subchapter = subchapterRepository.findById(chapterId).orElseThrow(()->
//                new IllegalStateException((" --!incorrect subchapter id!-- ")));
//        subchapter.addPost(posts);
//        postsRepository.save(posts);
//        return posts;
//    }

//    @PostMapping("/addFile/{postId}")
//    public String add(@RequestParam MultipartFile file, @PathVariable("postId") Integer postId){
//        Posts post = postsRepository.findById(postId).orElseThrow(()->
//                new IllegalStateException("post not found"));
//
//        if (file.isEmpty() && file.getOriginalFilename().isEmpty())
//            throw new IllegalStateException("file not found");
//        File uploadDir = new File(uploadPath);
//        if(!uploadDir.exists())
//            uploadDir.mkdir();
//
//        String resultFileName = file.getOriginalFilename();
//
//        try {
//            file.transferTo(new File(uploadPath +"/" + resultFileName));
//        }
//        catch (Exception e) {
//            throw new IllegalStateException("error");
//        }
//        //post.setFileName(resultFileName);
//        return resultFileName;
//    }

    @GetMapping(value = "/image/{filename}", produces = IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(uploadPath +"/"+ filename));
    }

//    @GetMapping(value = "/image/{filename}")
//    public String getImage(@PathVariable("filename") String filename) {
//        return "<img src=\"" + uploadPath +"/"+ filename + "\">";
//    }

//    @PostMapping(path = "/get{userId}")
//    public List<Posts> postsOfUser(@PathVariable("userId") Integer userId){
//        return postsRepository.findAllByUserId(userId);
//    }

//    @PostMapping(path = "/getGroup{subchapterId}")
//    public List<Posts> postsOfChapter(@PathVariable("subchapterId") Integer subchapterId){
//        return postsRepository.findAllByChapterId(subchapterId);
//    }
}
