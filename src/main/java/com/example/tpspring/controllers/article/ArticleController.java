package com.example.tpspring.controllers.article;

import com.example.tpspring.entities.article.Article;
import com.example.tpspring.entities.reaction.ArticleReaction;
import com.example.tpspring.entities.reaction.ArticleReactionId;
import com.example.tpspring.entities.article.ArticleRepository;
import com.example.tpspring.entities.user.User;
import com.example.tpspring.entities.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article != null) {
            article.setContent(articleDetails.getContent());
            return articleRepository.save(article);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }

    @PostMapping("/{id}/like")
    public Article likeArticle(@PathVariable Long id, @RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Article article = articleRepository.findById(id).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (article != null && user != null) {
            ArticleReactionId reactionId = new ArticleReactionId(id, userId);
            ArticleReaction reaction = new ArticleReaction();
            reaction.setId(reactionId);
            reaction.setArticle(article);
            reaction.setUser(user);
            reaction.setReactionType(ArticleReaction.ReactionType.LIKE);
            article.getReactions().add(reaction);
            return articleRepository.save(article);
        }
        return null;
    }

    @PostMapping("/{id}/dislike")
    public Article dislikeArticle(@PathVariable Long id, @RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Article article = articleRepository.findById(id).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (article != null && user != null) {
            ArticleReactionId reactionId = new ArticleReactionId(id, userId);
            ArticleReaction reaction = new ArticleReaction();
            reaction.setId(reactionId);
            reaction.setArticle(article);
            reaction.setUser(user);
            reaction.setReactionType(ArticleReaction.ReactionType.DISLIKE);
            article.getReactions().add(reaction);
            return articleRepository.save(article);
        }
        return null;
    }
}