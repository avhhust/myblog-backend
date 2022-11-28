package com.pawinc.myblog.service.impl;

import com.pawinc.myblog.model.PostCategory;
import com.pawinc.myblog.repository.PostCategoryRepository;
import com.pawinc.myblog.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;

    @Autowired
    public PostCategoryServiceImpl(PostCategoryRepository postCategoryRepository) {
        this.postCategoryRepository = postCategoryRepository;
    }

    @Override
    public PostCategory create(PostCategory postCategory) {
        Assert.notNull(postCategory, "Category cannot be null");
        return postCategoryRepository.save(postCategory);
    }

    @Override
    public PostCategory readById(long id) {
        return postCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id=" + id + " not found"));
    }

    @Override
    public PostCategory update(PostCategory postCategory) {
        Assert.notNull(postCategory, "Category cannot be null");
        postCategoryRepository.findById(postCategory.getId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return postCategoryRepository.save(postCategory);
    }

    @Override
    public void delete(long id) {
        postCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id=" + id + " not found"));
        postCategoryRepository.deleteById(id);
    }

    @Override
    public List<PostCategory> getAll() {
        List<PostCategory> categories = postCategoryRepository.findAll();
        return categories.isEmpty() ? new ArrayList<>() : categories;
    }
}
