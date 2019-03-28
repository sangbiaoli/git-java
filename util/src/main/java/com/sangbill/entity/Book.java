package com.sangbill.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("book")
public class Book {

    // 别名注解，这个别名就是XML文档中的元素名，Java的属性名不一定要与别名一致
    @XStreamAlias("name")
    private String name;
    
    @XStreamAlias("author")
    private String author;
    
    // 属性注解，此price就是book的属性，在XML中显示为：<book price="108">
    @XStreamAsAttribute()
    @XStreamAlias("price")
    private String price;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}