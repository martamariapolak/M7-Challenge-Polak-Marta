package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Objects;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "label_recommendation")
public class LabelRecomendation implements Serializable {
    @Id
    @Column(name = "label_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;
    @Column(name = "label_id")
    private Long labelId;
    @Column(name = "user_id")
    private Long userlId;
    @Column(name ="liked")
            private Boolean likedL;

    public LabelRecomendation(int lid) {
        this.lid = lid;
    }

    public LabelRecomendation(Long labelId, Long userlId, Boolean likedL) {
        this.labelId = labelId;
        this.userlId = userlId;
        this.likedL = likedL;
    }

    public LabelRecomendation(int lid, Long labelId, Long userlId, Boolean likedL) {
        this.lid = lid;
        this.labelId = labelId;
        this.userlId = userlId;
        this.likedL = likedL;
    }

    public LabelRecomendation() {
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getUserlId() {
        return userlId;
    }

    public void setUserlId(Long userlId) {
        this.userlId = userlId;
    }

    public Boolean getLikedL() {
        return likedL;
    }

    public void setLikedL(Boolean likedL) {
        this.likedL = likedL;
    }

    @Override
    public String toString() {
        return "LabelRecomendation{" +
                "lid=" + lid +
                ", labelId=" + labelId +
                ", userlId=" + userlId +
                ", likedL=" + likedL +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelRecomendation that = (LabelRecomendation) o;
        return Objects.equals(lid, that.lid) && Objects.equals(labelId, that.labelId) && Objects.equals(userlId, that.userlId) && Objects.equals(likedL, that.likedL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lid, labelId, userlId, likedL);
    }
}