package top.dezckd.service;

import top.dezckd.entity.Article;

import java.util.List;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
public interface ArticleJAPService {
    void saveArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticleById(int id);
}
