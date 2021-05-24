package com.getmelo.poc.productservice.mapper;

import com.getmelo.poc.productservice.domain.Product;
import com.getmelo.poc.productservice.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

	static ProductMapper getInstance() {
        return ProductInstance.INSTANCE;
    }

	final class ProductInstance {
        private static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
        private ProductInstance() { }
    }
	
	ProductDTO entityToDTO(Product entity);

	Product dtoToEntity(ProductDTO dto);

	void dtoToEntity(ProductDTO dto, @MappingTarget Product entity);
}
