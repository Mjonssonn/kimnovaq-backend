package com.example.kimnovaq.service;

import com.example.kimnovaq.entity.Product;
import com.example.kimnovaq.entity.ProductDto;
import com.example.kimnovaq.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {


    List<ProductDto> fetchAllProducts();

    ProductDto createNewProduct(ProductDto product);

    ProductDto updateProduct(ProductDto product);

    void deleteProduct(String id);
}
