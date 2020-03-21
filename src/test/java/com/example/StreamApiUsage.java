package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApiUsage {

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
    public void linksTest(){
        List<WebElement> links = driver.findElements(By.tagName("a"));

        long count = links.stream()
                .filter(WebElement::isDisplayed)
                .count();
        System.out.println("Displayed links count: " + count);
    }

    @Test
    public void imageAltTest(){
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total Images: " + images.size());

        List<WebElement> imagesWithOutAlt = images.stream()
                .filter(item -> item.getAttribute("alt") == "")
                .collect(Collectors.toList());

        System.out.println("Total images without alt attribute " + imagesWithOutAlt);
    }

    @AfterMethod
    public void tearDown(){
        // quits browser
        driver.quit();
    }
}
