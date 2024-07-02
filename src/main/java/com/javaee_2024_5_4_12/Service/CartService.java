package com.javaee_2024_5_4_12.Service;

import com.javaee_2024_5_4_12.Mapper.CartMapper;
import com.javaee_2024_5_4_12.Mapper.OrderMapper;
import com.javaee_2024_5_4_12.Mapper.ProductMapper;
import com.javaee_2024_5_4_12.entity.CartProductInfo;
import com.javaee_2024_5_4_12.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    public void addToCart(int productId, int storeId, int userId) {
        cartMapper.addToCart(productId, storeId, userId);
    }

    public List<CartProductInfo> getCartItems(int userId) {
        return cartMapper.getCartItems(userId);
    }

    public void checkout(int userId) {
        List<CartProductInfo> cartProducts = cartMapper.getCartProducts(userId);
        int orderId = generateOrderId();
//        cartProducts.forEach(product -> orderMapper.addOrder(
//                orderId, productId, p_price,
//                finalPrice, productCount, userId));
        for (CartProductInfo cartProduct : cartProducts) {
            int productId1 = cartProduct.getProduct_id();
            ProductInfo productInfoById = productMapper.getProductInfoById(productId1);
            double pPrice = productInfoById.getP_price();
            int productCount1 = cartProduct.getProduct_count();
            double sumPrcie=pPrice*productCount1;
            orderMapper.addOrder(generateOrderId(),cartProduct.getProduct_id(),productInfoById.getP_price(),sumPrcie,cartProduct.getProduct_count(),userId);
        }
        cartMapper.clearCart(userId);
    }

    private int generateOrderId() {
        // 生成订单ID的逻辑
        return new Random().nextInt(10000); // 示例代码，请使用实际生成ID的逻辑
    }

    public void removeProductFromCart(int cart_product_id) {
        cartMapper.removeProductFromCart(cart_product_id);
    }

    public void updateProductCount(int cartProductId, int count) {
        cartMapper.updateCartCount(cartProductId, count);
    }
}
