package com.bigshen.chatDemoService.design.builder;

/**
 * @Description:百事可乐
 * @Author: byj
 * @Date: 2019/12/3 15:13
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
