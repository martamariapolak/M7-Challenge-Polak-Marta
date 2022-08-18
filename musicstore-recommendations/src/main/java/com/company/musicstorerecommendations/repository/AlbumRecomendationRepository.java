package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.AlbumRecomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface AlbumRecomendationRepository extends JpaRepository<AlbumRecomendation, Integer> {

}
