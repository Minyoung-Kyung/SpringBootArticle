package net.developia.boot_article.service;

import java.util.List;

import net.developia.boot_article.dto.ArticleDTO;

public interface ArticleService {
	void insertArticle(ArticleDTO articleDTO) throws Exception;

	long getArticleCount() throws Exception;

	List<ArticleDTO> getArticleListPage(long pg) throws Exception;

	ArticleDTO getDetail(long bno) throws Exception;

	void updateArticle(ArticleDTO articleDTO) throws Exception;

	void deleteArticle(ArticleDTO articleDTO) throws Exception;
}
