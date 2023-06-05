package com.vti.repository;

import java.util.List;

import com.vti.entity.Article;

public interface IArticleRepository {
	List<Article> getListArticles();

	void addNewArticle(Article art);

	void deleteArticle(int id);

	void updateArticle(Article art);

	
}
