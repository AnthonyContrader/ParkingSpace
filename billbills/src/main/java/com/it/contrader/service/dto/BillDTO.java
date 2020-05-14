package com.it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;
import com.it.contrader.domain.enumeration.Billstatus;

/**
 * A DTO for the Bill entity.
 */
public class BillDTO implements Serializable {

    private Long id;

    private Double prezzo;

    private Billstatus status;

    private Long assignmentbId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Billstatus getStatus() {
        return status;
    }

    public void setStatus(Billstatus status) {
        this.status = status;
    }

    public Long getAssignmentbId() {
        return assignmentbId;
    }

    public void setAssignmentbId(Long assignmentBId) {
        this.assignmentbId = assignmentBId;
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
            ", prezzo=" + getPrezzo() +
            ", status='" + getStatus() + "'" +
            ", assignmentb=" + getAssignmentbId() +
            "}";
    }
}
