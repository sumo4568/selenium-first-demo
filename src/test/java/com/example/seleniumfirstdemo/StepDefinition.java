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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;

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




    @Then("the footer should be {string}")
    public void the_footer_should_be(String string) {
        boolean frontPageBannerImagePresent  = driver.findElement(By.tagName("footer")).isDisplayed();
        Assertions.assertTrue(frontPageBannerImagePresent);
    }

    @Then("the element should be {string}")
    public void the_element_should_be(String string) {
        WebElement element = driver.findElement(By.id("nav-liafrfretag"));
        Assertions.assertEquals(true, element.isDisplayed());

    }
    @Then("The site should {string}")
    public void the_site_should(String string) {
        WebElement element = driver.findElement(By.cssSelector("#nav-nyheter"));
        Assertions.assertEquals(true, element.isEnabled());

    }
    @Then("The menu kontakt should be clicked and show  {string}")
    public void the_menu_kontakt_should_be_clicked_and_show(String string) {
        WebElement menuLink = driver.findElement(By.xpath("//*[@id=\"nav-kontakt\"]"));
        menuLink.click();
        String actualWebsiteTitle = driver.getTitle();
        Assertions.assertEquals("Kontakt IT-Högskolan", actualWebsiteTitle, "The title is not correct");
        driver.navigate().back();

    }
    @Then("The menu StudentPortal {string}")
    public void the_menu_student_portal(String string) {
        WebElement menuLink = driver.findElement(By.xpath("//*[@id=\"nav-studentportaliclassfarfasigninalti\"]"));
        menuLink.click();
        String actualWebsiteUrl = driver.getCurrentUrl();
        Assertions.assertEquals(true, actualWebsiteUrl.contains("ithsdistans"), "The title is not correct");
        driver.navigate().back();

    }
    @Then("The any course should be clicked and show  \\/\\/*[@id=\\{string},{string},{string}")
    public void the_any_course_should_be_clicked_and_show_id(String string, String string2, String string3) {
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

}


