package com.hyun.jdbc.Article;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * articleDao를 사용해서 글 목록, 조회, 추가, 수정, 삭제를 한다.
 * 
 * @author Jacob
 */
@Service
public class ArticleService {

	ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * 글 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * 글 조회
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * 글 등록
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("윤지오 “대검 진상조사단, 과거 부실수사 미안하다 해");
		article.setContent(
				"배우 고 장자연씨 성접대 강요 사건에 대해 증언하고 있는 동료 배우 윤지오씨가 최근 대검찰청 검찰 과거사 진상조사단의 조사 과정에서 ‘과거에 수사를 제대로 하지 않아 미안하다’는 사과를 받았다고 말했다.");
		article.setUserId("95");
		article.setName("강현우");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했우습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}

	/**
	 * 글 수정
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}

	/**
	 * 글 삭제
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}