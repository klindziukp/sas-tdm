package com.klindziuk.sas.tdm.database.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "productlines")
@Data
@Accessors(chain = true)
public class ProductLineItem {

  @Id
  @Column(name = "productLine", nullable = false)
  private String productLine;

  @Column(name = "textDescription")
  private String textDescription;

  @Column(name = "htmlDescription")
  private String htmlDescription;

  @Column(name = "image")
  private String image;
}
