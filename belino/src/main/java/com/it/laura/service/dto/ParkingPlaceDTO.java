package com.it.laura.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ParkingPlace entity.
 */
public class ParkingPlaceDTO implements Serializable {

    private Long id;

    private Integer numberPlace;

    private Long floorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(Integer numberPlace) {
        this.numberPlace = numberPlace;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParkingPlaceDTO parkingPlaceDTO = (ParkingPlaceDTO) o;
        if (parkingPlaceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), parkingPlaceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ParkingPlaceDTO{" +
            "id=" + getId() +
            ", numberPlace=" + getNumberPlace() +
            ", floor=" + getFloorId() +
            "}";
    }
}
