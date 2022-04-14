package net.developia.boot_article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.developia.boot_article.dto.ArticleDTO;

@Mapper
public interface ArticleDAO {
	void insertArticle(ArticleDTO articleDTO) throws Exception;

	long getArticleCount() throws Exception;

	List<ArticleDTO> getArticleListPage(long startNum, long endNum) throws Exception;

	void updateReadcount(long bno) throws Exception;

	ArticleDTO getDetail(long bno) throws Exception;

	int updateArticle(ArticleDTO articleDTO) throws Exception;

	int deleteArticle(ArticleDTO articleDTO) throws Exception;
}
