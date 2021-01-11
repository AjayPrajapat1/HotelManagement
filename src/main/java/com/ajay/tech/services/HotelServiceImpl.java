package com.ajay.tech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.tech.entity.Hotel;
import com.ajay.tech.repository.HotelRepository;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public void update(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Hotel> getById(int hotelId) {
		return hotelRepository.findById(hotelId);
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepository.deleteById(hotelId);
	}

	@Override
	public List<Hotel> getHotelsByCity(String city) {
		return hotelRepository.findByAddressCity(city);
	}

	@Override
	public List<Hotel> getHotelsByMenu(String menuName) {
		return hotelRepository.getHotelsByMenu(menuName);
	}

	@Override
	public List<Hotel> getHotelsByDelivery(String partnerName) {
		return hotelRepository.getHotelsByDelivery(partnerName);
	}

	@Override
	public List<Hotel> getHotelsByLocation(String location) {
		return hotelRepository.findByAddressStreetName(location);
	}

	@Override
	public List<Hotel> getHotelsByLocationAndMenu(String location, String menuName) {
		return hotelRepository.getHotelsByMenu(menuName);
	}

}
