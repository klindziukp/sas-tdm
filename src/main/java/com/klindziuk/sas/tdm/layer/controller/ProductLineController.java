package com.klindziuk.sas.tdm.layer.controller;

import com.klindziuk.sas.tdm.layer.repository.ProductLineRepository;
import com.klindziuk.sas.tdm.model.repository.ProductLine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductLineController {

  private final ProductLineRepository productLineRepository;

  @Autowired
  public ProductLineController(ProductLineRepository productLineRepository) {
    this.productLineRepository = productLineRepository;
  }

  @GetMapping(value = "api/v1/product-lines", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ProductLine>> productLines() {
    return ResponseEntity.ok(productLineRepository.findAll());
  }
}
