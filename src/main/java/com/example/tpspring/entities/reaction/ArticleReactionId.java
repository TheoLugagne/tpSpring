package com.example.tpspring.entities.reaction;

import com.example.tpspring.entities.article.Article;
import com.example.tpspring.entities.user.User;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArticleReactionId implements Serializable {
    private Long article;
    private Long user;

    // Default constructor
    public ArticleReactionId() {}

    // Parameterized constructor
    public ArticleReactionId(Long article, Long user) {
        this.article = article;
        this.user = user;
    }

    // Getters and Setters
    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleReactionId that = (ArticleReactionId) o;
        return Objects.equals(article, that.article) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, user);
    }
}