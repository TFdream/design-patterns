package com.bytebeats.pattern.builder.ch4;

import java.io.File;

/**
 * IVR Engine Configuration
 * 
 * @author Ricky Fung
 * @create 2015-01-31 14:20
 */
public class IvrEngineConfiguration {
	private final Context context;
	private final String apiKey;
	private final String secretKey;
	private final File ivrFileDir;
	private final int checkUpdateInterval;	//检查更新频率，单位小时
	private final NetworkType checkUpdateNetworkType; //网络类型：2G/3G/4G/Wifi
	
	private IvrEngineConfiguration(Builder builder) {
		this.context = builder.context;
		this.apiKey = builder.apiKey;
		this.secretKey = builder.secretKey;
		this.ivrFileDir = builder.ivrFileDir;
		this.checkUpdateInterval = builder.checkUpdateInterval;
		this.checkUpdateNetworkType = builder.checkUpdateNetworkType;
	}
	
	public Context getContext() {
		return context;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public File getIvrFileDir() {
		return ivrFileDir;
	}

	public int getCheckUpdateInterval() {
		return checkUpdateInterval;
	}

	public NetworkType getCheckUpdateNetworkType() {
		return checkUpdateNetworkType;
	}

	public static class Builder {
		private Context context;
		private String apiKey;
		private String secretKey;
		private File ivrFileDir;
		private int checkUpdateInterval;
		private NetworkType checkUpdateNetworkType;
		
		public Builder(Context context){
			this.context = context.getApplicationContext();
		}		

		public Builder apiKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		public Builder secretKey(String secretKey) {
			this.secretKey = secretKey;
			return this;
		}
		
		public Builder ivrFileDir(File ivrFileDir) {
			this.ivrFileDir = ivrFileDir;
			return this;
		}
		
		public Builder checkUpdateInterval(int checkUpdateInterval) {
			this.checkUpdateInterval = checkUpdateInterval;
			return this;
		}
		
		public Builder checkUpdateNetworkType(NetworkType checkUpdateNetworkType) {
			this.checkUpdateNetworkType = checkUpdateNetworkType;
			return this;
		}

		public IvrEngineConfiguration create() {
			initEmptyFieldsWithDefaultValues();			
			return new IvrEngineConfiguration(this);
		}

		private void initEmptyFieldsWithDefaultValues() {
			if(ivrFileDir==null){
				ivrFileDir = new File("/ivr/");
			}
			if(checkUpdateInterval<1){
				checkUpdateInterval = 24;
			}
			if(checkUpdateNetworkType==null){
				checkUpdateNetworkType = NetworkType.ALL;
			}
		}
		
	}
}
