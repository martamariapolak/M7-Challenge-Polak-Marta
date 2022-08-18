package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.TrackRecommendation;
import com.company.musicstorerecommendations.repository.TrackRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
    public class TrackRecomendationController {
        //@Autowired
        // ServiceLayer serviceLayer;
        @Autowired
    static TrackRecommendationRepository trackrecomendationrepo;



    @GetMapping("/tracks")
        public List<TrackRecommendation> getTracks() {
            return trackrecomendationrepo.findAll();
        }

        @GetMapping("/tracks/{id}")
        public TrackRecommendation getTrackById(@PathVariable int id)
        {
            Optional<TrackRecommendation> returnValue  = trackrecomendationrepo.findById(id);
            if(returnValue.isPresent()){
            return trackrecomendationrepo.findById(id).get();

        } throw new IllegalArgumentException("this track not exist");
        }

        @PostMapping("/tracks")
        @ResponseStatus(HttpStatus.CREATED)
        public TrackRecommendation addTrack(@RequestBody TrackRecommendation trackRecommendation) {
            return trackrecomendationrepo.save(trackRecommendation);
        }


        @PutMapping("/tracks")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateAlbum(@RequestBody TrackRecommendation trackRecomendation) {
            trackrecomendationrepo.save(trackRecomendation);
        }


    public TrackRecomendationController(TrackRecommendationRepository trackrecomendationrepo) {
        this.trackrecomendationrepo=trackrecomendationrepo;
    }

    @DeleteMapping("/tracks/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean deleteTrack(@PathVariable int id) {
            trackrecomendationrepo.deleteById(id);
            return false;
        }


    }


