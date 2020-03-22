package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompositeAction {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/vbogaraj/Documents/practice/java_workspace/java-learning/seleniumTests/src/test/resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://guidebook.seleniumacademy.com/Selectable.html");
    }

    @Test
    public void PerformCompositeAction(){

        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));

        // Add all actions into the action builder
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(one)
                .click(three)
                .click(five)
                .keyUp(Keys.CONTROL);

        // Generate the composite Action
        Action compositeAction = actions.build();
        compositeAction.perform();
    }

    @AfterMethod
    public void tearDown(){
        // quit the browser
        driver.quit();
    }
}
