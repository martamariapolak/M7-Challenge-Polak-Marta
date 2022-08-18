package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.AlbumRecomendation;
import com.company.musicstorerecommendations.repository.AlbumRecomendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;





@RestController
 public class AlbumRecomController {
    //@Autowired
   // ServiceLayer serviceLayer;
@Autowired
static  AlbumRecomendationRepository albumrecomendationrepo;
    @GetMapping("/albums")
    public List<AlbumRecomendation> getAlbums() {
        return albumrecomendationrepo.findAll();
    }

    @GetMapping("/albums/{id}")
    public  AlbumRecomendation getAlbumById(@PathVariable int id)
    {
        Optional<AlbumRecomendation> returnValue= albumrecomendationrepo.findById(id);
        if(returnValue.isPresent()){
        return albumrecomendationrepo.findById(id).get();

    } throw new IllegalArgumentException("this.album not exist");
    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumRecomendation addAlbum(@RequestBody AlbumRecomendation albumRecomendation) {
        return albumrecomendationrepo.save(albumRecomendation);
    }

    @PutMapping("/albums")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody AlbumRecomendation albumrecomendation) {
        albumrecomendationrepo.save(albumrecomendation);
    }

    public AlbumRecomController(AlbumRecomendationRepository albumrecomendationrepo) {
        this.albumrecomendationrepo = albumrecomendationrepo;
    }

    @DeleteMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAlbum(@PathVariable int id) {
        albumrecomendationrepo.deleteById(id);
        return false;
    }


}
