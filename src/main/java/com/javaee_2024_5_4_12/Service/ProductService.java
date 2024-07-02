package com.javaee_2024_5_4_12.Service;

import com.javaee_2024_5_4_12.Mapper.ProductMapper;
import com.javaee_2024_5_4_12.entity.ClassInfo;
import com.javaee_2024_5_4_12.entity.ProductInfo;
import com.javaee_2024_5_4_12.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductInfo> getProductList(String qry_field, String qry_condition, int current_page, int page_size,String user_id) {
        int pos = (current_page - 1) * page_size;
        String whereCondition =  "where 1=1";
        whereCondition += "   and " + qry_field + " like '%" + qry_condition + "%'"  +
                " GROUP BY psi.store_id,pi.product_id,pvi.url_path"
                + "    limit   " + pos + "," +page_size;
        System.out.println("查询where:"  + whereCondition);

        return productMapper.getProductListWithCondition(whereCondition);
    }

}

