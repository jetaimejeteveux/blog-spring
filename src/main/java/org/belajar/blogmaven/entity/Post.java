package org.belajar.blogmaven.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;

    @Column(unique = true)
    private String slug;
    private boolean isPublished;
    private boolean isDeleted;
    private long createdAt;
    private long updatedAt;
    private long publishedAt;

}
