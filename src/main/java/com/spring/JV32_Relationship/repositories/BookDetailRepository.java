package com.spring.JV32_Relationship.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.JV32_Relationship.entities.BookDetail;


@Repository
public interface BookDetailRepository extends CrudRepository<BookDetail, Integer> {

}
