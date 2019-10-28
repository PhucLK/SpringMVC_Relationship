package com.spring.JV32_Relationship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.JV32_Relationship.entities.BookDetail;
import com.spring.JV32_Relationship.repositories.BookDetailRepository;

@Service
public class BookDetailService {
	@Autowired
	private BookDetailRepository bookDetailRepository;

	public BookDetail save(BookDetail bo) {
		return bookDetailRepository.save(bo);
	}
}
