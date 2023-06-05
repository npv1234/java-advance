package com.vti.service;

import java.util.List;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;
import com.vti.repository.IArticleRepository;

public class ArticleService implements IArticleService{
	private IArticleRepository articleRepository;
	
	public ArticleService() {
		articleRepository = new ArticleRepository();
	}
	
	public List<Article> getListArticles() {
		
		return articleRepository.getListArticles();
	}

	public void addNewArticle(Article art) {
		articleRepository.addNewArticle(art);
	}

	public void deleteArticle(Article art) {
		// TODO Auto-generated method stub
		
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void updateArticle(Article art) {
		articleRepository.updateArticle(art);
	}

	
}
