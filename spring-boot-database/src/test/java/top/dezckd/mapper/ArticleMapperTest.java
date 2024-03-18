package top.dezckd.mapper;

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
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;


    @Test
    void insertArticle() {
        Article article = Article.builder()
                .author("tyler")
                .title("Spring Boot MyBatis")
                .content("Spring Boot MyBatis")
                .build();
        articleMapper.insertArticle(article);
    }
}