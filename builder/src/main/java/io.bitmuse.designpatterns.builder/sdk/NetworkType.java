package io.bitmuse.designpatterns.builder.sdk;

/**
 * 手机网络类型
 *
 * @author Ricky Fung
 */
public enum NetworkType {
    MOBILE("2G/3G/4G"), WIFI("WIFI"), ALL("");
    private String type;
    NetworkType(String type){
        this.type = type;
    }
}
