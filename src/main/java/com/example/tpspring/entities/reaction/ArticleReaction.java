package com.example.tpspring.entities.reaction;

import com.example.tpspring.entities.article.Article;
import com.example.tpspring.entities.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "article_reaction")
public class ArticleReaction {
    @EmbeddedId
    private ArticleReactionId id;

    @ManyToOne
    @MapsId("article")
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "reaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;

    public enum ReactionType {
        LIKE,
        DISLIKE
    }

    // Getters and Setters
}