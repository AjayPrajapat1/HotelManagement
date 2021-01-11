package com.ajay.tech.services;

import java.util.List;

import com.ajay.tech.entity.Menu;

public interface MenuService {

	public List<Menu> getMenusByHotel(String hotelName);
}
