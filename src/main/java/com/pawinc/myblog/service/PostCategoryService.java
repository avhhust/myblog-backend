package com.pawinc.myblog.service;

import com.pawinc.myblog.model.PostCategory;
import com.pawinc.myblog.repository.PostCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostCategoryService {
    PostCategory create(PostCategory postCategory);
    PostCategory readById(long id);
    PostCategory update(PostCategory postCategory);
    void delete(long id);

    List<PostCategory> getAll();
}
