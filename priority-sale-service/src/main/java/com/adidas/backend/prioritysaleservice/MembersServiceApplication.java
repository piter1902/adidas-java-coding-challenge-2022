package com.adidas.backend.prioritysaleservice;

import com.adidas.backend.prioritysaleservice.repository.MemberInformationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableAsync
@EnableMongoRepositories(basePackageClasses = MemberInformationRepository.class)
public class MembersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembersServiceApplication.class, args);
    }

}
