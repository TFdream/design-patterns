package com.mindflow.pattern.builder.ch4;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 14:03
 */
public enum NetworkType {
    MOBILE("2G/3G/4G"), WIFI("WIFI"), ALL("");
    private String type;
    NetworkType(String type){
        this.type = type;
    }
}
