package it.contrader.com.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A DTO for the AssigmentParking entity.
 */

public class AssigmentParkingDTO implements Serializable {

	private Long id;
	
	@JsonProperty("car")
    private Long car;
	
	@JsonProperty("parkingplace")
    private Long parkingplace;

    private Instant entryDateTime;

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
        return car;
    }

    public void setCarId(Long carId) {
        this.car = carId;
    }

    public Long getParkingplaceId() {
        return parkingplace;
    }

    public void setParkingplaceId(Long parkingPlaceId) {
        this.parkingplace = parkingPlaceId;
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
