package com.ajay.tech.services;

import java.util.List;
import java.util.Optional;

import com.ajay.tech.entity.Hotel;

public interface HotelService {

	public void add(Hotel hotel);
	public void update(Hotel hotel);
	public Optional<Hotel> getById(int hotelId);
	void deleteHotel(int hotelId);
	
	public List<Hotel> getHotelsByCity(String city);
	public List<Hotel> getHotelsByMenu(String menuName);
	public List<Hotel> getHotelsByDelivery(String partnerName);
	public List<Hotel> getHotelsByLocation(String location);
	public List<Hotel> getHotelsByLocationAndMenu(String location, String menuName);
	
}
