package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "album_recommendation")
public class AlbumRecomendation implements Serializable {
    @Id
    @Column(name = "album_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alid;
    @Column(name = "album_id")
    private Long albumId;
    @Column(name = "user_id")
    private Long useralId;
    @Column(name = "liked")
    private Boolean likedAl;

    public int getAlid() {
        return alid;
    }

    public void setAlid(int alid) {
        this.alid = alid;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getUseralId() {
        return useralId;
    }

    public void setUseralId(Long useralId) {
        this.useralId = useralId;
    }

    public Boolean getLikedAl() {
        return likedAl;
    }

    public void setLikedAl(Boolean likedAl) {
        this.likedAl = likedAl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumRecomendation that = (AlbumRecomendation) o;
        return Objects.equals(alid, that.alid) && Objects.equals(albumId, that.albumId) && Objects.equals(useralId, that.useralId) && Objects.equals(likedAl, that.likedAl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alid, albumId, useralId, likedAl);
    }

    @Override
    public String toString() {
        return "AlbumRecomendation{" +
                "alid=" + alid +
                ", albumId=" + albumId +
                ", useralId=" + useralId +
                ", likedAl=" + likedAl +
                '}';
    }

    public AlbumRecomendation(int alid) {
        this.alid = alid;
    }

    public AlbumRecomendation(Long albumId, Long useralId, Boolean likedAl) {
        this.albumId = albumId;
        this.useralId = useralId;
        this.likedAl = likedAl;
    }

    public AlbumRecomendation(int alid, Long albumId, Long useralId, Boolean likedAl) {
        this.alid = alid;
        this.albumId = albumId;
        this.useralId = useralId;
        this.likedAl = likedAl;
    }

    public AlbumRecomendation() {
    }
}
