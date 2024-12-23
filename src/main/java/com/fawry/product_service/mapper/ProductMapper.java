package com.fawry.product_service.mapper;

import com.fawry.product_service.entity.Product;
import com.fawry.product_service.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper (componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mapping(source = "product.category", target = "categoryModel")
    ProductModel mapEntityToModel(Product product);

    List<ProductModel> mapEntitiesToModels(List<Product> products);

    @Mapping(target = "category", source = "productModel.categoryModel")
    Product mapModelToEntity(ProductModel productModel);

    @Mapping(target = "id", source = "id", ignore = true)
    @Mapping(target = "product.category", source = "productModel.categoryModel")
    void updateModelToEntity(ProductModel productModel, @MappingTarget Product product);

}
