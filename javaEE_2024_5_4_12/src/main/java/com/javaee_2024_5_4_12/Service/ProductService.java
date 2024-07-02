package com.javaee_2024_5_4_12.Service;

import com.javaee_2024_5_4_12.Mapper.ProductMapper;
import com.javaee_2024_5_4_12.entity.ProductInfo;
import com.javaee_2024_5_4_12.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public List<ProductInfo> getProductList(String productName){
        return productMapper.getProductList(productName);
    }
    public ProductInfo getAProduct(int product_id,int store_id){
        return productMapper.getAProduct(product_id,store_id);
    }


}
