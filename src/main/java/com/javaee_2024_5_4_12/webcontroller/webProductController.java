package com.javaee_2024_5_4_12.webcontroller;

import com.javaee_2024_5_4_12.Service.CartService;
import com.javaee_2024_5_4_12.Service.ProductService;
import com.javaee_2024_5_4_12.entity.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class webProductController {

    @Autowired
    private ProductService proService;

    @Autowired
    private CartService cartService;

    @RequestMapping("show_product_list")
    public String getProductList(HttpServletRequest request, Model model) {
        String qry_field = request.getParameter("qry_field");
        String qry_condition = request.getParameter("qry_condition");
        String currentPageParam = request.getParameter("current_page");
        String user_id = request.getParameter("user_id");
        int current_page = 1; // 默认值
        if (currentPageParam != null && !currentPageParam.isEmpty()) {
            current_page = Integer.parseInt(currentPageParam);
        }
        String pageSizeParam = request.getParameter("page_size");
        int page_size = 10; // 默认值
        if (pageSizeParam != null && !pageSizeParam.isEmpty()) {
            page_size = Integer.parseInt(pageSizeParam);
        }
        System.out.println("来自前端userId的数据：" + user_id);
        System.out.println("来自前端的数据：" + qry_field + "------" + qry_condition + "------" + current_page + "-------" + page_size );
        List<ProductInfo> proList =new ArrayList<ProductInfo>();

        proList =  proService.getProductList(qry_field,qry_condition,current_page,page_size,user_id);
        System.out.println("来自后端productname的数据：" + proList.size());

        model.addAttribute("user_id",user_id);
        model.addAttribute("qry_field",qry_field);
        model.addAttribute("qry_condition",qry_condition);
        model.addAttribute("current_page",1);
        model.addAttribute("page_size",10);

        model.addAttribute("pro_List",proList);
        return "product_list";
    }

    @RequestMapping("/add_to_cart")
    public String addToCart(@RequestParam("product_id") int productId, @RequestParam("store_id") int storeId, @RequestParam("user_id") int userId, RedirectAttributes attr) {
        cartService.addToCart(productId, storeId, userId);
        System.out.println("来自后端addCart:productId,storeId,userId的数据：" + productId + "------" + storeId + "------" + userId);
        attr.addAttribute("college_id",1);
        attr.addAttribute("current_page",1);
        attr.addAttribute("page_size",10);
        attr.addAttribute("qry_field", "pi.product_name");
        attr.addAttribute("qry_condition", "");
        return "redirect:/show_product_list?user_id=" + userId;
    }

    @RequestMapping("/show_cart")
    public String showCart(@RequestParam(value = "user_id", defaultValue = "209050501") int userId, Model model) {
        List<CartProductInfo> cartItems = cartService.getCartItems(userId);
        System.out.println("来自后端userId的数据：" + userId);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("userId", userId);
        return "cart";
    }

    @RequestMapping("/cart_delete")
    public String deleteFromCart(@RequestParam("cart_product_id") int cart_product_id,
                                 @RequestParam("user_id") int userId) {
        cartService.removeProductFromCart(cart_product_id);
        System.out.println("来自后端cart_product_id的数据：" + cart_product_id);
        return "redirect:/show_cart?user_id=" + userId;
    }

    @RequestMapping("/update_cart")
    public String updateCart(@RequestParam("cart_product_id") int cartProductId,
                             @RequestParam("product_count") int productCount,
                             @RequestParam("user_id") int userId) {
        cartService.updateProductCount(cartProductId, productCount);
        return "redirect:/show_cart?user_id=" + userId;
    }

    @RequestMapping("/checkout")
    public String checkout(@RequestParam("user_id") int userId) {
        cartService.checkout(userId);
        return "redirect:/show_cart?user_id=" + userId;
    }
}
