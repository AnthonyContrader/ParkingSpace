package com.it.contrader.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the AssignmentB entity.
 */
public class AssignmentBDTO implements Serializable {

    private Long id;

    private Instant entryDateTime;

    private Long car;

    private Long parkplace;

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

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Long getParkplace() {
        return parkplace;
    }

    public void setParkplace(Long parkplace) {
        this.parkplace = parkplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssignmentBDTO assignmentBDTO = (AssignmentBDTO) o;
        if (assignmentBDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assignmentBDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssignmentBDTO{" +
            "id=" + getId() +
            ", entryDateTime='" + getEntryDateTime() + "'" +
            ", car=" + getCar() +
            ", parkplace=" + getParkplace() +
            "}";
    }
}
