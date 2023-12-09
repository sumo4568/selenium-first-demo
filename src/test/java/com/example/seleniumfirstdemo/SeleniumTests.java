package com.example.seleniumfirstdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

class SeleniumTests {

    private static WebDriver driver;

    private static WebDriverWait webDriverWait;

    @BeforeAll
    static void setup() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
    void checkStartPageLogoByClassName(){
        boolean startPageLogoPresent = driver.findElement(By.className("brand")).isDisplayed();
        Assertions.assertTrue(startPageLogoPresent);
    }

    @Test
    void checkFooterByTag(){
        boolean frontPageBannerImagePresent  = driver.findElement(By.tagName("footer")).isDisplayed();
        Assertions.assertTrue(frontPageBannerImagePresent);
    }

    @Test
    void checkElementById() {
        WebElement element = driver.findElement(By.id("nav-liafrfretag"));
        Assertions.assertEquals(true, element.isDisplayed());
    }

    @Test
    void checkElementByCSSSelector()  throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("#nav-nyheter"));
        Assertions.assertEquals(true, element.isEnabled());
    }

    @Test
    void checkClickOnMenuKontakt(){
        WebElement menuLink = driver.findElement(By.xpath("//*[@id=\"nav-kontakt\"]"));
        menuLink.click();
        String actualWebsiteTitle = driver.getTitle();
        Assertions.assertEquals("Kontakt IT-Högskolan", actualWebsiteTitle, "The title is not correct");
        driver.navigate().back();
    }

    @Test
    void checkClickOnMenuStudentPortal(){
        WebElement menuLink = driver.findElement(By.xpath("//*[@id=\"nav-studentportaliclassfarfasigninalti\"]"));
        menuLink.click();
        String actualWebsiteUrl = driver.getCurrentUrl();
        Assertions.assertEquals(true, actualWebsiteUrl.contains("ithsdistans"), "The title is not correct");
        driver.navigate().back();
    }

    @Test
    void checkClickOnAnyCourse() throws InterruptedException {
        WebElement menuLink = driver.findElement(By.xpath("//*[@id=\"nav-utbildningar\"]/a"));
        menuLink.click();
        String actualWebsiteTitle = driver.getTitle();
        Assertions.assertEquals("Utbildningar | iths.se", actualWebsiteTitle, "The title is not correct");
        List<WebElement> courseLinks = driver.findElements(By.className("course-card"));
        Thread.sleep(10000);
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"search-filter-results-4749\"]/div/div[1]/div/div[1]/h2/a/span"));
        String textInLink = titleElement.getText();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(courseLinks.get(0)));
        courseLinks.get(0).click();
        String pageTitle = driver.getTitle();
        Assertions.assertEquals(true, pageTitle.contains(textInLink), "The title is not correct");
        clickOnHomeMenu();
    }

    void clickOnHomeMenu() {
        driver.findElement(By.xpath("//*[@id=\"logo\"]")).click();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

}