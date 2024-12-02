package com.timdoornek.baseball.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "id", length = 20, nullable = false)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "position", length = 20, nullable = false)
    private String position;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dob;

    @Column(name = "pob", length = 255, nullable = true)
    private String pob;

    @Column(name = "height", nullable = true)
    private Integer height;

    @Column(name = "weight", nullable = true)
    private Integer weight;

    @Column(name = "acquisition_type_cd", length = 2, nullable = true)
    private String acquisitionTypeCd;

    @Column(name = "image_url", length = 255, nullable = true)
    private String imageUrl;

    @Column(name = "throws", length = 2, nullable = true)
    private String throwsString;

    @Column(name = "bats", length = 2, nullable = true)
    private String bats;

    @Column(name = "acquisition", length = 50, nullable = true)
    private String acquisition;

    public Player() {
    }

    public Player(String id, String name, String position, LocalDate dob, String acquisitionTypeCd) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dob = dob;
        this.acquisitionTypeCd = acquisitionTypeCd;
    }

    public Player(String id, String name, String position, LocalDate dob, String pob, Integer height, Integer weight,
            String acquisitionTypeCd, String imageUrl, String throwsString, String bats, String acquisition) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dob = dob;
        this.pob = pob;
        this.height = height;
        this.weight = weight;
        this.acquisitionTypeCd = acquisitionTypeCd;
        this.imageUrl = imageUrl;
        this.throwsString = throwsString;
        this.bats = bats;
        this.acquisition = acquisition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAcquisitionTypeCd() {
        return acquisitionTypeCd;
    }

    public void setAcquisitionTypeCd(String acquisitionTypeCd) {
        this.acquisitionTypeCd = acquisitionTypeCd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThrowsString() {
        return throwsString;
    }

    public void setThrowsString(String throwsString) {
        this.throwsString = throwsString;
    }

    public String getBats() {
        return bats;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public String getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(String acquisition) {
        this.acquisition = acquisition;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((dob == null) ? 0 : dob.hashCode());
        result = prime * result + ((pob == null) ? 0 : pob.hashCode());
        result = prime * result + ((height == null) ? 0 : height.hashCode());
        result = prime * result + ((weight == null) ? 0 : weight.hashCode());
        result = prime * result + ((acquisitionTypeCd == null) ? 0 : acquisitionTypeCd.hashCode());
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        result = prime * result + ((throwsString == null) ? 0 : throwsString.hashCode());
        result = prime * result + ((bats == null) ? 0 : bats.hashCode());
        result = prime * result + ((acquisition == null) ? 0 : acquisition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (dob == null) {
            if (other.dob != null)
                return false;
        } else if (!dob.equals(other.dob))
            return false;
        if (pob == null) {
            if (other.pob != null)
                return false;
        } else if (!pob.equals(other.pob))
            return false;
        if (height == null) {
            if (other.height != null)
                return false;
        } else if (!height.equals(other.height))
            return false;
        if (weight == null) {
            if (other.weight != null)
                return false;
        } else if (!weight.equals(other.weight))
            return false;
        if (acquisitionTypeCd == null) {
            if (other.acquisitionTypeCd != null)
                return false;
        } else if (!acquisitionTypeCd.equals(other.acquisitionTypeCd))
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        } else if (!imageUrl.equals(other.imageUrl))
            return false;
        if (throwsString == null) {
            if (other.throwsString != null)
                return false;
        } else if (!throwsString.equals(other.throwsString))
            return false;
        if (bats == null) {
            if (other.bats != null)
                return false;
        } else if (!bats.equals(other.bats))
            return false;
        if (acquisition == null) {
            if (other.acquisition != null)
                return false;
        } else if (!acquisition.equals(other.acquisition))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", position=" + position + ", dob=" + dob + ", pob=" + pob
                + ", height=" + height
                + ", weight=" + weight + ", acquisitionTypeCd="
                + acquisitionTypeCd + ", imageUrl=" + imageUrl + ", throwsString=" + throwsString + ", bats=" + bats
                + ", acquisition=" + acquisition + "]";
    }

}
