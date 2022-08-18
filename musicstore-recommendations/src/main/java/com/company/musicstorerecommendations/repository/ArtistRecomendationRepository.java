package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.ArtistRecomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ArtistRecomendationRepository extends JpaRepository<ArtistRecomendation, Integer> {
}
