package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail, String> {

}
