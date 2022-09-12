package com.example.kimnovaq.service;

import com.example.kimnovaq.entity.Product;
import com.example.kimnovaq.entity.ProductDto;
import com.example.kimnovaq.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<ProductDto> fetchAllProducts() {

        List<Product> productList = productRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();

        for(Product productBucket: productList) {
            ProductDto newTempProduct = productBucket.convertToProductDto();
            productDtoList.add(newTempProduct);
        }

        return productDtoList;
    }


    @Override
    public ProductDto createNewProduct(ProductDto newProductDto) {

        Product product = newProductDto.convertToProduct();

        Product saveProduct = productRepository.save(product);

        ProductDto savedProductDto = saveProduct.convertToProductDto();

        return savedProductDto;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

        ObjectId objId = new ObjectId(id);

        productRepository.deleteById(objId);
    }


}

