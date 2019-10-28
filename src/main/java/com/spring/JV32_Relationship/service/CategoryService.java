package com.spring.JV32_Relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.JV32_Relationship.entities.Category;
import com.spring.JV32_Relationship.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void save(Category ca) {

		categoryRepository.save(ca);

	}

	public List<Category> getCategories() {
		return (List<Category>) categoryRepository.findAll();
	}
}
