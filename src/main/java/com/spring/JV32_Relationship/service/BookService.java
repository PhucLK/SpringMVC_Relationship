package com.spring.JV32_Relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.JV32_Relationship.entities.Book;
import com.spring.JV32_Relationship.entities.BookDetail;
import com.spring.JV32_Relationship.repositories.BookDetailRepository;
import com.spring.JV32_Relationship.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	BookDetailRepository bookDetailRepository;

	public Book saveB(Book b) {
		return bookRepository.save(b);
	}

//	public List<Book> findBookJoinCategoty(String nameCategory, String nameBook) {
//		return bookRepository.findBookJoinCategoty(nameCategory, nameBook);
//	}

	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}

	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		book = bookRepository.save(book);
		if (book.getId() > 0) {
			BookDetail bookDetail = book.getBookDatailEntity();
			bookDetail.setBook(book);
			bookDetailRepository.save(bookDetail);
			book.setBookDatailEntity(bookDetail);
		}
		return book;
	}

	public Book findBookById(int bookId) {
		Book book = bookRepository.findOne(bookId);
		if (book == null) {
			book = new Book();
		}
		return book;
	}

	public boolean delete(int bookId) {
		bookRepository.delete(bookId);
		return bookRepository.exists(bookId);
	}
}
