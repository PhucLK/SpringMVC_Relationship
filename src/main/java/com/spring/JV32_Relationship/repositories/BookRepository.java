package com.spring.JV32_Relationship.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.JV32_Relationship.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

//	@Query("Select b from BookEntity b where b.category.name like ?1 and b.name like ?2")
//	public List<Book> findBookJoinCategoty(String nameCategory, String nameBook);
}
