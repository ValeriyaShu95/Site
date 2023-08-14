package org.mySite.all.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "bill")



public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)



    private Long billId;
    private float amount;

    public Bill() {
    }

    public Bill(Long billId, float amount) {
        this.billId = billId;
        this.amount = amount;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
