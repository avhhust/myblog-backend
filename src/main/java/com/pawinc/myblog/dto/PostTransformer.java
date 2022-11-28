package com.pawinc.myblog.dto;

import com.pawinc.myblog.model.Post;
import com.pawinc.myblog.model.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PostTransformer {
    @NotNull
    public static PostDto convertToDto(Post post){
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getBriefTitle(),
                post.getPreviewImage(),
                post.getContent()
        );
    }

    @NotNull
    public static Post convertToEntity(PostDto postDto, User user){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setBriefTitle(postDto.getBriefTitle());
        post.setPreviewImage(postDto.getPreviewImage());
        post.setCreatedAt(LocalDateTime.now());
        post.setContent(postDto.getContent());
        post.setAuthor(user);
        return post;
    }
}
