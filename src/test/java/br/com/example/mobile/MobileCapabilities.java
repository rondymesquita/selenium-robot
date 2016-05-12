package br.com.example.mobile;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class MobileCapabilities {

	private static DesiredCapabilities desiredCapabilities;

	public static DesiredCapabilities buildToSelendroid(){
		desiredCapabilities = DesiredCapabilities.android();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MotoX");
		desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "4.4");
		//desiredCapabilities.setCapability("browser", "chrome");
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,  MobileBrowserType.CHROME);
		return desiredCapabilities;
	}

	public static DesiredCapabilities buildToAppium(){
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MotoX");
		desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "4.4");
		//		desiredCapabilities.setCapability("app", appFile.getAbsolutePath());
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		return desiredCapabilities;
	}
	
}
