package com.ajay.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		Hotel newHotel = hotelService.add(hotel);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Hotel added successfully");
		return ResponseEntity.ok().headers(headers).body(newHotel);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel) {
		hotelService.update(hotel);
		return ResponseEntity.ok("Updated");
	}

	@GetMapping("/hotelById/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId) {
		Hotel newHotel = hotelService.getById(hotelId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting one hotel instance");
		return ResponseEntity.ok().headers(headers).body(newHotel);
	}

	@DeleteMapping("/delete/{hotelId}")
	public ResponseEntity<Void> deleteHotel(@PathVariable int hotelId) {
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/allHotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotel = hotelService.getAllHotels();
		return ResponseEntity.ok().header("desc", "get all hotels").body(hotel);
	}

	@GetMapping("/hotelByCity/{city}")
	public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String city) {
		List<Hotel> hotel = hotelService.getHotelsByCity(city);
		return ResponseEntity.ok().body(hotel);
	}

	@GetMapping("/hotelByMenu/{menu}")
	public ResponseEntity<List<Hotel>> getHotelsByMenu(@PathVariable String menu) {
		List<Hotel> hotel = hotelService.getHotelsByMenu(menu);
		return ResponseEntity.ok().body(hotel);
	}

	@GetMapping("/hotelByDelivery/{partnerName}")
	public ResponseEntity<List<Hotel>> getHotelsByDelivery(@PathVariable String partnerName) {
		List<Hotel> hotel = hotelService.getHotelsByDelivery(partnerName);
		return ResponseEntity.ok().body(hotel);
	}

	@GetMapping("/hotelByLocation/{location}")
	public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable String location) {
		List<Hotel> hotel = hotelService.getHotelsByLocation(location);
		return ResponseEntity.ok().body(hotel);
	}

	@GetMapping("/hotelByLocationAndMenu/{location}/menuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByLocationAndMenu(@PathVariable String location,
			@PathVariable String menuName) {
		List<Hotel> hotel = hotelService.getHotelsByLocationAndMenu(location, menuName);
		return ResponseEntity.ok().body(hotel);
	}

}
