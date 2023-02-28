package com.adidas.backend.prioritysaleservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adidas.backend.prioritysaleservice.entity.MemberInformation;

public interface MemberInformationRepository extends MongoRepository<MemberInformation, String> {
    Optional<MemberInformation> findByEmail(String email);

    @Aggregation(pipeline = {
            "{ '$sort' : { 'points' : -1, 'registrationDate': -1 } }",
            "{ '$limit' : 1 }"
    })
    Optional<MemberInformation> findFirstUserInQueue();
}