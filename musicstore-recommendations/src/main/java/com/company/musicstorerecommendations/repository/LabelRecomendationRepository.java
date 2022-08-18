package com.company.musicstorerecommendations.repository;


import com.company.musicstorerecommendations.model.LabelRecomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LabelRecomendationRepository extends JpaRepository<LabelRecomendation, Integer> {
}
