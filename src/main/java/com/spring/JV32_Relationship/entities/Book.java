package com.spring.JV32_Relationship.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 100, nullable = false)
	@NotBlank
	private String name;

	@Column(length = 100, nullable = false)
	@NotBlank
	private String author;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne(mappedBy = "book", fetch = FetchType.EAGER)
	private BookDetail bookDetail;

	public Book() {
	}


	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}


	public BookDetail getBookDetail() {
		return bookDetail;
	}


	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public BookDetail getBookDatailEntity() {
		return bookDetail;
	}


	public void setBookDatailEntity(BookDetail bookDatail) {
		this.bookDetail = bookDatail;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Category getCatepory() {
		return category;
	}

	public void setCatepory(Category catepory) {
		this.category = catepory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", author=" + author + ", category.name=" + category.getName() + "]";
	};
	

}
