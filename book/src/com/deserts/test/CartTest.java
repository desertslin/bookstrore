package com.deserts.test;

import com.deserts.bean.Cart;
import com.deserts.bean.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addItem() {
        CartItem item1 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item2 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item3 = new CartItem(2, "aaf", 1, new BigDecimal(100), new BigDecimal(100));
        Cart cart = new Cart();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        System.out.println(cart);
    }

    @Test
    void delete() {
        CartItem item1 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item2 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item3 = new CartItem(2, "aaf", 1, new BigDecimal(100), new BigDecimal(100));
        Cart cart = new Cart();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.delete(1);
        System.out.println(cart);
    }

    @Test
    void clear() {
        CartItem item1 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item2 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item3 = new CartItem(2, "aaf", 1, new BigDecimal(100), new BigDecimal(100));
        Cart cart = new Cart();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateCount() {
        CartItem item1 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item2 = new CartItem(1, "desde", 1, new BigDecimal(50), new BigDecimal(50));
        CartItem item3 = new CartItem(2, "aaf", 1, new BigDecimal(100), new BigDecimal(100));
        Cart cart = new Cart();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}