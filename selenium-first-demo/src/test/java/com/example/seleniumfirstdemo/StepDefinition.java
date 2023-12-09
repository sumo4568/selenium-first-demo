package com.example.seleniumfirstdemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Background;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinition {
    static WebDriver driver;




    @Given("IT - Högskolan is available")
    public void iths_se_is_available() {
        driver = new FirefoxDriver();

    }
    @When("User visits IT - Högskolan")
    public void user_visits_iths_se() {
        driver.get("https://iths.se");

    }
    @Then("The title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String websiteTitle= driver.getTitle();
        Assertions.assertEquals(expectedTitle,websiteTitle ,"The title is not correct" );

    }

    @Then("The correct background image is {string}")
    public void the_correct_background_image_is(String expectedImage) {
        boolean backgroundImagePresent  = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div/div[1]/div")).isDisplayed();
        Assertions.assertTrue(backgroundImagePresent);
    }
    @Then("The correct front page logo is {string}")
    public void the_correct_front_page_logo_is(String expectedLogo) {
        boolean frontPageLogoPresent = driver.findElement(By.xpath("//*[@id=\"logo\"]")).isDisplayed();
        Assertions.assertTrue(frontPageLogoPresent);
    }

    @Then("The front page heading should be {string}")
    public void the_front_page_heading_should_be(String string) {
        WebElement frontHeading = driver.findElement(By.tagName("h1"));
        String frontHeadingText = frontHeading.getText();
        Assertions.assertEquals( "Här startar din IT-karriär!", frontHeadingText, "The heading is not correct" );
    }
    @Then("The front page preheader should be {string}")
    public void the_front_page_preheader_should_be(String string) {
        WebElement frontPreheader = driver.findElement(By.tagName("p"));
        String frontPreheaderText = frontPreheader.getText();
        Assertions.assertEquals( "VÄLKOMMEN TILL IT-HÖGSKOLAN", frontPreheaderText, "The heading is not correct" );
    }

    @Then("The start page logo should be should be \"\"brand\"\"")
    public void the_start_page_logo_should_be_should_be_brand() {
        boolean startPageLogoPresent = driver.findElement(By.className("brand")).isDisplayed();
        Assertions.assertTrue(startPageLogoPresent);
    }

    @Then("the site should navigate forward")
    public void the_site_should_navigate_forward() {
        driver.navigate().forward();
    }
    @Then("the site should navigate back")
    public void the_site_should_navigate_back() {
        driver.navigate().back();
    }

    @Then("The site should refresh")
    public void the_site_should_refresh() {

                driver.navigate().refresh();
        }
    @Then("The start page logo should be should be {string}")
    public void the_start_page_logo_should_be_should_be(String string) {
        boolean frontPageBannerImagePresent  = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div/div[2]/div[1]/div/div/a/div/div[1]")).isDisplayed();
        Assertions.assertTrue(frontPageBannerImagePresent);
    }

}


