package io.bitmuse.designpatterns.builder;

import io.bitmuse.designpatterns.builder.complex.Car;
import io.bitmuse.designpatterns.builder.complex.Engine;
import io.bitmuse.designpatterns.builder.complex.Light;
import io.bitmuse.designpatterns.builder.complex.Wheel;

/**
 * 汽车组装
 * @author Ricky Fung
 */
public class CarDemo {

    public static void main(String[] args){

        Car car = new Car.Builder("Audi", "奥迪", "Q5")
                .producingArea("中国大陆")
                .producingDate("2016-07-01 00:00:00")
                .engine(Engine.custom()
                        .pl("2L")
                        .maxOutputPower("110kW")
                        .rpm(5400)
                        .build())
                .wheel(Wheel.custom()
                        .brand("AA")
                        .producingDate("2016-03-01 00:00:00")
                        .build())
                .light(Light.custom()
                        .brand("5A")
                        .structure("隔热玻璃")
                        .producingDate("2016-02-01 00:00:00")
                        .build())
                .build();

        System.out.println(car);
    }
}
