package com.sapient.ota.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ota.entities.Ticket;

@Repository
public interface BookingRepository extends MongoRepository<Ticket, String> {
	
	Ticket findByUrn(String urn);
}
 