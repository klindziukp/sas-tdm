package com.klindziuk.sas.tdm.model.repository;

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
public class ProductLine {

  @Id
  @Column(name = "productLine")
  private String productLine;

  @Column(name = "textDescription")
  private String textDescription;

  @Column(name = "htmlDescription")
  private String htmlDescription;

  @Column(name = "image")
  private String image;
}
