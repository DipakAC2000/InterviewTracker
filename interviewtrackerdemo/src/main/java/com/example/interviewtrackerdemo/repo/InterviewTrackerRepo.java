package com.example.interviewtrackerdemo.repo;
import com.example.interviewtrackerdemo.entity.InterviewTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//includes all crud operation
@Repository
public interface InterviewTrackerRepo extends JpaRepository<InterviewTracker, Long> {

}
