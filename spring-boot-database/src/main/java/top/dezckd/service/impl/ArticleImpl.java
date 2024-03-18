package top.dezckd.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.dezckd.dao.ArticleJPADAO;
import top.dezckd.entity.Article;
import top.dezckd.service.ArticleJAPService;

import java.util.List;
import java.util.Optional;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@Service
public class ArticleImpl implements ArticleJAPService {
    @Resource
    ArticleJPADAO articleJPADAO;

    @Override
    public void saveArticle(Article article) {
        articleJPADAO.save(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleJPADAO.save(article);
    }

    @Override
    public Article getArticleById(int id) {
        Optional<Article> articleOptional = articleJPADAO.findById(id);
        // JDK8 lambda 判空
        return articleOptional.orElse(null);
    }

    @Override
    public List<Article> findAll() {
        return articleJPADAO.findAll();
    }

    @Override
    public void deleteArticleById(int id) {
        articleJPADAO.deleteById(id);
    }
}
