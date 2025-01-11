package com.example.tpspringfinal.repositories;

import com.example.tpspringfinal.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}