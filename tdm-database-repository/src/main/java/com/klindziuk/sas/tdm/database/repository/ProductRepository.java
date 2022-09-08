package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
