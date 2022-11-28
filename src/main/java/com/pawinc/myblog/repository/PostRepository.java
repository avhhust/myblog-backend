package com.pawinc.myblog.repository;

import com.pawinc.myblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(
            value = "select id, title, preview_image, updated_at, author_id, content," +
                    "created_at, category_id, views_count, brief_title, likes_count from posts order by views_count limit 5",
            nativeQuery = true
    )
    List<Post> getTop5MostPopularPosts();
}
