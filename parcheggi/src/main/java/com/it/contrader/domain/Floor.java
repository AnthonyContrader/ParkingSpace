package com.it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Floor.
 */
@Entity
@Table(name = "floor")
public class Floor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_floor")
    private Integer numberFloor;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public Floor numberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
        return this;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
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
        Floor floor = (Floor) o;
        if (floor.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), floor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Floor{" +
            "id=" + getId() +
            ", numberFloor=" + getNumberFloor() +
            "}";
    }
}
