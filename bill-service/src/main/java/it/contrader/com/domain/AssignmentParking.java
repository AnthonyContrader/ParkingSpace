package it.contrader.com.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A AssignmentParking.
 */
@Entity
@Table(name = "assignment_parking")
public class AssignmentParking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car")
    private Long car;

    @Column(name = "parkingplace")
    private Long parkingplace;

    @Column(name = "entry_date_time")
    private Instant entryDateTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar() {
        return car;
    }

    public AssignmentParking car(Long car) {
        this.car = car;
        return this;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Long getParkingplace() {
        return parkingplace;
    }

    public AssignmentParking parkingplace(Long parkingplace) {
        this.parkingplace = parkingplace;
        return this;
    }

    public void setParkingplace(Long parkingplace) {
        this.parkingplace = parkingplace;
    }

    public Instant getEntryDateTime() {
        return entryDateTime;
    }

    public AssignmentParking entryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public void setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
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
        AssignmentParking assignmentParking = (AssignmentParking) o;
        if (assignmentParking.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assignmentParking.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssignmentParking{" +
            "id=" + getId() +
            ", car=" + getCar() +
            ", parkingplace=" + getParkingplace() +
            ", entryDateTime='" + getEntryDateTime() + "'" +
            "}";
    }
}
