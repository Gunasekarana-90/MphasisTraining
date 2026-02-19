package com.trainee.com;
 
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class CookiesDemoTest {
 
	private WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=(WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	@AfterMethod(alwaysRun=true)
		public void teardown() {
			
		}
	public boolean isSecure() {
		return false;
		
	}
		//Exception invalid because of the
		@Test
		public void addAndDeleteCookies_demo() {
			driver.get("https://the-internet.herokuapp.com/");
			Cookie myCookie=new Cookie("traineeCookie", "Manisha123");
			driver.manage().addCookie(myCookie);
			Cookie fetched =driver.manage().getCookieNamed("traineeCookie");
			Assert.assertNotNull(fetched,"Cookie was NOT added");
			Assert.assertEquals(fetched.getValue(),"Manisha123","Cookie value mismatch!");
			System.out.println("Added Cookie :"+fetched);
			Set<Cookie> all =driver.manage().getCookies();
			System.out.println("Total cookies now: "+all.size());
			for(Cookie c:all) {
				System.out.println("Cookie -> "+c.getName() + " = "+c.getValue());
			}
			driver.manage().deleteCookieNamed("traineeCookie");
			Cookie afterDelete=driver.manage().getCookieNamed("traineeCookie");
			Assert.assertNull(afterDelete,"Cookie was NOT deleted!");
			System.out.println("Deleted Cookie traineeCookie");
			driver.manage().deleteAllCookies();
			Assert.assertEquals(driver.manage().getCookies().size(), 0 ,"All Cookies were not deleted!");
			System.out.println("Deleted All Cookies");
			
			
		}
		


		
    // Call this from your test setup to inject driver
    public void CookieExercises(WebDriver driver) {
        this.driver = driver;
    }
    
    @Test
    public void addAndExerciseAllCookieMethods_demo() {
        driver.get("https://the-internet.herokuapp.com/");

        

        // --- 2) Fetch by name and verify basic getters ---
        Cookie fetched = driver.manage().getCookieNamed("traineeCookie");
        Assert.assertNotNull(fetched, "Cookie was NOT added");

        // getName / getValue
        Assert.assertEquals(fetched.getName(), "traineeCookie");
        Assert.assertEquals(fetched.getValue(), "Manisha123", "Cookie value mismatch!");

        // getDomain / getPath / getExpiry / isSecure / isHttpOnly / getSameSite
        System.out.println("Fetched Cookie:");
        System.out.println("  name      : " + fetched.getName());
        System.out.println("  value     : " + fetched.getValue());
        System.out.println("  domain    : " + fetched.getDomain());
        System.out.println("  path      : " + fetched.getPath());
        System.out.println("  expiry    : " + fetched.getExpiry());
        System.out.println("  secure    : " + fetched.isSecure());
        System.out.println("  httpOnly  : " + fetched.isHttpOnly());
        System.out.println("  sameSite  : " + fetched.getSameSite());

        // --- 3) equals & hashCode ---
        // Two cookies are equal iff name and value match (domain, path, etc. ignored in equality)
        
    }


		
	
	}
 