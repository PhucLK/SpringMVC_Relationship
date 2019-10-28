package com.spring.JV32_Relationship.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.JV32_Relationship.entities.Book;
import com.spring.JV32_Relationship.service.BookDetailService;
import com.spring.JV32_Relationship.service.BookService;
import com.spring.JV32_Relationship.service.CategoryService;

@Controller
public class MainController {

	@Autowired
	private BookService bookService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	BookDetailService bookDetailService;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model, @RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "message", required = false) String message) {
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("status", status);
		model.addAttribute("message", message);
		return "home";
	}

	@RequestMapping("/add-book")
	public String viewFormAddBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("action", "add-book");
		return "Book";
	}

	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public String addBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			model.addAttribute("categories", categoryService.getCategories());
			model.addAttribute("action", "add-book");
			return "Book";
		} else {
			bookService.saveBook(book);
			return "redirect:/home";
		}
	}

	@RequestMapping("/edit-book/{bookId}")
	public String viewFormEditBook(Model model, @PathVariable("bookId") int bookId) {
		model.addAttribute("book", bookService.findBookById(bookId));
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("action", "edit-book");
		return "Book";
	}

	@PostMapping("/edit-book")
	public String editBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			model.addAttribute("categories", categoryService.getCategories());
			model.addAttribute("action", "edit-book");
			return "addBook";
		} else {
			bookService.saveBook(book);
			return "redirect:/home";
		}
	}

	@RequestMapping("/delete-book/{bookId}")
	public String deleteBook(Model model, @PathVariable("bookId") int bookId) {
		boolean isDelete = bookService.delete(bookId);
		if (!isDelete) {
			return "redirect:/home?status=ok&message=delete success";
		} else {
			return "redirect:/home?status=fail&message=delete fail";
		}
	}

}
