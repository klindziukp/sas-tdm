package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
