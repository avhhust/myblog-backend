package com.pawinc.myblog.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.pawinc.myblog.dto.PostDto;
import com.pawinc.myblog.dto.PostTransformer;
import com.pawinc.myblog.model.Post;
import com.pawinc.myblog.model.User;
import com.pawinc.myblog.service.PostService;
import com.pawinc.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private AmazonS3 amazonS3;

    @GetMapping("/posts")
    private List<Post> getAllPosts(){
        return postService.getAll();
    }

    @PostMapping("/posts")
    private Post createPost(@RequestBody PostDto postDto){
        Post newPost = PostTransformer.convertToEntity(postDto, getCurrentUser());
        return postService.create(newPost);
    }

    @GetMapping("/top-posts")
    private List<Post> getMostPopularPosts(){
        return postService.getMostPopularPosts();
    }


    @Autowired
    private UserService userService;
    private User getCurrentUser(){
//        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.readById(1);
    }
    
}
