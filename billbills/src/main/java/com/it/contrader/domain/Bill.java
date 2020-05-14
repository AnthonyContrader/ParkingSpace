package com.it.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import com.it.contrader.domain.enumeration.Billstatus;

/**
 * A Bill.
 */
@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prezzo")
    private Double prezzo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Billstatus status;

    @OneToOne
    @JoinColumn(unique = true)
    private AssignmentB assignmentb;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public Bill prezzo(Double prezzo) {
        this.prezzo = prezzo;
        return this;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Billstatus getStatus() {
        return status;
    }

    public Bill status(Billstatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(Billstatus status) {
        this.status = status;
    }

    public AssignmentB getAssignmentb() {
        return assignmentb;
    }

    public Bill assignmentb(AssignmentB assignmentB) {
        this.assignmentb = assignmentB;
        return this;
    }

    public void setAssignmentb(AssignmentB assignmentB) {
        this.assignmentb = assignmentB;
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
        Bill bill = (Bill) o;
        if (bill.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Bill{" +
            "id=" + getId() +
            ", prezzo=" + getPrezzo() +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
