package br.com.example.mobile;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by rondymesquita on 05/09/2015
 *
 */
public class MobileCapabilities {

	private static DesiredCapabilities desiredCapabilities;
	
	public static DesiredCapabilities build(){
		desiredCapabilities = SelendroidCapabilities.android();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "MotoX");
		desiredCapabilities.setCapability("version", "19.0.0");
		desiredCapabilities.setCapability("browser", "chrome"); 
		desiredCapabilities.setCapability("browserName", "chrome"); 
//		desiredCapabilities.setCapability("app", appFile.getAbsolutePath());
		return desiredCapabilities;
	}

	public static DesiredCapabilities buildToSelendroid(){
		desiredCapabilities = SelendroidCapabilities.android();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "MotoX");
		desiredCapabilities.setCapability("version", "4.4");
		desiredCapabilities.setCapability("browser", "chrome");
		return desiredCapabilities;
	}

	public static DesiredCapabilities buildToAppium(){
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MotoX");
		desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "4.4");
//		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.BROWSER);
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		return desiredCapabilities;
	}
	
}
