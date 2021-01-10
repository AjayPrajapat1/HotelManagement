package com.ajay.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.tech.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
