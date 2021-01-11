package com.ajay.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Menu {

	@Id
	@GenericGenerator(name="menu_id", strategy="increment")
	@GeneratedValue(generator="menu_id")
	private Integer menuId;
	
	@Column
	private String menuName;
	@Column
	private double price;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	public Menu(String menuName, double price, Hotel hotel) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", price=" + price + "]";
	}

	
	
}
