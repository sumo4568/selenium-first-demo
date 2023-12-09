package com.example.seleniumfirstdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

class SeleniumTests {
    private static WebDriver driver;
    @BeforeAll
    static void setup() {
        driver = new FirefoxDriver();
        driver.get("https://iths.se");
    }
    @Test
    void checkWebsiteTitle(){
        String actualWebsiteTitle = driver.getTitle();
        Assertions.assertEquals("IT-Högskolan – Här startar din IT-karriär!", actualWebsiteTitle, "The title is not correct");
    }
    @Test
     void checkBackgroundImage(){
        boolean backgroundImagePresent  = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div/div[1]/div")).isDisplayed();
        Assertions.assertTrue(backgroundImagePresent);
    }
    @Test
     void checkfrontPageLogo(){
        boolean frontPageLogoPresent = driver.findElement(By.xpath("//*[@id=\"logo\"]")).isDisplayed();
        Assertions.assertTrue(frontPageLogoPresent);
    }
    @Test
    void checkFrontpageHeading(){
        WebElement frontHeading = driver.findElement(By.tagName("h1"));
        String frontHeadingText = frontHeading.getText();
        Assertions.assertEquals( "Här startar din IT-karriär!", frontHeadingText, "The heading is not correct" );
        }
@Test
void checkFrontpagePreheader(){
    WebElement frontPreheader = driver.findElement(By.tagName("p"));
    String frontPreheaderText = frontPreheader.getText();
    Assertions.assertEquals( "VÄLKOMMEN TILL IT-HÖGSKOLAN", frontPreheaderText, "The heading is not correct" );
}
    @Test
    void checkstartPageLogo(){
        boolean startPageLogoPresent = driver.findElement(By.className("brand")).isDisplayed();
        Assertions.assertTrue(startPageLogoPresent);
    }

    @Test
    void checkForwardNavigation(){
        driver.navigate().forward();
    }
    @Test
      void checkPageGetRefresh(){
        driver.navigate().refresh();
    }

     @Test
    void checkBackwardNavigation(){
        driver.navigate().back();
    }
    @Test
    void checkFrontPageBannerImageImage(){
        boolean frontPageBannerImagePresent  = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div/div[2]/div[1]/div/div/a/div/div[1]")).isDisplayed();
        Assertions.assertTrue(frontPageBannerImagePresent);
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

}