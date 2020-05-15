package it.contrader.com.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A DTO for the AssignmentParking entity.
 */
public class AssignmentParkingDTO implements Serializable {

    private Long id;
    
    private Long car;
    
    private Long parkingplace;

    private Instant entryDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Long getParkingplace() {
        return parkingplace;
    }

    public void setParkingplace(Long parkingplace) {
        this.parkingplace = parkingplace;
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssignmentParkingDTO assignmentParkingDTO = (AssignmentParkingDTO) o;
        if (assignmentParkingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assignmentParkingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssignmentParkingDTO{" +
            "id=" + getId() +
            ", car=" + getCar() +
            ", parkingplace=" + getParkingplace() +
            ", entryDateTime='" + getEntryDateTime() + "'" +
            "}";
    }
}
