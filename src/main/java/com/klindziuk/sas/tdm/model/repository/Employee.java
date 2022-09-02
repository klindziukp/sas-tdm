package com.klindziuk.sas.tdm.model.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employeeNumber", unique = true, nullable = false)
  private Long employeeNumber;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "extension")
  private String extension;

  @Column(name = "email")
  private String email;

  @Column(name = "officeCode")
  private Long officeCode;

  @Column(name = "jobTitle")
  private String jobTitle;

  @ManyToOne
  @JoinColumn(name="officeCode", nullable = false, insertable = false, updatable = false)
  @JsonProperty("office")
  private Office office;

  @OneToOne
  @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber", insertable = false, updatable = false)
  private Employee reportsTo;
}
