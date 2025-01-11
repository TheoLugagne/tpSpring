package com.example.tpspringfinal.controllers;

import com.example.tpspringfinal.entities.ArticleReaction;
import com.example.tpspringfinal.repositories.ArticleReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactions")
public class ArticleReactionController {

        @Autowired
        private ArticleReactionRepository articleReactionRepository;

        @GetMapping
        public List<ArticleReaction> getAllReactions() {
            return articleReactionRepository.findAll();
        }
    
        @GetMapping("/{id}")
        public ArticleReaction getReactionById(@PathVariable Long id) {
            return articleReactionRepository.findById(id).orElse(null);
        }

        @DeleteMapping("/{id}")
        public void deleteReaction(@PathVariable Long id) {
            articleReactionRepository.deleteById(id);
        }
}
