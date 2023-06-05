package com.vti.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Article;
import com.vti.service.ArticleService;
import com.vti.service.IArticleService;

@RestController
@RequestMapping(value = "/api/v1/articles")
public class ArticleController {
	private IArticleService articleService;
	
	public ArticleController() {
		articleService = new ArticleService();
	}
	
	@GetMapping
	public List<Article> getListArticles() {
		return articleService.getListArticles();
	}
	
	@PostMapping
	public ResponseEntity<?> addNewArticle(@RequestBody Article art) {
		System.out.println(art);
		
		articleService.addNewArticle(art);
		
		return ResponseEntity.status(HttpStatus.OK).body("Add new article successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteArticle(@PathVariable(name = "id") int id) {
		System.out.println("id for deleting: " + id);
		
		articleService.deleteArticle(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Article deleted");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateArticle(@PathVariable(name = "id") int id, @RequestBody Article art) {
		System.out.println("id for updating: " + id);
		System.out.println(art);
		art.setId(id);
		articleService.updateArticle(art);
		return ResponseEntity.status(HttpStatus.OK).body("Article updated successfully!");
	}
}



















