package com.pawinc.myblog.service;

import com.pawinc.myblog.model.PostComment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostCommentService {
    PostComment create(PostComment postComment);
    PostComment readById(long id);
    PostComment update(PostComment postComment);
    void delete(long id);

    List<PostComment> getAll();
}
