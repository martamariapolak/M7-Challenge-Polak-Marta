package com.company.musicstorecatalog.controller;
import com.company.musicstorecatalog.service.ServiceLayer;
import com.company.musicstorecatalog.viewmodel.AlbumViewModel;
//import com.company.reccoll.model.Artist;
//import com.company.reccoll.repository.ArtistRepository;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.repository.ArtistRepository;
import com.company.musicstorecatalog.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {
    @Autowired
    ArtistRepository repo;

    @GetMapping("/artist")
    public List<Artist> getArtists() {
        return repo.findAll();
    }

    @GetMapping("/artist/{id}")
    public Artist getArtistById(@PathVariable int id) {
        Optional<Artist> returnVal = repo.findById((long) id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/artist")
    @ResponseStatus(HttpStatus.CREATED)
    public Artist addArtist(@RequestBody Artist artist) {
        return repo.save(artist);
    }

    @PutMapping("/artist")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@RequestBody Artist artist) {
        repo.save(artist);
    }

    @DeleteMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id) {
        repo.deleteById((long) id);
    }
}



