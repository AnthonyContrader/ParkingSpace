package com.it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A AssigmentParking.
 */
@Entity
@Table(name = "assigment_parking")
public class AssigmentParking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_date_time")
    private Instant entryDateTime;

    @OneToOne
    @JoinColumn(unique = true)
    private Car car;

    @OneToOne
    @JoinColumn(unique = true)
    private ParkingPlace parkingplace;

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

    public AssigmentParking entryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    public void setEntryDateTime(Instant entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Car getCar() {
        return car;
    }

    public AssigmentParking car(Car car) {
        this.car = car;
        return this;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingPlace getParkingplace() {
        return parkingplace;
    }

    public AssigmentParking parkingplace(ParkingPlace parkingPlace) {
        this.parkingplace = parkingPlace;
        return this;
    }

    public void setParkingplace(ParkingPlace parkingPlace) {
        this.parkingplace = parkingPlace;
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
        AssigmentParking assigmentParking = (AssigmentParking) o;
        if (assigmentParking.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assigmentParking.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssigmentParking{" +
            "id=" + getId() +
            ", entryDateTime='" + getEntryDateTime() + "'" +
            "}";
    }
}
