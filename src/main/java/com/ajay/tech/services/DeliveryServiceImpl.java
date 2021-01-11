package com.ajay.tech.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.tech.entity.Delivery;
import com.ajay.tech.repository.DeliveryRepository;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Delivery> getDeliveryById(int deliverylId) {
		return deliveryRepository.findById(deliverylId);
	}

	@Override
	@Transactional(readOnly = true)
	public Delivery getDeliveryByPartner(String partner) {
		return deliveryRepository.findByPartnerName(partner);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void DeleteDelivery(int deliveryId) {
		deliveryRepository.deleteById(deliveryId);
		
	}

}
