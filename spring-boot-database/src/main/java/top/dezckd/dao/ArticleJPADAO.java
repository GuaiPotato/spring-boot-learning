package top.dezckd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dezckd.entity.Article;

import java.util.List;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
public interface ArticleJPADAO extends JpaRepository<Article,Integer> {
    Article findArticleByAuthor(String author);

    List<Article> findArticleByAuthorContaining(String keywords);
}
