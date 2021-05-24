package com.getmelo.poc.productservice.service.impl;

import com.getmelo.poc.productservice.constant.ErrorConstant;
import com.getmelo.poc.productservice.dto.ProductDTO;
import com.getmelo.poc.productservice.exception.ResourceNotFoundException;
import com.getmelo.poc.productservice.mapper.ProductMapper;
import com.getmelo.poc.productservice.repository.ProductRepository;
import com.getmelo.poc.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired private ProductRepository productRepository;
    private ProductMapper productMapper = ProductMapper.getInstance();

    @Override
    @Transactional(readOnly=true)
    public ProductDTO findById(Long id) {
        return productRepository.findById(id).map(productMapper::entityToDTO)
                .orElseThrow(()->new ResourceNotFoundException(ErrorConstant.MESSAGE_RESOURCE_NOT_FOUND,ErrorConstant.KEY_RESOURCE_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly=true)
    public List<ProductDTO> findAll() {
        return Optional.ofNullable(productRepository.findAll()).orElse(Collections.emptyList())
                .stream()
                .map(productMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDTO save(@NotNull ProductDTO productDTO) {
        if(productRepository.findByName(productDTO.getName()).isPresent()){
            throw new ResourceNotFoundException(ErrorConstant.MESSAGE_RESOURCE_ALREADY_EXISTS,ErrorConstant.KEY_RESOURCE_ALREADY_EXISTS);
        }
        return Optional.of(productDTO)
                .map(productMapper::dtoToEntity)
                .map(productRepository::save)
                .map(productMapper::entityToDTO)
                .orElse(null);
    }

}
