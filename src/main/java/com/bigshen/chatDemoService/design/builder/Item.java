package com.bigshen.chatDemoService.design.builder;

/**
 * @Description:食物条目
 * @Author: byj
 * @Date: 2019/12/3 15:11
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
