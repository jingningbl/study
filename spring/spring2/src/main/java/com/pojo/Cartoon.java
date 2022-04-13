package com.pojo;


/**
 * @author bai
 * @version V1.0
 * @Package com.pojo
 * @date 2022/2/14 9:09
 * @describe
 */
public class Cartoon {
    private String cartoonName;

    public String getCartoonName() {
        return cartoonName;
    }

    public void setCartoonName(String cartoonName) {
        this.cartoonName = cartoonName;
    }

    @Override
    public String toString() {
        return "Cartoon{" +
                "cartoonName='" + cartoonName + '\'' +
                '}';
    }
}
