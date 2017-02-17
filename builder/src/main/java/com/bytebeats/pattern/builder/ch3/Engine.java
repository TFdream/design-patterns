package com.bytebeats.pattern.builder.ch3;

/**
 * 汽车发动机
 *
 * @author Ricky Fung
 * @create 2016-07-06 15:42
 */
public class Engine {
    private final String pl;  //排量
    private final String maxOutputPower; //最大输出功率
    private final int rpm;  //转速

    Engine(String pl, String maxOutputPower, int rpm) {
        this.pl = pl;
        this.maxOutputPower = maxOutputPower;
        this.rpm = rpm;
    }

    public String getPl() {
		return pl;
	}

	public String getMaxOutputPower() {
		return maxOutputPower;
	}

	public int getRpm() {
		return rpm;
	}

	public static Builder custom(){

        return new Builder();
    }

    public static class Builder{
        private String pl;  //排量
        private String maxOutputPower; //最大输出功率
        private int rpm;  //转速

        public Builder pl(String pl){
            this.pl = pl;
            return this;
        }

        public Builder maxOutputPower(String maxOutputPower){
            this.maxOutputPower = maxOutputPower;
            return this;
        }

        public Builder rpm(int rpm){
            this.rpm = rpm;
            return this;
        }

        public Engine build(){

            return new Engine(pl, maxOutputPower, rpm);
        }
    }
}
