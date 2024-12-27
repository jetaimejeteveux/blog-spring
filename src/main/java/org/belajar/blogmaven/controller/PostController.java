package org.belajar.blogmaven.controller;

import org.belajar.blogmaven.entity.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PostController {

    Post post1 = new Post(1, "title", "slug1");
    Post post2 = new Post(2, "title", "slug2");
    List<Post> posts = List.of(post1, post2);
    @GetMapping("/")
    public List<Post> getPosts() {
        return posts;
    }

    @GetMapping("/{slug}")
    public Post getPostBySlug(@PathVariable("slug") String slug) {
        return posts.stream().filter(post -> post.getSlug().equals(slug)).findFirst().orElse(null);
    }
}
