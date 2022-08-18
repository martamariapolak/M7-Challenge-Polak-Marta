package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "artist_recommendation")
public class ArtistRecomendation implements Serializable {
    @Id
    @Column(name = "artist_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ida;
    @Column(name = "artist_id")
    private Long artistId;
    @Column(name = "user_id")
    private Long useraId;
    @Column(name ="liked")
    private Boolean likedA;



    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getUseraId() {
        return useraId;
    }

    public void setUseraId(Long useraId) {
        this.useraId = useraId;
    }

    public Boolean getLikedA() {
        return likedA;
    }

    public void setLikedA(Boolean likedA) {
        this.likedA = likedA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistRecomendation that = (ArtistRecomendation) o;
        return Objects.equals(ida, that.ida) && Objects.equals(artistId, that.artistId) && Objects.equals(useraId, that.useraId) && Objects.equals(likedA, that.likedA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ida, artistId, useraId, likedA);
    }

    public ArtistRecomendation(Long artistId, Long useraId, Boolean likedA) {
        this.artistId = artistId;
        this.useraId = useraId;
        this.likedA = likedA;
    }

    public ArtistRecomendation(int ida, Long artistId, Long useraId, Boolean likedA) {
        this.ida = ida;
        this.artistId = artistId;
        this.useraId = useraId;
        this.likedA = likedA;
    }

    public ArtistRecomendation(int ida) {
        this.ida = ida;
    }

    public ArtistRecomendation() {
    }

    @Override
    public String toString() {
        return "ArtistRecomendation{" +
                "ida=" + ida +
                ", artistId=" + artistId +
                ", useraId=" + useraId +
                ", likedA=" + likedA +
                '}';


    }
}