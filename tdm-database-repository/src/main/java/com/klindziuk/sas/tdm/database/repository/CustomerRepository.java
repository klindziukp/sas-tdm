package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
