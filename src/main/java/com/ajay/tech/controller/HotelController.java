package com.ajay.tech.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.tech.entity.Hotel;
import com.ajay.tech.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		Hotel newHotel = hotelService.add(hotel);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Hotel added successfully");
		return ResponseEntity.ok().headers(headers).body(newHotel);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel){
		hotelService.update(hotel);
		return ResponseEntity.ok("Updated");
	}
	
	@GetMapping("/hotelById/{hotelId}")
	public ResponseEntity<Optional<Hotel>> getHotelById(@PathVariable int hotelId){
		Optional<Hotel> newHotel = hotelService.getById(hotelId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting one hotel instance");
		return ResponseEntity.ok().headers(headers).body(newHotel);
	}
	
	
	
	
	
}
