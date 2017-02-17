package com.bytebeats.pattern.builder.ch6;

import com.bytebeats.pattern.builder.ch6.ApplePCBuilder;
import com.bytebeats.pattern.builder.ch6.Builder;
import com.bytebeats.pattern.builder.ch6.Director;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:55
 */
public class ComputerBuildDemo {

    public static void main(String[] args){

        // 构建器
        Builder builder = new ApplePCBuilder();
        // Director
        Director director = new Director(builder);
        // 封装构建过程
        director.construct("Intel 2.2GHz Core i7", "16GB 1600MHz DDR3L", "512GB SSD", "OS X");
        // 构建电脑, 输出相关信息
        System.out.println("Computer Info : " + builder.create());
    }
}
