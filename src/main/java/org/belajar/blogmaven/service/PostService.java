package org.belajar.blogmaven.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.belajar.blogmaven.entity.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {

    Post post1 = new Post(1, "title", "slug1");
    Post post2 = new Post(2, "title", "slug2");
    List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));

    public List<Post> getPosts() {
        return posts;
    }

    public Post getPostsBySlug(String slug) {
        return posts.stream().filter(post -> post.getSlug().equals(slug)).findFirst().orElse(null);
    }

    public Post createPost(Post post) {
        posts.add(post);
        return post;
    }

    public Post updatePost(String slug, Post sentPostByUser) {
        Post savedPost = posts.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
        if (savedPost == null) {
            return null;
        }
        savedPost.setSlug(sentPostByUser.getSlug());
        savedPost.setTitle(sentPostByUser.getTitle());
        return savedPost;
    }

    public Boolean deletePost(Integer id) {
        Post savedPost = posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
        if (savedPost == null) {
            return false;
        }
        posts.remove(savedPost);
        return true;
    }

    public Post publishPost(Integer id) {
        Post savedPost = posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
        if (savedPost == null) {
            return null;
        }
        savedPost.setPublished(true);
        return savedPost;
    }
}
