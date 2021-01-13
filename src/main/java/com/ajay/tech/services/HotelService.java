package com.ajay.tech.services;

import java.util.List;

import com.ajay.tech.entity.Hotel;
import com.ajay.tech.exception.HotelNotFoundException;
import com.ajay.tech.exception.IdNotFoundException;

public interface HotelService {

	public Hotel add(Hotel hotel);

	public void update(Hotel hotel);

	public Hotel getById(int hotelId) throws IdNotFoundException;

	void deleteHotel(int hotelId) throws IdNotFoundException;

	public List<Hotel> getAllHotels();

	public List<Hotel> getHotelsByCity(String city) throws HotelNotFoundException;

	public List<Hotel> getHotelsByMenu(String menuName) throws HotelNotFoundException;

	public List<Hotel> getHotelsByDelivery(String partnerName) throws HotelNotFoundException;

	public List<Hotel> getHotelsByLocation(String location) throws HotelNotFoundException;

	public List<Hotel> getHotelsByLocationAndMenu(String location, String menuName) throws HotelNotFoundException;

}
