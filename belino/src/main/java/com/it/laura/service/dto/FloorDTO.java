package com.it.laura.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Floor entity.
 */
public class FloorDTO implements Serializable {

    private Long id;

    private Integer numberFloor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FloorDTO floorDTO = (FloorDTO) o;
        if (floorDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), floorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FloorDTO{" +
            "id=" + getId() +
            ", numberFloor=" + getNumberFloor() +
            "}";
    }
}
