package com.getmelo.poc.paymentservice.controller;

import com.getmelo.poc.paymentservice.client.ProductApiClient;
import com.getmelo.poc.paymentservice.client.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/payments")
@Validated
@Tag(name = "Payment Api", description = "Provides APIs related to Payments")
public class PaymentServiceController {

    @Autowired
    private ProductApiClient productApiClient;

    @GetMapping("/products")
    @Operation(summary = "Get Products for Payment", description="Get All Products from product-service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved Products", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)) }),
            @ApiResponse (responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
            @ApiResponse (responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse (responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content)
    })
    public Collection<ProductDTO> findAllProducts() {
        return productApiClient.findAll();
    }
}
