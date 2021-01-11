package com.ajay.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajay.tech.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	//Derived Query
	public List<Menu> findByHotelHotelName(String hotelName);

	//JPQL
	@Query("FROM Menu m INNER JOIN m.hotel h WHERE h.hotelName=?1")
	public List<Menu> findByHotel(String hotelName);
	
	//with native sql
	@Query(value = "select * from menu m inner join hotel h on m.hotel_id = h.hotel_id where h.hotel_name=?1", nativeQuery = true)
	public List<Menu> findBySqlHotel(String hotelName);

	
	
}
