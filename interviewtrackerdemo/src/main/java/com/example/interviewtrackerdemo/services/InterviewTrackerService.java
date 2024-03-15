package com.example.interviewtrackerdemo.services;



import com.example.interviewtrackerdemo.entity.InterviewTracker;
import com.example.interviewtrackerdemo.entity.Review;
import com.example.interviewtrackerdemo.exception.IdNotFoundException;
import com.example.interviewtrackerdemo.repo.InterviewTrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewTrackerService {
	
    @Autowired
    private InterviewTrackerRepo interviewTrackerRepo;

    // this is the service method which is implementation of inserting/posting the details in database
    // in this we are changing the pan number which is inserted by user in encoded type as it's confidential 
    public InterviewTracker saveDetails(InterviewTracker interviewTracker)
    {
        String encodedPanCardNumber = encodePanCardNumber(interviewTracker.getPanCardNo());
        interviewTracker.setPanCardNo(encodedPanCardNumber);
        return interviewTrackerRepo.save(interviewTracker);
    }

    //getting all details implementation
    public List<InterviewTracker> retriveAllDetails(){
        return interviewTrackerRepo.findAll();
    }

    /* fetching the details by id and here we are checking if ID is not present then it will throw an exception
       which is handled by global exception handler.   
    */
    public InterviewTracker retrieveDetails(long id) throws IdNotFoundException {
        if(interviewTrackerRepo.findById(id).isEmpty())
            throw new IdNotFoundException("Traking Id Not Present");
        return interviewTrackerRepo.findById(id).get();
    }

    //this is related to updating the data as now need to update the feeback and give judgement to candidate
    public InterviewTracker giveFeedback(long id, Review review) throws IdNotFoundException {
        Optional<InterviewTracker> opt = interviewTrackerRepo.findById(id);
        if (opt.isEmpty())
        {
            throw new IdNotFoundException("Traking Id Not Found");
        }
            InterviewTracker existingfeedback = opt.get();
            existingfeedback.setFeedback(review.getFeedback());
            existingfeedback.setJudgment(review.getJudgement());
            return interviewTrackerRepo.save(existingfeedback);
    }

    private String encodePanCardNumber(String panCardNumber) {
        // Implement your encoding algorithm here
        // Example: Base64 encoding
        byte[] encodedBytes = Base64.getEncoder().encode(panCardNumber.getBytes());
        return new String(encodedBytes);
    }
}

