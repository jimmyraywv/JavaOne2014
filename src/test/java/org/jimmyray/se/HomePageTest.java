package org.jimmyray.se;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.jimmyray.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.saucelabs.common.SauceOnDemandAuthentication;

public class HomePageTest {
	private WebDriver driver;

	private SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication();
/*
	@Before
	public void setUp() throws Exception {
		// Choose the browser, version, and platform to test
		DesiredCapabilities capabilities = DesiredCapabilities.safari();
		capabilities.setCapability("version", "7");
		capabilities.setCapability("platform", Platform.MAC);

		// set auth
		this.authentication.setUsername(Properties.readPropertyOrEnv(
				"SAUCE_USER_NAME", ""));
		this.authentication.setAccessKey(Properties.readPropertyOrEnv(
				"SAUCE_API_KEY", ""));

		// Create the connection to Sauce Labs to run the tests
		this.driver = new RemoteWebDriver(new URL("http://"
				+ this.authentication.getUsername() + ":"
				+ this.authentication.getAccessKey()
				+ "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
	}

	@Test
	public void webDriver() throws Exception {
		// Make the browser get the page and check its title
		this.driver.get("http://www.jimmyray.org/");
		assertEquals("CloudBees Hello World", this.driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		if (this.driver != null) {
			this.driver.quit();
		}
	}
*/
}
