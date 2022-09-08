package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
