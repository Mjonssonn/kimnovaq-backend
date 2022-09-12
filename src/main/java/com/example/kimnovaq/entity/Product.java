package com.example.kimnovaq.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Arrays;


@Data
@Document(collection = "Product")
public class Product  {

    @Id
    private ObjectId id;

    @Field("type")
    private String type;

    @Field("name")
    private String name;

    @Field("color")
    private String color;

    @Field("size")
    private String size;

    @Field("price")
    private String price;

    @Field("image")
    private Binary image;

    public ProductDto convertToProductDto() {

        ProductDto productDto = new ProductDto();
        productDto.setId(new ObjectId().toHexString());
        productDto.setType(Arrays.asList(this.getType().split(", ")));
        productDto.setName(this.getName());
        productDto.setColor(Arrays.asList(this.getColor().split(", ")));
        productDto.setSize(Arrays.asList(this.getSize().split(", ")));
        productDto.setPrice(this.getPrice());
        productDto.setImage(this.getImage());

        return productDto;
    }
}
