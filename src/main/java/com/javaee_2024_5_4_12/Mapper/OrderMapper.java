package com.javaee_2024_5_4_12.Mapper;

import com.javaee_2024_5_4_12.entity.CartProductInfo;
import com.javaee_2024_5_4_12.entity.ProductInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    @Insert("insert into order_detail_info (order_id,product_id,sell_price,final_price,product_count,user_id) " +
            "values (#{orderId},#{productId},#{sellPrice},#{finalPrice},#{productCount},#{userId})")
    void addOrder(@Param("orderId") int orderId,
                  @Param("productId") int productId,
                  @Param("sellPrice") double sellPrice,
                  @Param("finalPrice") double finalPrice,
                  @Param("productCount") int productCount,
                  @Param("userId") int userId);

    @Insert("INSERT INTO order_product_detail_info (product_stock_id, order_detail_id) " +
            "VALUES (#{productStockId}, #{orderDetailId})")
    void addOrderDetail(@Param("productStockId") int productStockId, @Param("orderDetailId") int orderDetailId);
}
