package com.getmelo.poc.productservice.repository;

import com.getmelo.poc.productservice.domain.Product;
import com.getmelo.poc.productservice.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<ProductDTO> findByName(String name);
}
