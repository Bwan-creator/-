package com.javaee_2024_5_4_12.entity;

public class CartProductInfo {
    private int cart_product_id;
    private int product_id;
    private int store_id;
    private int product_count;
    private int cart_product_status;
    private int user_id;
    private String product_name;
    private double p_price;
    private double final_price;
    private int order_detail_id;
    private String store_name;

    public int getCart_product_id() {
        return cart_product_id;
    }

    public void setCart_product_id(int cart_product_id) {
        this.cart_product_id = cart_product_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getCart_product_status() {
        return cart_product_status;
    }

    public void setCart_product_status(int cart_product_status) {
        this.cart_product_status = cart_product_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }

    public double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(double final_price) {
        this.final_price = final_price;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    @Override
    public String toString() {
        return "CartProductInfo{" +
                "cart_product_id=" + cart_product_id +
                ", product_id=" + product_id +
                ", store_id=" + store_id +
                ", product_count=" + product_count +
                ", cart_product_status=" + cart_product_status +
                ", user_id=" + user_id +
                ", product_name='" + product_name + '\'' +
                ", p_price=" + p_price +
                ", final_price=" + final_price +
                ", order_detail_id=" + order_detail_id +
                ", store_name='" + store_name + '\'' +
                '}';
    }
}
