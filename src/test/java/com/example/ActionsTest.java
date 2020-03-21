package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
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
    public void elementSendKeys(){
        // Its applicable for text box and text area
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Phones");
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(), "Search results for: 'Phones'");

    }

    @Test
    public void elementSendKeysCompositeExample(){
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "phones"));
        searchBox.submit();
        Assert.assertEquals(driver.getTitle(), "Search results for: 'PHONES'");
    }

    @Test
    public void elementClearExample(){
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "phones"));
        searchBox.clear();
    }

    @Test
    public void elementSubmitExample(){
        // The submit() action can be taken on a Form or on an element, which is inside a Form element.
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(Keys.chord(Keys.SHIFT, "phones"));
        searchBox.submit();
    }


    @AfterMethod
    public void afterMethod(){
        // close webdriver
        driver.quit();
    }
}
