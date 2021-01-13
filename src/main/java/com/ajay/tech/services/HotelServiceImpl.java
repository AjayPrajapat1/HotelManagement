package com.ajay.tech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.tech.entity.Hotel;
import com.ajay.tech.exception.HotelNotFoundException;
import com.ajay.tech.exception.IdNotFoundException;
import com.ajay.tech.repository.HotelRepository;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Hotel add(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public void update(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	@Transactional(readOnly = true)
	public Hotel getById(int hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepository.deleteById(hotelId);
	}

	@Override
	public List<Hotel> getHotelsByCity(String city) {
		List<Hotel> list = hotelRepository.findByAddressCity(city);
		if (list == null || list.size() == 0) {
			throw new HotelNotFoundException("Hotels Not Found");
		}
		return list;
		
	}

	@Override
	public List<Hotel> getHotelsByMenu(String menuName) {
		List<Hotel> list = hotelRepository.getHotelsByMenu(menuName);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels Not Found");
		}
		return list;
	}

	@Override
	public List<Hotel> getHotelsByDelivery(String partnerName) {
		List<Hotel> list = hotelRepository.getHotelsByDelivery(partnerName);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels Not Found");
		}
		return list;
	}

	@Override
	public List<Hotel> getHotelsByLocation(String location) {
		List<Hotel> list = hotelRepository.findByAddressStreetName(location);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels Not Found");
		}
		return list;
	}

	@Override
	public List<Hotel> getHotelsByLocationAndMenu(String location, String menuName) {
		List<Hotel> list = hotelRepository.getHotelsByLocationAndMenu(location, menuName);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels Not Found");
		}
		return list;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> list = hotelRepository.findAll();
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels Not Found");
		}
		return list;
	}

}
