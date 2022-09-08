package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLineItem, String> {

}
