package com.ajay.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;
	
	@Column
	private String menuName;
	@Column
	private double price;


	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;  
}
