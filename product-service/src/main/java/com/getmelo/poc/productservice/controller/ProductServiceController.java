package com.getmelo.poc.productservice.controller;

import com.getmelo.poc.productservice.dto.ProductDTO;
import com.getmelo.poc.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
@Tag(name = "Product Api", description = "Provides APIs related to Products")
public class ProductServiceController {

    @Autowired private ProductService service;

    @GetMapping( "/{id}")
    @Operation(summary = "Get Product By Id", description="Get Product By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved Product", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)) }),
            @ApiResponse (responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
            @ApiResponse (responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse (responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content)
    })
    public ResponseEntity<ProductDTO> getById(@PathVariable("id") Long id) {
        ProductDTO productDTO = service.findById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> products = service.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO emp) {
        ProductDTO productDTO = service.save(emp);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }


}
