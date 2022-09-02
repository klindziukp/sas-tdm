package com.klindziuk.sas.tdm.layer.controller;

import com.klindziuk.sas.tdm.layer.repository.OfficeRepository;
import com.klindziuk.sas.tdm.model.repository.Office;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeController {

  private final OfficeRepository officeRepository;

  @Autowired
  public OfficeController(OfficeRepository officeRepository) {
    this.officeRepository = officeRepository;
  }

  @GetMapping(value = "api/v1/offices", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Office>> offices() {
    return ResponseEntity.ok(officeRepository.findAll());
  }
}
