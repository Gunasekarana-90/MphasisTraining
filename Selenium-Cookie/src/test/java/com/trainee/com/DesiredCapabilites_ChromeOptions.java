package com.trainee.com;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DesiredCapabilites_ChromeOptions {
		@Test
		public void localCapabilites_modernOptions_demo() {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setAcceptInsecureCerts(true);
			options.hashCode();
			
			
			WebDriver driver = new ChromeDriver(options);
			
			try {
				driver.get("https://the-internet.herokuapp.com/");
				
				
				Capabilities caps = ((HasCapabilities) driver).getCapabilities();
				System.out.println("Broser: "+caps.getBrowserName());
				System.out.println("Browser Version: "+caps.getBrowserVersion());
				System.out.println("Platform: "+caps.getPlatformName());
				Map<String, Object> chromeOpts = (Map<String, Object>) caps.getCapability("google:chromeOptions");
				if (chromeOpts != null) {
				    System.out.println("Chrome options: " + chromeOpts);
				    // Example: detect headless
				    List<String> args = (List<String>) chromeOpts.get("args");
				    boolean isHeadless = args != null && args.stream().anyMatch(a -> a.contains("headless"));
				    System.out.println("Headless? " + isHeadless);
				}
				
			}finally {
				driver.quit();
			}
		}
}
