package com.adidas.backend.prioritysaleservice.service.prioritaryqueue;

import com.adidas.backend.prioritysaleservice.entity.MemberInformation;
import com.adidas.backend.prioritysaleservice.exception.CanNotDequeueUserException;
import com.adidas.backend.prioritysaleservice.exception.CanNotQueueUserException;
import com.adidas.backend.prioritysaleservice.repository.MemberInformationRepository;
import com.adidas.backend.prioritysaleservice.service.adiclub.dto.AdiClubMemberInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrioritaryQueueService {
    @Autowired
    private MemberInformationRepository memberInformationRepository;

    public MemberInformation dequeueFirst() throws CanNotDequeueUserException {

        Optional<MemberInformation> userInQueue = this.memberInformationRepository.findFirstUserInQueue();

        if (userInQueue.isEmpty()) {
            throw new CanNotDequeueUserException("Can not dequeue user of an empty list");
        }

        MemberInformation member = userInQueue.get();

        this.memberInformationRepository.delete(member);

        return member;
    }

    public void addUserToQueue(AdiClubMemberInfoDto user) throws CanNotQueueUserException {
        Optional<MemberInformation> memberInList = this.memberInformationRepository.findByEmail(user.getEmail());

        if (memberInList.isPresent()) {
            throw new CanNotQueueUserException("User is already in queue");
        }

        MemberInformation member = user.toMemberInformation();
        this.memberInformationRepository.save(member);
    }

    public String getQueue() {
        StringBuilder builder = new StringBuilder();

        Sort sortCriteria = Sort.by(Sort.Direction.DESC, "points", "registrationDate");

        List<MemberInformation> queue = this.memberInformationRepository.findAll(sortCriteria);

        queue.forEach(member ->
                builder
                        .append(member.getEmail())
                        .append(" : ")
                        .append(member.getPoints())
                        .append(" : ")
                        .append(member.getRegistrationDate())
                        .append("\n"));
        return builder.toString();
    }
}