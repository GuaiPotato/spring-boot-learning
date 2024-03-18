package top.dezckd.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.entity.Article;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@SpringBootTest
@Slf4j
class ArticleJAPServiceTest {
    @Resource
    private ArticleJAPService articleJAPService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .author("dezckd")
                .title("Spring Boot JPA")
                .content("Spring Boot JPA")
                .build();
        articleJAPService.saveArticle(article);
    }

    @Test
    void updateArticle() {
        Article article = Article.builder()
                .id(103)
                .author("dezckd")
                .title("Spring Boot JPA 1")
                .content("Spring Boot JPA 1")
                .build();
        articleJAPService.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleJAPService.getArticleById(103);
        log.info(article.toString());
    }

    @Test
    void findAll() {
        List<Article> list = articleJAPService.findAll();
        list.forEach(System.out::println);
    }

    @Test
    void deleteArticleById() {
        articleJAPService.deleteArticleById(13);
    }
}