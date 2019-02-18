package com.techtalentsouth.BookStore.BookStoreController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookStoreController {
	
@Autowired 
private BookStoreRepository bookStoreRepository; //creates an instance

	
	@GetMapping("/")
	public String index() 
	{
		return	"BookStoreView/index.html";
		     
	}
	
	
	@GetMapping("/index")
	public ModelAndView index(BookStore bookStore) {
		System.out.println("happy3");
	ModelAndView mv = new ModelAndView("bookStore/index");
	System.out.println("happy4");
	mv.addObject("books", bookStoreRepository.findAll());
	//if(mv.isEmpty())
		//System.out.println("happy3");
	return mv;
	}

	
	@GetMapping("/about")
	public String bookStore() 
	{
			     return	"BookStoreView/about";
	}

	@GetMapping("/newBook")
	public ModelAndView newBook(BookStore bookStore) {
			ModelAndView mv = new ModelAndView("bookStoreView/newBook");		
			return	mv;
	}
	
	
	/*@GetMapping("allBooks")
	public ModelAndView allBooks(BookStore bookStore) {
	ModelAndView mv = new ModelAndView("bookStore/allBooks");
	mv.addObject("allBooks", bookStoreRepository.findAll());
	return mv;
	}*/

		
				
		@PostMapping(value="/")//post back to the form page
		public String addNewBookStore(BookStore storeN, Model model) {
			bookStoreRepository.save(storeN); 
					
			
			model.addAttribute("author", storeN.getAuthor());			
			model.addAttribute("title", storeN.getTitle());
			model.addAttribute("category", storeN.getCategory());		
			
			
			return "BookStoreView/results";
		}
		
		
		@PostMapping("bookStoreView/newBook")
		public ModelAndView createNewBook(BookStore bookStore) {
		ModelAndView mv = new ModelAndView("bookStore/results");
		BookStore newBook =bookStoreRepository.save(new BookStore(bookStore.getAuthor(), bookStore.getTitle(), bookStore.getCategory()));
		mv.addObject("newBook", newBook);
		return mv;
		}

		@PutMapping("bookStoreView/newBook")
		public ModelAndView updateNewBook(BookStore bookStore) {
			ModelAndView mv = new ModelAndView("redirect:/");
			bookStoreRepository.save(bookStore);
			return mv;

		}
		
		//returns all books in the database
		@GetMapping("/bookSearch")
		public ModelAndView allEmployees(BookStore bookStore) {
		ModelAndView mv = new ModelAndView("bookStoreView/bookSearch");
		mv.addObject("books", bookStoreRepository.findAll());		
		return mv;
		}


	}


