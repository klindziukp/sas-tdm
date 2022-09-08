package com.klindziuk.sas.tdm.gen.controller;

import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.database.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping(value = "api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> products() {
    return ResponseEntity.ok(productRepository.findAll());
  }
}
