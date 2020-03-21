package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttributesTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/vbogaraj/Documents/practice/java_workspace/java-learning/seleniumTests/src/test/resources/chromedriver");
        // initialize chrome driver
        driver = new ChromeDriver();
        // navigate to home page
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test
    public void AttributesTest(){
        WebElement searchBox = driver.findElement(By.id("search"));
        System.out.println("name" + searchBox.getAttribute("name"));
        System.out.println("class" + searchBox.getAttribute("class"));
        System.out.println("place holder" + searchBox.getAttribute("placeholder"));
    }

    @Test
    public void getText(){
        WebElement siteNotice = driver.findElement(By
                .className("global-site-notice"));
        System.out.println(siteNotice.getText());
    }

    @Test
    public void elementGetCssValueExample() {
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Font of the box is: "
                + searchBox.getCssValue("font-family"));
    }

    @Test
    public void elementGetLocation(){
        //  gives cooridinates of element
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Location of the box is: "
                + searchBox.getLocation());
    }

    @Test
    public void elementGetSize(){
        //  gives width and height of element
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("size of the box is: "
                + searchBox.getSize());
    }

    @Test
    public void elementGetTagNameExample() {
        WebElement searchButton = driver.findElement(By.className("search-button"));
        System.out.println("Html tag of the button is: "
                + searchButton.getTagName());
    }

    @AfterMethod
    public void tearDown(){
        // quit browser
        driver.quit();
    }
}
