package com.klindziuk.sas.tdm.model.repository;

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
  private Long customerNumber;

  @Column(name = "checkNumber")
  private String checkNumber;

  @Column(name = "paymentDate")
  private Date paymentDate;

  @Column(name = "amount")
  private Double amount;
}
