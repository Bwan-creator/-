package com.javaee_2024_5_4_12.Mapper;


import com.javaee_2024_5_4_12.entity.CartProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {

    @Select("SELECT * FROM cart_product_info WHERE user_id = #{userId}")
    List<CartProductInfo> getCartProducts(int userId);
    @Insert("INSERT INTO cart_product_info (product_id, store_id, product_count, cart_product_status, user_id) " +
            "VALUES (#{product_id}, #{store_id}, 1, 1, #{user_id}) " +
            "ON DUPLICATE KEY UPDATE product_count = product_count + 1")
    void addToCart(@Param("product_id") int productId, @Param("store_id") int storeId, @Param("user_id") int userId);


    @Select("SELECT cpi.*, pi.product_name, pi.p_price FROM cart_product_info " +
            "cpi JOIN product_info pi ON cpi.product_id = pi.product_id WHERE cpi.user_id = " +
            "#{user_id} AND cpi.cart_product_status = 1")
    List<CartProductInfo> getCartItems(@Param("user_id") int userId);

    @Delete("DELETE FROM cart_product_info WHERE cart_product_id = #{cartProductId}")
    void removeProductFromCart(int cartProductId);

    @Update("UPDATE cart_product_info SET product_count = #{count} WHERE cart_product_id = #{cartProductId}")
    void updateCartCount(@Param("cartProductId") int cartProductId, @Param("count") int count);

    @Delete("DELETE FROM cart_product_info WHERE user_id = #{userId}")
    void clearCart(@Param("userId") int userId);

    @Delete("DELETE FROM cart_product_info where cart_product_id=#{cart_product_id}")
    int deleteACart(@Param("cart_product_id") String cart_product_id);



}
