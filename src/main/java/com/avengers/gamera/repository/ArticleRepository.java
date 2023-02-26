package com.avengers.gamera.repository;

import com.avengers.gamera.constant.ArticleType;
import com.avengers.gamera.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticleByIsDeletedFalse(Pageable pageable);

    List<Article> findArticlesByTypeAndIsDeletedFalse(ArticleType articleType, Pageable pageable);
}
