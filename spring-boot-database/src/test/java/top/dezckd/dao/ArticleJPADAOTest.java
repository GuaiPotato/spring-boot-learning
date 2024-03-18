package top.dezckd.dao;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@SpringBootTest
@Slf4j
class ArticleJPADAOTest {

    @Resource
    private ArticleJPADAO articleJPADAO;

    @Test
    void findArticleByAuthor() {
        log.info(String.valueOf(articleJPADAO.findArticleByAuthor("dezckd")));
    }

    @Test
    void findArticleByAuthorContaining() {
        log.info(String.valueOf(articleJPADAO.findArticleByAuthorContaining("dez")));
    }
}