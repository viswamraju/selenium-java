package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementStateTest {

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
    public void isDisplayedExample(){
        // The isDisplayed action verifies whether an element is displayed on the web page and can be executed on all the WebElements
        WebElement searchBox = driver.findElement(By.id("search"));
        System.out.println(searchBox.isDisplayed());
    }

    @Test
    public void isEnabledExample(){
        // The isEnabled action verifies whether an element is enabled on the web page and can be executed on all the WebElements
        WebElement searchBox = driver.findElement(By.id("search"));
        System.out.println(searchBox.isEnabled());
    }
    @Test
    public void isSelectedExample(){
        // The isSelected method returns a boolean value if an element is selected on the web page and can be executed only on a radio button, options in select, and checkbox WebElements.
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Search box is selected: "
                + searchBox.isSelected());
        // returns false as it is text box
    }

    @AfterMethod
    public void tearDown(){
        // quit browser
        driver.quit();
    }

}
