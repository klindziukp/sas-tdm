package com.klindziuk.sas.tdm.model.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "customers")
@Data
@Accessors(chain = true)
public class Customer implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customerNumber", unique = true, nullable = false)
  private Long customerNumber;

  @Column(name = "customerName")
  private String customerName;

  @Column(name = "contactLastName")
  private String contactLastName;

  @Column(name = "contactFirstName")
  private String contactFirstName;

  @Column(name = "phone")
  private String phone;

  @Column(name = "addressLine1")
  private String addressLine1;

  @Column(name = "addressLine2")
  private String addressLine2;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "postalCode")
  private String postalCode;

  @Column(name = "country")
  private String country;

  @Column(name = "salesRepEmployeeNumber")
  private Long salesRepEmployeeNumber;

  @Column(name = "creditLimit")
  private Double creditLimit;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
  @Fetch(value = FetchMode.SUBSELECT)
  @JsonProperty("payments")
  private List<Payment> payments = Collections.emptyList();

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber", nullable = false, insertable = false, updatable = false)
  @JsonProperty("salesEmployee")
  private Employee salesEmployee;
}
