package it.contrader.com.service.dto;

import java.io.Serializable;
import java.util.Objects;
import it.contrader.com.domain.enumeration.BillStatus;

/**
 * A DTO for the Bill entity.
 */
public class BillDTO implements Serializable {

    private Long id;

    private Double price;

    private BillStatus billStatus;

    private Long assignmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentParkingId) {
        this.assignmentId = assignmentParkingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BillDTO billDTO = (BillDTO) o;
        if (billDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), billDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BillDTO{" +
            "id=" + getId() +
            ", price=" + getPrice() +
            ", billStatus='" + getBillStatus() + "'" +
            ", assignment=" + getAssignmentId() +
            "}";
    }
}
