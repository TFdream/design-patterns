package com.bytebeats.pattern.builder.ch3;

/**
 * 车灯
 *
 * @author Ricky Fung
 * @create 2016-07-06 15:43
 */
public class Light {
    private String brand;
    private String structure;   //结构
    private String producingDate;

    Light(String brand, String structure, String producingDate) {
        this.brand = brand;
        this.structure = structure;
        this.producingDate = producingDate;
    }

    public String getBrand() {
		return brand;
	}

	public String getStructure() {
		return structure;
	}

	public String getProducingDate() {
		return producingDate;
	}

	public static Builder custom(){

        return new Builder();
    }

    public static class Builder{
        private String brand;
        private String structure;   //结构
        private String producingDate;

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder structure(String structure){
            this.structure = structure;
            return this;
        }

        public Builder producingDate(String producingDate){
            this.producingDate = producingDate;
            return this;
        }

        public Light build(){

            return new Light(brand, structure, producingDate);
        }
    }
}
