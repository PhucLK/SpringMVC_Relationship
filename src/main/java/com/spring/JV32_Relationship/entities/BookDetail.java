package com.spring.JV32_Relationship.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BookDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true,nullable = false)
	@NotBlank
	private String isbn;

	@Column(name = "number_of_page")
	private int numberOfPage;

	private double price;
	
	private String description;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;

	@OneToOne
	@JoinColumn(name = "book_id")
	private Book book;

	public BookDetail() {
	}


	public Date getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	public BookDetail(String isbn, int numberOfPage, double price, Date publisDate) {
		super();
		this.isbn = isbn;
		this.numberOfPage = numberOfPage;
		this.price = price;
		this.publishDate = publisDate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublisDate() {
		return publishDate;
	}

	public void setPublisDate(Date publisDate) {
		this.publishDate = publisDate;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


}
