package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Table(name = "track_recommendation")
    public class TrackRecommendation implements Serializable  {
    @Id
    @Column(name = "track_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "track_id")
    private Long trackId;
    @Column(name = "user_id")
    private Long userId;
    private Boolean liked;

    public TrackRecommendation(int id, Long trackId, Long userId, Boolean liked) {
        this.id = id;
        this.trackId = trackId;
        this.userId = userId;
        this.liked = liked;
    }

    public TrackRecommendation(Long trackId, Long userId, Boolean liked) {
        this.trackId = trackId;
        this.userId = userId;
        this.liked = liked;
    }

    public TrackRecommendation() {
    }

    public TrackRecommendation(int id) {
        this.id = id;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Long getTrackId() {
            return trackId;
        }

        public void setTrackId(Long trackId) {
            this.trackId = trackId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Boolean getLiked() {
            return liked;
        }

        public void setLiked(Boolean liked) {
            this.liked = liked;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrackRecommendation that = (TrackRecommendation) o;
            return Objects.equals(id, that.id) && Objects.equals(trackId, that.trackId) && Objects.equals(userId, that.userId) && Objects.equals(liked, that.liked);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, trackId, userId, liked);
        }

        @Override
        public String toString() {
            return "TrackRecommendation{" +
                    "id=" + id +
                    ", trackId=" + trackId +
                    ", userId=" + userId +
                    ", liked=" + liked +
                    '}';
        }
    }
