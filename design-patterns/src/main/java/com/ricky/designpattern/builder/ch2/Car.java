package com.ricky.designpattern.builder.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-06 15:38
 */
public class Car {
    private final String manufacturer;    //制造商
    private final String brand;   //品牌
    private final String model;   //型号
    private final String producingArea;   //产地
    private final String producingDate;   //生产时间
    private final Engine engine;
    private final Wheel wheel;
    private final Light light;

    Car(String manufacturer, String brand, String model, String producingArea,
        String producingDate, Engine engine, Wheel wheel, Light light) {
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.model = model;
        this.producingArea = producingArea;
        this.producingDate = producingDate;
        this.engine = engine;
        this.wheel = wheel;
        this.light = light;
    }

    public String getManufacturer() {
		return manufacturer;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getProducingArea() {
		return producingArea;
	}

	public String getProducingDate() {
		return producingDate;
	}

	public Engine getEngine() {
		return engine;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public Light getLight() {
		return light;
	}

	public static class Builder{
        private String manufacturer;    //制造商
        private String brand;   //品牌
        private String model;   //型号
        private String producingArea;   //产地
        private String producingDate;   //生产时间
        private Engine engine;
        private Wheel wheel;
        private Light light;

        public Builder(String manufacturer, String brand, String model) {
            this.manufacturer = manufacturer;
            this.brand = brand;
            this.model = model;
        }

        public Builder producingArea(String producingArea){
            this.producingArea = producingArea;
            return this;
        }

        public Builder producingDate(String producingDate){
            this.producingDate = producingDate;
            return this;
        }

        public Builder engine(Engine engine){
            this.engine = engine;
            return this;
        }
        public Builder wheel(Wheel wheel){
            this.wheel = wheel;
            return this;
        }
        public Builder light(Light light){
            this.light = light;
            return this;
        }

        public Car build(){

            return new Car(manufacturer, brand, model, producingArea, producingDate, engine, wheel, light);
        }
    }
}
