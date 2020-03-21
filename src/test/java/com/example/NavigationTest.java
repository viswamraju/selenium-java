package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){

        // Set path of chrome driver executable
        System.setProperty("webdriver.chrome.driver",
                "/Users/vbogaraj/Documents/practice/java_workspace/java-learning/seleniumTests/src/test/resources/chromedriver");
        // initialize chrome driver
        driver = new ChromeDriver();
        // navigate to home page
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test
    public void navigateToUrl(){
        // find search box and enter search String
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Phones");
        WebElement searchButton = driver.findElement(By.className("search-button"));
        searchButton.submit();
        Assert.assertEquals(driver.getTitle(), "Search results for: 'Phones'");

    }

    @AfterMethod
    public void afterMethod(){
        // close webdriver
        driver.quit();
    }
}
