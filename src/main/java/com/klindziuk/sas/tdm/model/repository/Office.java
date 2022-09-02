package com.klindziuk.sas.tdm.model.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "offices")
@Data
@Accessors(chain = true)
public class Office {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "officeCode", unique = true, nullable = false)
  private Long officeCode;

  @Column(name = "city")
  private String city;

  @Column(name = "phone")
  private String phone;

  @Column(name = "addressLine1")
  private String addressLine1;

  @Column(name = "addressLine2")
  private String addressLine2;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "postalCode")
  private String postalCode;

  @Column(name = "territory")
  private String territory;
}
