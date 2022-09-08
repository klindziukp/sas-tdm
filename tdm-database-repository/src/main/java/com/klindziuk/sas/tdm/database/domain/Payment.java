package com.klindziuk.sas.tdm.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "payments")
@Data
@Accessors(chain = true)
public class Payment {

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customerNumber", nullable = false, insertable = false, updatable = false)
  @JsonBackReference
  private Customer customer;

  @Id
  @Column(name = "customerNumber", unique = true, nullable = false)
  private Integer customerNumber;

  @Column(name = "checkNumber")
  private String checkNumber;

  @Column(name = "paymentDate")
  private Date paymentDate;

  @Column(name = "amount")
  private Double amount;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Payment payment = (Payment) o;

    if (customerNumber != null ? !customerNumber.equals(payment.customerNumber)
        : payment.customerNumber != null) {
      return false;
    }
    if (checkNumber != null ? !checkNumber.equals(payment.checkNumber)
        : payment.checkNumber != null) {
      return false;
    }
    if (paymentDate != null ? !paymentDate.equals(payment.paymentDate)
        : payment.paymentDate != null) {
      return false;
    }
    return amount != null ? amount.equals(payment.amount) : payment.amount == null;
  }

  @Override
  public int hashCode() {
    int result = customerNumber != null ? customerNumber.hashCode() : 0;
    result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
    result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    return result;
  }
}


