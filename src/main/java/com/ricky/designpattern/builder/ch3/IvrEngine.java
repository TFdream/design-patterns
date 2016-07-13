package com.ricky.designpattern.builder.ch3;

/**
 * IVR Engine
 * 
 * @author Ricky Feng
 * @create 2015-01-31 14:50
 */
public class IvrEngine {
	
	private volatile static IvrEngine instance;
	
	private IvrEngineConfiguration configuration;
	
	private IvrEngine() {
		
	}

	public static IvrEngine getInstance() {
		if(instance==null){
			synchronized (IvrEngine.class) {
				if(instance==null){
					instance = new IvrEngine();
				}
			}
		}
		return instance;
	}
	
	/** init IvrEngine **/
	public synchronized void init(IvrEngineConfiguration configuration) {
		
		if (configuration == null) {
			throw new IllegalArgumentException("IvrEngine configuration can not be initialized with null!");
		}
		
		if (this.configuration == null) {
			System.out.println("IvrEngine init.");
			doIvrInit(configuration);
			this.configuration = configuration;			
		}else{
			System.out.println("IvrEngine has already been initialized before!");
		}		
	}
	
	public String getIvrMenu(String phone){
		
		return phone;
	}

	public boolean isInited() {
		return configuration != null;
	}
	
	public void destroy() {
		if(configuration!=null){
			System.out.println("IvrEngine destroy.");
		}
		configuration = null;	
	}

	private void doIvrInit(IvrEngineConfiguration configuration) {
		//TODO
		System.out.println("init configuration:"+configuration);
	}
}
