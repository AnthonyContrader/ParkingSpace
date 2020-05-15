package it.contrader.com.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import it.contrader.com.domain.enumeration.BillStatus;

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

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "bill_status")
    private BillStatus billStatus;

    @OneToOne
    @JoinColumn(unique = true)
    private AssignmentParking assignment;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public Bill price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public Bill billStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
        return this;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public AssignmentParking getAssignment() {
        return assignment;
    }

    public Bill assignment(AssignmentParking assignmentParking) {
        this.assignment = assignmentParking;
        return this;
    }

    public void setAssignment(AssignmentParking assignmentParking) {
        this.assignment = assignmentParking;
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
            ", price=" + getPrice() +
            ", billStatus='" + getBillStatus() + "'" +
            "}";
    }
}
