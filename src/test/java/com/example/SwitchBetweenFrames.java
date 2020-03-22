package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchBetweenFrames {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/vbogaraj/Documents/practice/java_workspace/java-learning/seleniumTests/src/test/resources/chromedriver");
        // initialize chrome driver
        driver = new ChromeDriver();
        driver.get("http://guidebook.seleniumacademy.com/Frames.html");
    }

    @Test
    public void switchBetweenFrames() throws InterruptedException{

        Thread.sleep(2000);
        // First frame
        driver.switchTo().frame(0);
        WebElement firstField = driver.findElement(By.name("1"));
        firstField.sendKeys("I'm Frame One");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        // Second Frame
        driver.switchTo().frame(1);
        WebElement secondField = driver.findElement(By.name("2"));
        secondField.sendKeys("I'm Frame Two");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
