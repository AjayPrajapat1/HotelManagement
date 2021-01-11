package com.ajay.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
	@Id
	@GenericGenerator(name="add_id", strategy="increment")
	@GeneratedValue(generator="add_id")
	private Integer addressId;
	
	@Column
	private String city;
	
	@Column
	private String streetName;

	@Column
	private long zipcode;
	
	@Column
	private String state;

	public Address(String city, String streetName, long zipcode, String state) {
		super();
		this.city = city;
		this.streetName = streetName;
		this.zipcode = zipcode;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", streetName=" + streetName + ", zipcode=" + zipcode + ", state=" + state
				+ "]";
	}

}
