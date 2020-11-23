package com.bigshen.chatDemoService.leetcode;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IsPalindrome
 * @Description: TODO
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @Author BYJ
 * @Date 2020/6/10
 * @Version V1.0
 **/
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        int rem=0,y=0;
        int quo=x;
        while(quo!=0){
            rem=quo%10;
            y=y*10+rem;
            quo=quo/10;
        }
        return y==x;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(456654);
        System.out.println(palindrome);
    }
}
