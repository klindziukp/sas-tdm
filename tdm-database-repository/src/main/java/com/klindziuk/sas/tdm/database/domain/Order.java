package com.klindziuk.sas.tdm.database.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "orders")
@Data
@Accessors(chain = true)
public class Order {

  @Id
  @Column(name = "orderNumber", unique = true, nullable = false)
  private Integer orderNumber;

  @Column(name = "orderDate")
  private Date orderDate;

  @Column(name = "requiredDate")
  private Date requiredDate;

  @Column(name = "shippedDate")
  private Date shippedDate;

  @Column(name = "status")
  private String status;

  @Column(name = "comments")
  private String comments;

  @JsonIgnore
  @Column(name = "customerNumber")
  private Integer customerNumber;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "customerNumber", nullable = false, insertable = false, updatable = false)
  @JsonProperty("customer")
  private Customer customer;

  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
  @JsonProperty("orderDetails")
  private List<OrderDetail> orderDetails = Collections.emptyList();
}
