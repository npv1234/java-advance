package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;

public class ArticleRepository implements IArticleRepository{
	private HibernateUtils hibernateUtils;
	
	public ArticleRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	//Thêm; sửa; xóa thì phải có transaction để commit sự thay đổi
	//Create
	public void createArticle(Article article) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			
			session.save(article);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//Delete
	public void deleteArticle(int id) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			//Thao tac db
			Article article = session.get(Article.class, id);
			session.delete(article);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//update
	public void updateArticle(int id, String title) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			//Thao tac db
			Article article = session.get(Article.class, id);
			article.setTitle(title);
			
			session.save(article);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//Read
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Article> getListArticles() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Article> query = session.createQuery("FROM Article");//HQL
			return query.list();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void addNewArticle(Article art) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			
			session.save(art);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateArticle(Article art) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			
			transaction = session.getTransaction();
			transaction.begin();
			//Thao tac db
			Article article = session.get(Article.class, art.getId());
			
			article.setTitle(art.getTitle());
			article.setStatus(art.getStatus());
			article.setType(art.getType());
			
			session.save(article);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	
}





















































