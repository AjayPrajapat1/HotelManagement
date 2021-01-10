package com.ajay.tech.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deliveryId;
	
	@Column
	private String partnerName;
	@Column
	private double charges;
	
	@ManyToMany(mappedBy = "delivery")
	private Set<Hotel> hotelList = new HashSet<>();
	
}
