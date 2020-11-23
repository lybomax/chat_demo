package com.bigshen.chatDemoService.design.abstractFactory;

/**
 * @Description:
 * @Author: byj
 * @Date: 2019/12/3 14:33
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
