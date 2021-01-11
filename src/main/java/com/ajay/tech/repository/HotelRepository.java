package com.ajay.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajay.tech.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	public List<Hotel> findByAddressCity(String city);

	public List<Hotel> findByAddressStreetName(String location);

	@Query("FROM Hotel h INNER JOIN h.menuList mn WHERE mn.menuName=?1")
	public List<Hotel> getHotelsByMenu(String menuName);
	
	@Query("FROM Hotel h INNER JOIN h.delivery d WHERE d.partnerName=?1")
	public List<Hotel> getHotelsByDelivery(String partnerName);

}
