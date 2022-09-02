package com.klindziuk.sas.tdm.layer.controller;

import com.klindziuk.sas.tdm.layer.repository.ProductRepository;
import com.klindziuk.sas.tdm.model.repository.Product;
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
