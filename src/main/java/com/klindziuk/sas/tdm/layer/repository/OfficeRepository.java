package com.klindziuk.sas.tdm.layer.repository;

import com.klindziuk.sas.tdm.model.repository.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
