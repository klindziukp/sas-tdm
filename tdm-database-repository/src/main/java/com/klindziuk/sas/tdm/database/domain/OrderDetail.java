package com.klindziuk.sas.tdm.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "orderdetails")
@Data
@Accessors(chain = true)
public class OrderDetail {

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "orderNumber", nullable = false, insertable = false, updatable = false)
  @JsonBackReference
  private Order order;

  @Id
  @Column(name = "orderNumber")
  private Integer orderNumber;

  @Column(name = "productCode")
  private String productCode;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "productCode", nullable = false, insertable = false, updatable = false)
  @JsonBackReference
  private Product product;

  @Column(name = "quantityOrdered")
  private Integer quantityOrdered;

  @Column(name = "priceEach")
  private Double priceEach;

  @Column(name = "orderLineNumber")
  private Integer orderLineNumber;
}
