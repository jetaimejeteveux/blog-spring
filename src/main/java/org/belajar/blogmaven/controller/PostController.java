package org.belajar.blogmaven.controller;

import org.belajar.blogmaven.entity.Post;
import org.belajar.blogmaven.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postsSvc;

    @GetMapping("/")
    public List<Post> getPosts() {
        return postsSvc.getPosts();
    }

    @GetMapping("/{slug}")
    public Post getPostBySlug(@PathVariable("slug") String slug) {
        return postsSvc.getPostsBySlug(slug);
    }

    @PostMapping("/")
    public Post createPost(@RequestBody Post post) {
        return postsSvc.createPost(post);
    }

    @PutMapping("/{slug}")
    public Post updatePost(@PathVariable("slug") String slug, @RequestBody Post sentPostByUser) {
        return postsSvc.updatePost(slug, sentPostByUser);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePost(@PathVariable("id") Integer id) {
        return postsSvc.deletePost(id);
    }

    @PutMapping("/{id}/publish")
    public Post publishPost(@PathVariable("id") Integer id) {
      return postsSvc.publishPost(id);
    }

}
