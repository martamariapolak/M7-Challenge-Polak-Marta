package com.company.musicstorerecommendations.controller;


import com.company.musicstorerecommendations.model.ArtistRecomendation;

import com.company.musicstorerecommendations.repository.ArtistRecomendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ArtistRecomendationController {
    @Autowired
   static ArtistRecomendationRepository artistrecomendationrepo;
    @GetMapping("/artists")
    public List<ArtistRecomendation> getArtists() {
        return artistrecomendationrepo.findAll();
    }

    @GetMapping("/artists/{id}")
    public ArtistRecomendation getArtistById(@PathVariable int id)
    {
        Optional<ArtistRecomendation> returnValue  = artistrecomendationrepo.findById(id);
        if(returnValue.isPresent()) {
            return artistrecomendationrepo.findById(id).get();

        } throw new IllegalArgumentException("this.album not exist");
    }

    @PostMapping("/artists")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistRecomendation addArtist(@RequestBody ArtistRecomendation artistRecomendation) {
        return artistrecomendationrepo.save(artistRecomendation);
    }

    @PutMapping("/artists")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@RequestBody ArtistRecomendation artistrecomendation) {
        artistrecomendationrepo.save(artistrecomendation);
    }

    public ArtistRecomendationController(ArtistRecomendationRepository artistrecomendationrepo) {
        this.artistrecomendationrepo = artistrecomendationrepo;
    }

    @DeleteMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteArtist(@PathVariable int id) {
        artistrecomendationrepo.deleteById(id);
        return false;
    }


}


