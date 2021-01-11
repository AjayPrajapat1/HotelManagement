package com.ajay.tech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.tech.entity.Menu;
import com.ajay.tech.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<Menu> getMenusByHotel(String hotelName) {
		//return menuRepository.findByHotelHotelName(hotelName);
		//return menuRepository.findByHotel(hotelName);
		return menuRepository.findBySqlHotel(hotelName);
	}

}
