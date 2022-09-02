package com.klindziuk.sas.tdm.model.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "products")
@Data
@Accessors(chain = true)
public class Product  {

  @Id
  @Column(name = "productCode", unique = true, nullable = false)
  private String productCode;

  @Column(name = "productName")
  private String productName;

  @Column(name = "productScale")
  private String productScale;

  @Column(name = "productVendor")
  private String productVendor;

  @Column(name = "productDescription")
  private String productDescription;

  @Column(name = "quantityInStock")
  private Integer quantityInStock;

  @Column(name = "buyPrice")
  private Double buyPrice;

  @Column(name = "MSRP")
  private Double msrp;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false, insertable = false, updatable = false)
  @JsonProperty("productLine")
  private ProductLine productLine;
}
