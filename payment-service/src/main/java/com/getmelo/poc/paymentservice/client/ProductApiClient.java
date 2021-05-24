package com.getmelo.poc.paymentservice.client;

import com.getmelo.poc.paymentservice.client.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("product-service")
public interface ProductApiClient {

    @GetMapping( "/api/products")
    List<ProductDTO> findAll();

}
