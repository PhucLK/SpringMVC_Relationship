package com.spring.JV32_Relationship.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.JV32_Relationship.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
