package com.ripon.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "Book", schema = "db007")
public class Book {

	@Id
	@Column(name = "Id", nullable = false)
	private long Id;
	@Column(name = "bname", nullable = false)
	private String bname;
	@Column(name = "author", nullable = false)
	private String author; 
	@Column(name = "price", nullable = false)
	private double price;
	@Column(name = "totalpage", nullable = false)
	private long totalpage;
	@Column(name = "image", nullable = false)
	private String image;
	
	//getters and setters
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	

}
