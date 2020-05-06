package com.it.laura.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ParkingPlace.
 */
@Entity
@Table(name = "parking_place")
public class ParkingPlace implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_place")
    private Integer numberPlace;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Floor floor;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberPlace() {
        return numberPlace;
    }

    public ParkingPlace numberPlace(Integer numberPlace) {
        this.numberPlace = numberPlace;
        return this;
    }

    public void setNumberPlace(Integer numberPlace) {
        this.numberPlace = numberPlace;
    }

    public Floor getFloor() {
        return floor;
    }

    public ParkingPlace floor(Floor floor) {
        this.floor = floor;
        return this;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParkingPlace parkingPlace = (ParkingPlace) o;
        if (parkingPlace.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), parkingPlace.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
            "id=" + getId() +
            ", numberPlace=" + getNumberPlace() +
            "}";
    }
}
