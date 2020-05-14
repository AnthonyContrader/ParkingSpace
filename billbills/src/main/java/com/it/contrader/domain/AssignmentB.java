package com.it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A AssignmentB.
 */
@Entity
@Table(name = "assignment_b")
public class AssignmentB implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_date_time")
    private Instant entryDateTime;

    @Column(name = "car")
    private Long car;

    @Column(name = "parkplace")
    private Long parkplace;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public AssignmentB entryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public void setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Long getCar() {
        return car;
    }

    public AssignmentB car(Long car) {
        this.car = car;
        return this;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Long getParkplace() {
        return parkplace;
    }

    public AssignmentB parkplace(Long parkplace) {
        this.parkplace = parkplace;
        return this;
    }

    public void setParkplace(Long parkplace) {
        this.parkplace = parkplace;
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
        AssignmentB assignmentB = (AssignmentB) o;
        if (assignmentB.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assignmentB.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssignmentB{" +
            "id=" + getId() +
            ", entryDateTime='" + getEntryDateTime() + "'" +
            ", car=" + getCar() +
            ", parkplace=" + getParkplace() +
            "}";
    }
}
