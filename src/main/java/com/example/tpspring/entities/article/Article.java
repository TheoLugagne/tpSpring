package com.example.tpspring.entities.article;

import jakarta.persistence.*;
import com.example.tpspring.entities.user.User;
import com.example.tpspring.entities.reaction.ArticleReaction;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "publication_date", nullable = false)
    @CreationTimestamp
    private Timestamp publicationDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArticleReaction> reactions;

    // Getters and Setters
}