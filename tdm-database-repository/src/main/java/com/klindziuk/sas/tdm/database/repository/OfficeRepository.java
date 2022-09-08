package com.klindziuk.sas.tdm.database.repository;

import com.klindziuk.sas.tdm.database.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {

}
