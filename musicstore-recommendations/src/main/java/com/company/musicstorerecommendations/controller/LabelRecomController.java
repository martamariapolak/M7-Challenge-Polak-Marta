package com.company.musicstorerecommendations.controller;


import com.company.musicstorerecommendations.model.LabelRecomendation;

import com.company.musicstorerecommendations.repository.LabelRecomendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class LabelRecomController {

    @Autowired
  static  LabelRecomendationRepository labelrecomendationrepo;



    @GetMapping("/labels")
    public List<LabelRecomendation> getLabels() {
        return  labelrecomendationrepo.findAll();
    }

    @GetMapping("/labels/{id}")
    public   LabelRecomendation getLabelById(@PathVariable int id)
    {
        Optional<LabelRecomendation> returnValue  = labelrecomendationrepo.findById(id);
        if(returnValue.isPresent()){
        return labelrecomendationrepo.findById(id).get();

    } throw new IllegalArgumentException("this.album not exist");
    }

    @PostMapping("/labels")
    @ResponseStatus(HttpStatus.CREATED)
    public LabelRecomendation addLabel(@RequestBody LabelRecomendation labelRecomendation) {
        return labelrecomendationrepo.save(labelRecomendation);
    }

    @PutMapping("/labels")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@RequestBody LabelRecomendation labelRecomendation) {
        labelrecomendationrepo.save(labelRecomendation);
    }

    public LabelRecomController(LabelRecomendationRepository labelrecomendationrepo) {
        this.labelrecomendationrepo = labelrecomendationrepo;
    }

    @DeleteMapping("/labels/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteLabel(@PathVariable int id) {
        labelrecomendationrepo.deleteById(id);
        return false;
    }


}



