package com.bigshen.chatDemoService.design.bridge;

/**
 * @ClassName GreenCircle
 * @Description: TODO 创建实现了 DrawAPI 接口的实体桥接实现类
 * @Author BYJ
 * @Date 2020/5/26
 * @Version V1.0
 **/
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}