package com.javaee_2024_5_4_12.Mapper;

import com.javaee_2024_5_4_12.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    @Select("SELECT pi.*,psi.store_id,si.store_name,pvi.url_path\n" +
            "\tFROM product_info pi INNER JOIN product_stock_info psi\n" +
            "\t\tON pi.product_id=psi.product_id and psi.product_stock_status= 1\n" +
            "\t\tINNER JOIN store_info si ON si.store_id=psi.store_id\n" +
            "\t\tand si.store_status=1\n" +
            "\t\tINNER JOIN photo_video_info pvi\n" +
            "\t\tON pvi.product_id=psi.product_id and pvi.main_url=1\n" +
            "\t\tWHERE pi.product_name LIKE '%${product_name}%'\n" +
            "\t\tGROUP BY psi.store_id,pi.product_id,pvi.url_path")
    List<ProductInfo> getProductList(@Param("product_name")String product_name);

    @Select("SELECT pi.*,psi.store_id,si.store_name,pvi.url_path\n" +
            "\tFROM product_info pi INNER JOIN product_stock_info psi\n" +
            "\t\tON pi.product_id=psi.product_id and psi.product_stock_status= 1\n" +
            "\t\tINNER JOIN store_info si ON si.store_id=psi.store_id\n" +
            "\t\tand si.store_status=1\n" +
            "\t\tINNER JOIN photo_video_info pvi\n" +
            "\t\tON pvi.product_id=psi.product_id and pvi.main_url=1\n" +
            "\t\tWHERE pi.product_id=1 AND psi.store_id=1\n" +
            "\t\tGROUP BY psi.store_id,pi.product_id,pvi.url_path")
    ProductInfo getAProduct(@Param("product_id") int product_id,
                            @Param("store_id") int store_id);

}
