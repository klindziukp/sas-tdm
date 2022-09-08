package com.klindziuk.sas.tdm.database.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

  @Id
  @Column(name = "employeeNumber", unique = true, nullable = false, insertable = false, updatable = false)
  private Integer employeeNumber;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "extension")
  private String extension;

  @Column(name = "email")
  private String email;

  @Column(name = "officeCode")
  private String officeCode;

  @Column(name = "jobTitle")
  private String jobTitle;

  @ManyToOne
  @JoinColumn(name = "officeCode", nullable = false, insertable = false, updatable = false)
  @JsonProperty("office")
  private Office office;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber", insertable = false)
  private Employee reportsTo;

  @OneToMany(mappedBy = "reportsTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Setter
  private Set<Employee> subordinates = new HashSet<>();

  @JsonIgnore
  public Set<Employee> getSubordinates() {
    return subordinates;
  }
}
