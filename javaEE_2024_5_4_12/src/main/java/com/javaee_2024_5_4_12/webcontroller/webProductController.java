package com.javaee_2024_5_4_12.webcontroller;

import com.javaee_2024_5_4_12.Service.ProductService;
import com.javaee_2024_5_4_12.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class webProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/show_product_list")
    public String showProductList(@RequestParam(value = "productName", required = false) String productName, Model model) {
        List<ProductInfo> productList = productService.getProductList(productName);
        System.out.println("Product list size from backend: " + productList.size());

        model.addAttribute("product_list", productList);
        return "product_list";
    }

    @RequestMapping("/show_product_detail")
    public String showProductDetail(@RequestParam("product_id") int productId, @RequestParam("store_id") int storeId, Model model) {
        ProductInfo product = productService.getAProduct(productId, storeId);
        System.out.println("Product detail from backend: " + product);

        model.addAttribute("product", product);
        return "product_detail";
    }
}
