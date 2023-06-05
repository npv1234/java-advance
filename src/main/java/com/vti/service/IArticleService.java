package com.vti.service;

import java.util.List;

import com.vti.entity.Article;

public interface IArticleService {
	List<Article> getListArticles();
	//void updateArticle(int id, String title);

	void addNewArticle(Article art);

	void deleteArticle(int id);

	void updateArticle(Article art);

	
}
