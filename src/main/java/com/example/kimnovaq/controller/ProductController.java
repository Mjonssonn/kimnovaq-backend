package com.example.kimnovaq.controller;

import com.example.kimnovaq.entity.Product;
import com.example.kimnovaq.entity.ProductDto;
import com.example.kimnovaq.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value ="/")
    public ResponseEntity<List> fetchAllProducts() {
        List<ProductDto> productDtoList = productService.fetchAllProducts();

        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @PostMapping(value ="/add", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDto> createNewProduct(@RequestBody ProductDto newProductDto) {

        productService.createNewProduct(newProductDto);

        return new ResponseEntity<>(newProductDto, HttpStatus.OK);
    }

    @PostMapping(value ="/add", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto newProductDto) {

        productService.updateProduct(newProductDto);

        return new ResponseEntity<>(newProductDto, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") String productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
