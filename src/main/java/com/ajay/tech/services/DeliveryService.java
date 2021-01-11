package com.ajay.tech.services;

import java.util.Optional;

import com.ajay.tech.entity.Delivery;

public interface DeliveryService {

	public void addDelivery(Delivery delivery);
	public void updateDelivery(Delivery delivery);
	public Optional<Delivery> getDeliveryById(int deliverylId);
	public Delivery getDeliveryByPartner(String partner);
	public void DeleteDelivery(int deliveryId);
}
