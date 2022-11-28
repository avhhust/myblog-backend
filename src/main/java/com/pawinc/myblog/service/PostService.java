package com.pawinc.myblog.service;

import com.pawinc.myblog.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    Post create(Post post);
    Post readById(long id);
    Post update(Post post);
    void delete(long id);

    List<Post> getAll();
    List<Post> getMostPopularPosts();
}
