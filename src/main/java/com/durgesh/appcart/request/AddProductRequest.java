package com.durgesh.appcart.request;

import java.math.BigDecimal;

import com.durgesh.appcart.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    private Long id;

    private String name;

    private String brand;
    
    private BigDecimal price;
    
    private int inventory;
    
    private String description;

    private Category category;
}
