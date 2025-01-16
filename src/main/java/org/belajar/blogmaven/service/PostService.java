package org.belajar.blogmaven.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.belajar.blogmaven.entity.Post;
import org.belajar.blogmaven.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostsBySlug(String slug) {
        return postRepository.findFirstBySlug(slug).orElse(null);
    }

    public Post createPost(Post post) {
//        post.setId(null);
        post.setCreatedAt(Instant.now().getEpochSecond());
        return postRepository.save(post);
    }

    public Post updatePost(String slug, Post sentPostByUser) {
        Post savedPost = postRepository.findFirstBySlug(slug).orElse(null);
        if (savedPost == null) {
            return null;
        }
        sentPostByUser.setId(savedPost.getId());
        sentPostByUser.setCreatedAt(savedPost.getCreatedAt());
        sentPostByUser.setUpdatedAt(Instant.now().getEpochSecond());
        return postRepository.save(sentPostByUser);
    }

    public Boolean deletePost(Integer id) {
        Post savedPost = postRepository.findById(id).orElse(null);
        if (savedPost == null) {
            return false;
        }
        postRepository.deleteById(id);
        return true;
    }

    public Post publishPost(Integer id) {
        Post savedPost = postRepository.findById(id).orElse(null);
        if (savedPost == null) {
            return null;
        }
        savedPost.setPublished(true);
        savedPost.setPublishedAt(Instant.now().getEpochSecond());
        return  postRepository.save(savedPost);
    }
}
