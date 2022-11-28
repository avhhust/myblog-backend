package com.pawinc.myblog.dto;

import com.pawinc.myblog.model.PostCategory;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Pojo class that represent simplified Post entity without business logic and only with suitable columns
public class PostDto {

    //Don't use id because Spring will automatically set it while creating Post entity
    private long id;

    @NotBlank(message = "The title is mandatory")
    private String title;

    @NotBlank(message = "the brief title is mandatory")
    private String briefTitle;

    @NotNull
    @URL
    private String previewImage;

    @NotBlank
    private String content;

    public PostDto(long id, String title, String briefTitle, String previewImage, String content) {
        this.id = id;
        this.title = title;
        this.briefTitle = briefTitle;
        this.previewImage = previewImage;
        this.content = content;
    }

    public PostDto(String title, String briefTitle, String previewImage, String content) {
        this.title = title;
        this.briefTitle = briefTitle;
        this.previewImage = previewImage;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefTitle() {
        return briefTitle;
    }

    public void setBriefTitle(String briefTitle) {
        this.briefTitle = briefTitle;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
