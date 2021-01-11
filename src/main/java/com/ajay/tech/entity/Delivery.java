package com.ajay.tech.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Delivery {

	@Id
	@GenericGenerator(name="delivery_id", strategy="increment")
	@GeneratedValue(generator="delivery_id")
	private Integer deliveryId;
	
	@Column
	private String partnerName;
	@Column
	private double charges;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "delivery")
	private Set<Hotel> hotelList = new HashSet<>();


	public Delivery(String partnerName, double charges) {
		super();
		this.partnerName = partnerName;
		this.charges = charges;
	}


	@Override
	public String toString() {
		return "Delivery [partnerName=" + partnerName + ", charges=" + charges + "]";
	}
	
}
