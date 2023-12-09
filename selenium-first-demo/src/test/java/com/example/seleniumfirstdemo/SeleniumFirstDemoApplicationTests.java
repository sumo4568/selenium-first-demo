package com.example.seleniumfirstdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SeleniumFirstDemoApplicationTests {

	@Test
	void checkWebsiteTitle() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://iths.se");
		String actualWebsiteTitle = driver.getTitle();
		Assertions.assertEquals("IT-Högskolan – Här startar din IT-karriär!",actualWebsiteTitle, "The title is not correct" );
	}

}
