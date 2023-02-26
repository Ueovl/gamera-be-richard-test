package com.avengers.gamera.controller;

import com.avengers.gamera.constant.ArticleType;
import com.avengers.gamera.dto.article.ArticleGetDto;
import com.avengers.gamera.dto.article.ArticlePatchDto;
import com.avengers.gamera.dto.article.ArticlePostDto;
import com.avengers.gamera.dto.article.MiniArticleGetDto;
import com.avengers.gamera.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
@Validated
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    @Operation(summary = "Create new article")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleGetDto createArticle(@RequestBody ArticlePostDto articlePostDto) {
        return articleService.createArticle(articlePostDto);
    }

    @PatchMapping("/{articleId}")
    @Operation(summary = "Update article by article id")
    @ResponseStatus(HttpStatus.OK)
    public ArticleGetDto updateArticle(@RequestBody ArticlePatchDto articlePatchDto, @PathVariable Long articleId){
        return articleService.updateArticle(articleId,articlePatchDto);
    }
    @GetMapping("/pages")
    public List<MiniArticleGetDto> getMiniArticles(Integer pageNumber, Integer pageSize){
        return articleService.getMiniArticles(pageNumber,pageSize);
    }

    @GetMapping("/types/{articleType}")
    public List<MiniArticleGetDto> getMiniArticlesByType(@PathVariable ArticleType articleType, Integer pageNumber, Integer pageSize){
        return articleService.getMiniArticlesByType(articleType,pageNumber,pageSize);
    }

    @GetMapping("/{articleId}")
    public ArticleGetDto createArticle(@PathVariable Long articleId) {
        return articleService.getArticleById(articleId);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<String> deleteArticleById(@PathVariable Long articleId) {
        articleService.deleteArticleById(articleId);
        return ResponseEntity.ok("the article with ID("+ articleId +") has been deleted");
    }
}
