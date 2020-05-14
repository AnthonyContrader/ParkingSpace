package com.it.contrader.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the AssigmentParking entity.
 */
public class AssigmentParkingDTO implements Serializable {

    private Long id;

    private Instant entryDateTime;

    private Long carId;

    private Long parkingplaceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getParkingplaceId() {
        return parkingplaceId;
    }

    public void setParkingplaceId(Long parkingPlaceId) {
        this.parkingplaceId = parkingPlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssigmentParkingDTO assigmentParkingDTO = (AssigmentParkingDTO) o;
        if (assigmentParkingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assigmentParkingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssigmentParkingDTO{" +
            "id=" + getId() +
            ", entryDateTime='" + getEntryDateTime() + "'" +
            ", car=" + getCarId() +
            ", parkingplace=" + getParkingplaceId() +
            "}";
    }
}
