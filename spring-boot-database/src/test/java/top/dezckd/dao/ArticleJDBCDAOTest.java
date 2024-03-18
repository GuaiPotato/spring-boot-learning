package top.dezckd.dao;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.entity.Article;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@SpringBootTest
@Slf4j
class ArticleJDBCDAOTest {

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Test
    void save() {
        Article article = Article.builder()
                .author("dezckd")
                .title("Spring Boot1")
                .content("Spring Boot1")
                .build();
        int n = articleJDBCDAO.save(article);
        log.info(String.valueOf(n));
    }

    @Test
    void updateById() {
        Article article = Article.builder()
                .author("dezckd")
                .title("Spring Boot123")
                .content("Spring Boot123")
                .id(1)
                .build();
        int n = articleJDBCDAO.updateById(article);
        log.info(String.valueOf(n));
    }

    @Test
    void findById() {
        Article article = articleJDBCDAO.findById(1L);
        log.info(article.toString());
    }

    @Test
    void findAll() {
        log.info(articleJDBCDAO.findAll().toString());
    }

    @Test
    void deleteById(){
        int n = articleJDBCDAO.deleteById(2L);
        log.info(String.valueOf(n));
    }
}