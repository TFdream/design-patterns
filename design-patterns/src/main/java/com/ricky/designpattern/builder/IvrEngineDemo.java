package com.ricky.designpattern.builder;

import com.ricky.designpattern.builder.ch3.Context;
import com.ricky.designpattern.builder.ch3.IvrEngineConfiguration;
import com.ricky.designpattern.builder.ch3.IvrEngine;

public class IvrEngineDemo {

	public static void main(String[] args) {
		
				
		IvrEngineConfiguration configuration = new IvrEngineConfiguration.Builder(new Context())
				.apiKey("abc")
				.secretKey("123")
				.create();
		
		IvrEngine ivrEngine = IvrEngine.getInstance();
		
		//初始化
		ivrEngine.init(configuration);
		
		//获取10086语音菜单
		ivrEngine.getIvrMenu("10086");
	}

}
