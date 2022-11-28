package com.pawinc.myblog.service.impl;

import com.pawinc.myblog.model.PostComment;
import com.pawinc.myblog.repository.PostCommentRepository;
import com.pawinc.myblog.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {

    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public PostComment create(PostComment postComment) {
        Assert.notNull(postComment, "Comment cannot be empty");
        return postCommentRepository.save(postComment);
    }

    @Override
    public PostComment readById(long id) {
        return postCommentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment with id=" + id + " not found"));
    }

    @Override
    public PostComment update(PostComment postComment) {
        Assert.notNull(postComment, "Comment cannot be empty");
        postCommentRepository.findById(postComment.getId())
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
        return postCommentRepository.save(postComment);
    }

    @Override
    public void delete(long id) {
        postCommentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment with id=" + id + " not found"));
        postCommentRepository.deleteById(id);
    }

    @Override
    public List<PostComment> getAll() {
        List<PostComment> comments = postCommentRepository.findAll();
        return comments.isEmpty() ? new ArrayList<>() : comments;
    }
}
