package com.getmelo.poc.productservice.service;

import com.getmelo.poc.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO findById(Long id);
    List<ProductDTO> findAll();
    ProductDTO save(ProductDTO productDTO);
}
