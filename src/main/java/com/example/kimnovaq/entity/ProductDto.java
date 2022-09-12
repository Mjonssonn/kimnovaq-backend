package com.example.kimnovaq.entity;

import lombok.Data;
import org.apache.tomcat.util.buf.StringUtils;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class ProductDto {

    private String id;
    private List<String> type;
    private String name;
    private List<String> color;
    private List<String> size;
    private String price;
    private Binary image;

    public Product convertToProduct() {

        Product product = new Product();

        if(this.getId() != null) {
            product.setId(new ObjectId(this.getId()));
        }

        product.setType(StringUtils.join(this.getType(), ','));
        product.setName(this.getName());
        product.setColor(StringUtils.join(this.getColor(), ','));
        product.setSize(StringUtils.join(this.getSize(), ','));
        product.setPrice(this.getPrice());
        product.setImage(this.getImage());

        return product;
    }
}
