package com.vti;

import java.util.List;

import com.vti.entity.Article;
import com.vti.entity.Article.Status;
import com.vti.repository.ArticleRepository;

public class Program {
	public static void main(String[] args) {
		System.out.println("Buoi3 Java Advance - Demo API");
		
//		Student st = new Student();
//		System.out.println("age: " + st.age);
		
		//System.out.println(Person.name) -> error;
//		Person person = new Person();
//		System.out.println(person.name);
//		
//		System.out.println("Country: " + Person.country);
		
//		DemoSingleton demoSingleton1 = new DemoSingleton();
//		
//		DemoSingleton demoSingleton2 = new DemoSingleton();
		
//		DemoSingleton demoSingleton3 = DemoSingleton.instance;
//		
//		DemoSingleton demoSingleton4 = DemoSingleton.instance;
		
		
		//DemoSingleton demoSingleton5 = DemoSingleton.getInstance();
		
//		DemoSingleton demoSingleton = DemoSingleton.getInstance();
//		demoSingleton.connectDb();
//		
//		DemoSingleton demoSingleton2 = DemoSingleton.getInstance();
		
//		DemoSingleton2 demoLazySingleton = DemoSingleton2.getInstance();
//		DemoSingleton2 demoLazySingleton2 = DemoSingleton2.getInstance();
		
		ArticleRepository articleRepository = new ArticleRepository();
		
//		Article article = new Article("Java Advance", "Backend", Status.APPROVED);
//		articleRepository.createArticle(article);
		
//		Article article2 = new Article("HTML && CSS", "Frontend", Status.REJECT);
//		articleRepository.createArticle(article2);
		
		List<Article> articles = articleRepository.getListArticles();
		
		for (Article  article : articles) {
			System.out.println(article);
		}
		
		//Delete
		articleRepository.deleteArticle(2);
		
		//Update
		articleRepository.updateArticle(1, "NodeJs");
		
	}
}




























