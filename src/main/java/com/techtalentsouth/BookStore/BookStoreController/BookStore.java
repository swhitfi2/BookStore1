package com.techtalentsouth.BookStore.BookStoreController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BookStore {	
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String author;
		private String title;
		private String category;
		
		public BookStore() {
			
		}

		public BookStore(String author, String title, String category) {
			this.author = author;
			this.title = title;
			this.category = category;
		}

		
		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "BookStore [id=" + id + ", author=" + author + ", title=" + title + ", category=" + category + "]";
		}
		
		
		
		
		
		
	
	
	
}
