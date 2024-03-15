package com.example.interviewtrackerdemo.controller;
import com.example.interviewtrackerdemo.entity.InterviewTracker;
import com.example.interviewtrackerdemo.entity.Review;
import com.example.interviewtrackerdemo.exception.IdNotFoundException;
import com.example.interviewtrackerdemo.services.InterviewTrackerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inter")
public class InterviewTrackerController {
	
	
    @Autowired
    private InterviewTrackerService interviewTrackerService;

    //inserting the details in database;
    @PostMapping
    public InterviewTracker addDetails(@RequestBody InterviewTracker interviewTracker)
    {
        return interviewTrackerService.saveDetails(interviewTracker);
    }

    // fetching all the data from database 
    @GetMapping
    public List<InterviewTracker> retrieveAllDetails() {
        return interviewTrackerService.retriveAllDetails();
    }
    
    // fetching the details by id 
    @GetMapping("/{id}")
    public InterviewTracker retriveDetails(@Valid @PathVariable("id") long id) throws IdNotFoundException {
        return interviewTrackerService.retrieveDetails(id);
    }

    // we have created the review as new entity with the updating attributes so we are using in this 
    @PutMapping("/{id}")
    public InterviewTracker updateDetails(@Valid @PathVariable("id") long id, @RequestBody Review review) throws IdNotFoundException {
        return interviewTrackerService.giveFeedback(id,review);
    }
}

